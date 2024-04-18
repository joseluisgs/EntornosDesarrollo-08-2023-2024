package dev.joseluisgs.delegados.noobserver


// Radio Una clase que implementa la interfaz
// reaccionamos ante un cambio
class Radio(private val newsAgency: Agencia) {
    init {
        var oldNews = newsAgency.news
        while (true) {
            Thread.sleep(1000)
            if (oldNews != newsAgency.news) {
                println("La radio informa: ${newsAgency.news}")
                oldNews = newsAgency.news
            }
        }
    }
}

// Periodico Una clase que implementa la interfaz
// reaccionamos ante un cambio
class Periodico(private val agencia: Agencia) {
    init {
        var oldNews = agencia.news
        while (true) {
            Thread.sleep(1000)
            if (oldNews != agencia.news) {
                println("El periódico informa: ${agencia.news}")
                oldNews = agencia.news
            }
        }
    }

}

// Agencia que es observada
class Agencia {
    // Lista de observadores, son los que implementan la interfaz
    var news: String = ""
}

fun main() {
    // Preparamos los objetos
    val newsAgency = Agencia()
    val radioChannel = Radio(newsAgency)
    val newspaper = Periodico(newsAgency)


    // Lanzamos una noticia.la observa y automaticamente notifica (reacciona)
    // A mis observadores
    newsAgency.news = "¡Nadal Gana!"
    newsAgency.news = "¡Hoy llueve!"
    newsAgency.news = "¡Todos han aprobado!"

    // Los periódicos se retiran
    newsAgency.news = "Llegan las vacaciones :)"
}