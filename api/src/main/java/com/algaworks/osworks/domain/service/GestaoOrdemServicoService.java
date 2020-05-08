package com.algaworks.osworks.domain.service;

import com.algaworks.osworks.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.osworks.domain.exception.NegocioException;
import com.algaworks.osworks.domain.model.Cliente;
import com.algaworks.osworks.domain.model.Comentario;
import com.algaworks.osworks.domain.model.OrdemServico;
import com.algaworks.osworks.domain.model.StatusOrdemServico;
import com.algaworks.osworks.domain.repository.ClienteRepository;
import com.algaworks.osworks.domain.repository.ComentarioRepository;
import com.algaworks.osworks.domain.repository.OrdemServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
public class GestaoOrdemServicoService {

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ComentarioRepository comentarioRepository;

    public OrdemServico criar(OrdemServico ordemServico){
        Cliente cliente = clienteRepository.findById(ordemServico.getCliente().getId())
                .orElseThrow(() -> new NegocioException("Cliente não encontrado"));

        ordemServico.setCliente(cliente);
        ordemServico.setStatusOrdemServico(StatusOrdemServico.ABERTA);
        ordemServico.setDataAbertura(OffsetDateTime.now().withNano(0));

        return ordemServicoRepository.save(ordemServico);
    }

    public void finalizar(Long id){
        OrdemServico ordemServico = buscar(id);

        ordemServico.finalizar();

        ordemServicoRepository.save(ordemServico);
    }

    public void cancelar(Long id){
        OrdemServico ordemServico = buscar(id);

        ordemServico.cancelar();

        ordemServicoRepository.save(ordemServico);
    }

    public Comentario adicionarComentario(Long id, String descricao){
        OrdemServico ordemServico = buscar(id);

        Comentario comentario = new Comentario();
        comentario.setDataEnvio(OffsetDateTime.now().withNano(0));
        comentario.setDescricao(descricao);
        comentario.setOrdemServico(ordemServico);

        return comentarioRepository.save(comentario);
    }

    private OrdemServico buscar(Long id) {
        return ordemServicoRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Ordem de Serviço não encontrada"));
    }
}
