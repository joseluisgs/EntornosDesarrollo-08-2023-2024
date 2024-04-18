package dev.joseluisgs.delegados.notnull

class NotNull {
    lateinit var valor: String

    //var valor: String by Delegates.notNull<String>()
    val otro = "Otro valor"

    fun getValorFromDataBase() {
        println("Obteniendo valor de la base de datos")
        Thread.sleep(1000)
        valor = "Valor de la base de datos"
    }

    override fun toString(): String {
        return "NotNull(valor='$valor', otro='$otro')"
    }
}