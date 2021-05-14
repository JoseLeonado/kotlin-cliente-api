package br.edu.facec.cliente.repository

import br.edu.facec.cliente.entity.Cliente
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ClienteRepository : PagingAndSortingRepository<Cliente, UUID>