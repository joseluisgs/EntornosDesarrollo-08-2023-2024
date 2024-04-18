package dev.joseluisgs.delegados.vetoable

import kotlin.properties.Delegates

class NoVetoableValue {
    var valor: String = "Hola"
        set(value) {
            if (value.length > 5 || value == "Adios") {
                field = value
            }
        }

    val otro = "Otro valor"

    override fun toString(): String {
        return "NoVetoableValue(valor='$valor', otro='$otro')"
    }
}

class VetoableValue {
    var valor: String by Delegates.vetoable("Hola") { _, old, new ->
        new.length > 5 || new == "Adios"
    }

    val otro = "Otro valor"

    override fun toString(): String {
        return "VetoableValue(valor='$valor', otro='$otro')"
    }
}