package br.edu.facec.cliente.entity

import org.hibernate.validator.constraints.Length
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Entity
data class Endereco(

        @Id
        @GeneratedValue
        val id: UUID?,

        @field:NotBlank(message = "Rua deve ser informada.")
        val logradouro: String,

        @field:NotBlank(message = "Bairro do Estado deve ser informado.")
        val bairro: String,

        @field:NotBlank(message = "CEP do Estado deve ser informado.")
        val cep: String,

        val numero: String,

        @field:NotBlank(message = "Complemento deve ser informado.")
        val complemento: String,

        @Column(name = "cidade_fk")
        @field:NotNull(message = "Cidade deve ser informada!")
        val cidadeId: UUID,
)
