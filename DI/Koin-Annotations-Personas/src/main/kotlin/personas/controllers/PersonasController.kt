package personas.controllers

import org.koin.core.annotation.Property
import org.koin.core.annotation.Singleton
import org.lighthousegames.logging.logging
import personas.models.Persona
import personas.repositories.PersonasRepository
import java.util.*

private val logger = logging()

@Singleton
// Controlador de Personas, que se encarga de gestionar las personas
class PersonasController(
    private val personaRepository: PersonasRepository,
    @Property("server_url") // Inyectamos una propiedad
    private val serverUrl: String
) {
    private val id = UUID.randomUUID()

    fun save(persona: Persona): Persona {
        logger.debug { "PersonasController.save() --> $persona" }
        println("PersonasController.save() --> $persona")
        return personaRepository.save(persona)
    }

    override fun toString() =
        "PersonaController(personaRepository=$personaRepository, id='$id', serverUrl='$serverUrl')"
}
