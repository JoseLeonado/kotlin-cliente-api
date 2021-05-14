package br.edu.facec.cliente.service

import br.edu.facec.cliente.dto.ClienteDTO
import br.edu.facec.cliente.entity.Cliente
import br.edu.facec.cliente.entity.Endereco
import br.edu.facec.cliente.repository.ClienteRepository
import br.edu.facec.cliente.repository.EnderecoRepository
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*

@Service
@JsonSerialize
class ClienteService(private val repository: ClienteRepository, private val enderecoRepository: EnderecoRepository) {

    fun findAll(pageable: Pageable) = repository.findAll(pageable)

    fun findById(id: UUID): Cliente? = repository.findByIdOrNull(id)

    fun save (cliente: Cliente): Cliente {
        enderecoRepository.save(cliente.endereco)
        return repository.save(cliente)
    }

    fun fromDto (clienteDTO: ClienteDTO) : Cliente {

        var endereco: Endereco = Endereco(null, clienteDTO.logradouro, clienteDTO.bairro, clienteDTO.cep, clienteDTO.numero, clienteDTO.complemento, clienteDTO.cidadeId)
        var cliente: Cliente = Cliente.dados(null, clienteDTO.nome, clienteDTO.cpfCnpj, Sexo.toEnum(clienteDTO.sexo), endereco)

        cliente.endereco = endereco

        return cliente
    }


    fun exists(id: UUID) = repository.existsById(id)

    fun deleteById(id: UUID) = repository.deleteById(id)


}