package dev.joseluisgs.delegados.personalizado

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class LimitedIntDelegate(private val min: Int, private val max: Int) : ReadWriteProperty<Any, Int> {
    private var value: Int = min

    // El thisRef es el objeto que contiene la propiedad
    // El property es la propiedad que se esta delegando
    // El value es el valor que se le esta asignando a la propiedad
    override fun getValue(thisRef: Any, property: KProperty<*>): Int {
        // devolvemos el valor o el minimo
        return value
    }

    // El thisRef es el objeto que contiene la propiedad
    // El property es la propiedad que se esta delegando
    // El value es el valor que se le esta asignando a la propiedad
    override fun setValue(thisRef: Any, property: KProperty<*>, value: Int) {
        // Si el valor esta entre el minimo y el maximo lo asignamos, si no asignamos el minimo o el maximo
        this.value = if (value in min..max) value else if (value < min) min else max
    }

    operator fun getValue(nothing: Nothing?, property: KProperty<*>): Int {
        return value
    }

    operator fun setValue(nothing: Nothing?, property: KProperty<*>, i: Int) {
        if (i in min..max) {
            println("Asignando valor $i")
            value = i
        } else if (i < min) {
            println("Asignando valor minimo $min al valor $i")
            value = min
        } else {
            println("Asignando valor maximo $max al valor $i")
            value = max
        }
    }

}

