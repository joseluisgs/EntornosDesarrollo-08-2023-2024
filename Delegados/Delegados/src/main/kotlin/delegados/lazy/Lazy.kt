package dev.joseluisgs.lazy

import org.lighthousegames.logging.logging

private val logger = logging()

class NoLazy {
    val valor: String = getValorFromDataBase()
    val otro = "Otro valor"
    fun getValorFromDataBase(): String {
        println("Obteniendo valor de la base de datos")
        Thread.sleep(10000)
        return "Valor"
    }

    override fun toString(): String {
        return "NoLazy(valor='$valor', otro='$otro')"
    }
}

class Lazy {
    val valor: String by lazy { getValorFromDataBase() }
    val otro = "Otro valor"
    fun getValorFromDataBase(): String {
        println("Obteniendo valor de la base de datos")
        Thread.sleep(10000)
        return "Valor"
    }

    override fun toString(): String {
        return "NoLazy(valor='$valor', otro='$otro')"
    }
}