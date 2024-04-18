package dev.joseluisgs

import koin.personas.PersonasApp
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.core.context.GlobalContext.startKoin
import org.koin.fileProperties
import org.koin.ksp.generated.defaultModule

@OptIn(KoinExperimentalAPI::class)
fun main() {
    println("Hola Koin")

    startKoin {
        // declare used logger
        printLogger()
        // Leemos las propiedades de un fichero
        fileProperties() // Por defecto busca en src/main/resources/koin.properties, pero puede ser otro fichero si se lo pasas como parametro
        // declara modulos de inyección de dependencias, pero lo verificamos antes de inyectarlos
        modules(defaultModule)
    }


    val app = PersonasApp()
    app.run()
}