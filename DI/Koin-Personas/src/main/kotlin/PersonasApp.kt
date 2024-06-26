package koin.personas

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.qualifier.named
import personas.controllers.PersonasController
import personas.models.Persona

class PersonasApp : KoinComponent {
    val contRepoStorageBD: PersonasController by inject(named("PersonasDataBaseController"))
    val contRepoStorageFile: PersonasController by inject(named("PersonasFileController"))
    val contPorDefecto: PersonasController by inject()


    fun run() {
        println("Personas: Model->Controller->Repository->Storage(Database|File)")
        println("===============================================================")
        val p = Persona(nombre = "Juan", apellido = "Perez", dni = "12345678")
        println(p)
        println()

        println("Personas: Model->Controller->Repository->Storage(Database)")
        println(contRepoStorageBD)
        var resBD = contRepoStorageBD.save(p)
        println("Resultado BD: $resBD")
        println()

        println("Personas: Model->Controller->Repository->Storage(File)")
        println(contRepoStorageFile)
        resBD = contRepoStorageFile.save(p)
        println("Resultado File: $resBD")
        println()

        println("Personas: Model->Controller->Repository->Storage(Por Defecto)")
        println(contPorDefecto)
        val res = contPorDefecto.save(p)
        println("Resultado Por Defecto: $res")
        println()
    }
}
