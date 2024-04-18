package personas.services

import org.koin.core.annotation.Named
import org.koin.core.annotation.Singleton
import org.lighthousegames.logging.logging
import personas.models.Persona
import java.util.*

private val logger = logging()

@Singleton // Indicamos que es un Singleton
@Named("PersonasStorageDataBase") // Le damos un nombre para poder inyectarlo
class PersonasStorageFile : PersonasStorage {
    private val id = UUID.randomUUID()

    override fun save(item: Persona): Persona {
        logger.debug { "PersonasStorageFile.save() --> $item" }
        println("PersonasStorageFile.save() --> $item")
        return item
    }

    override fun toString() = "PersonaDataBaseStorage(id='$id')"
}
