package br.edu.facec.cliente.repository

import br.edu.facec.cliente.entity.Estado
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface EstadoRepository: PagingAndSortingRepository<Estado, UUID> {

}