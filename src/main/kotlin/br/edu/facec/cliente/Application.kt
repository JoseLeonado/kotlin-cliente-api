package br.edu.facec.cliente

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@SpringBootApplication
open class Application

fun main(args: Array<String>) {
	runApplication<Application>(*args)
}
