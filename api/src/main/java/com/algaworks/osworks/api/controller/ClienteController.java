package com.algaworks.osworks.api.controller;

import com.algaworks.osworks.api.model.ClienteInput;
import com.algaworks.osworks.api.model.ClienteModel;
import com.algaworks.osworks.domain.model.Cliente;
import com.algaworks.osworks.domain.repository.ClienteRepository;
import com.algaworks.osworks.domain.service.CadastroClienteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private CadastroClienteService cadastroCliente;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<ClienteModel> listar(){
        return toCollectionModel(clienteRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteModel> buscar(@PathVariable Long id){

        Optional<Cliente> cliente = clienteRepository.findById(id);

        if(cliente.isPresent()){
            ClienteModel clienteModel = toModel(cliente.get());
            return ResponseEntity.ok(clienteModel);
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteModel adicionar(@Valid @RequestBody ClienteInput clienteInput){
        Cliente cliente = toEntity(clienteInput);
        return toModel(cadastroCliente.salvar(cliente));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteModel> atualizar(@Valid @PathVariable Long id,@Valid @RequestBody ClienteInput clienteInput){

        if(!clienteRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }

        Cliente cliente = toEntity(clienteInput);
        cliente.setId(id);
        ClienteModel clienteModel = toModel(cadastroCliente.salvar(cliente));

        return ResponseEntity.ok(clienteModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id){

        if(!clienteRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }

        cadastroCliente.excluir(id);

        return ResponseEntity.noContent().build();
    }

    private ClienteModel toModel(Cliente cliente){
        return modelMapper.map(cliente, ClienteModel.class);
    }

    private List<ClienteModel> toCollectionModel(List<Cliente> clientes){
        return clientes.stream()
                .map(cliente -> toModel(cliente))
                .collect(Collectors.toList());
    }

    private Cliente toEntity(ClienteInput clienteInput){
        return modelMapper.map(clienteInput, Cliente.class);
    }

}
