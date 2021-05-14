package br.edu.facec.cliente.resource

import br.edu.facec.cliente.dto.ClienteDTO
import br.edu.facec.cliente.entity.Cliente
import br.edu.facec.cliente.entity.Endereco
import br.edu.facec.cliente.service.ClienteService
import br.edu.facec.cliente.service.EnderecoService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid


@RestController
class ClienteResource(val service: ClienteService, val enderecoService: EnderecoService) {

    @GetMapping("/clientes")
    fun getAll(pageable: Pageable): ResponseEntity<Page<Cliente>> {
        val page = service.findAll(pageable)
        return ResponseEntity.ok(page)
    }

    @GetMapping("/cliente/{id}")
    fun getById(@PathVariable("id") id: UUID): ResponseEntity<Cliente> {
        val found = service.findById(id)
        return ResponseEntity.ok(found)
    }

    @PostMapping("/clientes")
    fun post(@Valid @RequestBody clienteDTO: ClienteDTO): ResponseEntity<Cliente> {
        val cliente: Cliente = service.fromDto(clienteDTO)
        val saved = service.save(cliente)
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(saved)
    }

    @PutMapping("/cliente/{id}")
    fun put(@PathVariable("id") id: UUID, @Valid @RequestBody clienteDTO: ClienteDTO): ResponseEntity<Cliente> {
        if (!service.exists(id)) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build()
        }


        val endereco = Endereco(id = null, logradouro =  clienteDTO.logradouro, bairro = clienteDTO.bairro, cep = clienteDTO.cep, numero = clienteDTO.numero, complemento = clienteDTO.complemento, cidadeId = clienteDTO.cidadeId)
        val toUpdate = Cliente(id = id, nome = clienteDTO.nome, cpfCnpj = clienteDTO.cpfCnpj, sexo = clienteDTO.sexo, endereco = endereco)
        val saved = service.save(toUpdate)
        return ResponseEntity.ok(saved)
    }

    @DeleteMapping("/cliente/{id}")
    fun delete(@PathVariable("id") id: UUID): ResponseEntity<Cliente> {
        if (!service.exists(id)) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build()
        }
        service.deleteById(id)
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build()
    }
}