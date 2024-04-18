package koin.personas

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import personas.controllers.PersonasController
import personas.models.Persona

class PersonasApp : KoinComponent {
    val contRepoStorageBD: PersonasController by inject()


    fun run() {
        println("Personas: Model->Controller->Repository->Storage(Database|File)")
        println("===============================================================")
        val p = Persona(nombre = "Juan", apellido = "Perez", dni = "12345678")
        println(p)
        println()

        println("Personas: Model->Controller->Repository->Storage(Database)")
        println(contRepoStorageBD)
        val resBD = contRepoStorageBD.save(p)
        println("Resultado BD: $resBD")
        println()

    }
}
