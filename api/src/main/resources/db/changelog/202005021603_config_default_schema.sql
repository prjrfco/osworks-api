--liquibase formatted sql

--changeset bob:1

GRANT ALL ON SCHEMA osworks TO francisco;

SET search_path TO osworks;

ALTER database postgres SET search_path TO osworks;