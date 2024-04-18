package dev.joseluisgs

import org.koin.core.context.GlobalContext.startKoin
import org.koin.ksp.generated.defaultModule

fun main() {
    println("Hola Koin")
    startKoin {
        // declare used logger
        printLogger()
        // declara modulos de inyección de dependencias
        // En este caso se declara el módulo defaultModule, porque no se especifica un módulo al crearlos
        modules(defaultModule)
    }

    val app = CafeterasApp()
    app.run()
}