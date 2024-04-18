package dev.joseluisgs

import dev.joseluisgs.delegados.notnull.NotNull
import dev.joseluisgs.delegados.observerdelegado.AlumnoReactivo
import dev.joseluisgs.delegados.personalizado.LimitedIntDelegate
import dev.joseluisgs.delegados.vetoable.NoVetoableValue
import dev.joseluisgs.delegados.vetoable.VetoableValue
import dev.joseluisgs.lazy.Lazy
import dev.joseluisgs.lazy.NoLazy

fun main() {
    println("Delegados")
    val noLazy = NoLazy()
    println("Hola")
    println(noLazy.otro)
    //println(noLazy)
    val lazy = Lazy()
    println("Hola")
    println(lazy.otro)
    println(lazy.valor)
    println(lazy.valor)
    println(lazy)

    val notNull = NotNull()
    //notNull.getValorFromDataBase()
    println(notNull)

    val noVetoableValue = NoVetoableValue()
    noVetoableValue.valor = "Casa"
    println(noVetoableValue.valor)
    println(noVetoableValue)
    noVetoableValue.valor = "Hola de nuevo"
    println(noVetoableValue.valor)
    noVetoableValue.valor = "Adios"
    println(noVetoableValue.valor)
    println(noVetoableValue)

    val vetoableValue = VetoableValue()
    vetoableValue.valor = "Casa"
    println(vetoableValue.valor)
    println(vetoableValue)
    vetoableValue.valor = "Hola de nuevo"
    println(vetoableValue.valor)
    vetoableValue.valor = "Adios"
    println(vetoableValue.valor)
    println(vetoableValue)

    val alumno = AlumnoReactivo()
    alumno.nota = 5
    alumno.nota = 6
    alumno.nota = 2
    alumno.nota = 3
    alumno.nota = 8

    var limitedInt: Int by LimitedIntDelegate(0, 10)
    println(limitedInt)
    limitedInt = 5
    println(limitedInt)
    limitedInt = 15
    println(limitedInt)
}