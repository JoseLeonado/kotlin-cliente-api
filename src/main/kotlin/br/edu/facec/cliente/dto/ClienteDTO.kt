package br.edu.facec.cliente.dto

import java.util.*

data class ClienteDTO(

        val nome: String,
        val cpfCnpj: String,
        val sexo: Char,

        val logradouro: String,
        val bairro: String,
        val cep: String,
        val numero: String,
        val complemento: String,
        val cidadeId: UUID,

)
