create table endereco
(
    id              uuid          not null,
    logradouro      varchar(100)        not null,
    bairro          varchar(100)        not null,
    cep             varchar(12)         not null,
    numero          varchar(12)         not null,
    complemento     varchar(50)         not null,
    cidade_fk       uuid                not null,
    constraint pk_endereco primary key (id),
    constraint fk_endereco_cidade foreign key (cidade_fk) references cidade (id)
);