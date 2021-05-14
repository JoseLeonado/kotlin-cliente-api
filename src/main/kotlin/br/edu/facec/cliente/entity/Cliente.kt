package br.edu.facec.cliente.entity

import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Entity
data class Cliente(

        @Id
        @GeneratedValue
        var id: UUID?,

        @field:NotBlank(message = "Nome deve ser informado!")
        var nome: String,

        @field:NotBlank(message = "cpfCnpj deve ser informado!")
        var cpfCnpj: String,

        var sexo: Char,

        @OneToOne
        @field:NotNull(message = "Endereco deve ser informado!")
        var endereco: Endereco,

)

