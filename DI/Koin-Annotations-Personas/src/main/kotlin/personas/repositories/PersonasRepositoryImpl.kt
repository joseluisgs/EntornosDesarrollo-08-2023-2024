package personas.repositories

import org.koin.core.annotation.Named
import org.koin.core.annotation.Singleton
import org.lighthousegames.logging.logging
import personas.models.Persona
import personas.services.PersonasStorage
import java.util.*

private val logger = logging()

@Singleton // Indicamos que es un Singleton
// @Named("PersonasRepositoryDataBase") // Le damos un nombre para poder inyectarlo
class PersonasRepositoryImpl(
    @Named("PersonasStorageDataBase") // Indicamos que queremos este de los dos posibles!!
    private val storage: PersonasStorage
) : PersonasRepository {
    private val id = UUID.randomUUID()

    override fun save(entity: Persona): Persona {
        logger.debug { "PersonasRepository.save() -->$entity" }
        println("PersonasRepository.save() -->$entity")
        return storage.save(entity)
    }

    override fun toString() = "PersonasRepository(storage=$storage, id='$id')"

}
