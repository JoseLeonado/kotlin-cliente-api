create table cliente
(
    id           uuid          not null,
    nome         varchar(100)  not null,
    cpf_cnpj     varchar(16)   not null,
    sexo         varchar(1),
    endereco_id     uuid          not null,
    constraint pk_cliente primary key (id),
    constraint fk_cliente_endereco foreign key (endereco_id) references endereco (id)
);