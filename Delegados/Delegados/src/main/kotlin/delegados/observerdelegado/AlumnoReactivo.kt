package dev.joseluisgs.delegados.observerdelegado

import kotlin.properties.Delegates

class AlumnoReactivo {
    val nombre: String = "Kotlin"
    var nota: Int by Delegates.observable(0) { _, old, newValue ->
        if (newValue > old) {
            println("La nota ha subido de $old a $newValue")
            if (newValue > 5) {
                println("Te guardo el aprobado")
                salvarNota(newValue)
            }
        } else {
            println("La nota ha bajado de $old a $newValue")
        }
    }

    private fun salvarNota(nota: Int) {
        println("Nota salvada en Base de Datos: $nota")
    }
}