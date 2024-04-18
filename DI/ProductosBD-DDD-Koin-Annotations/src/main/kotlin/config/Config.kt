package dev.joseluisgs.config

import org.koin.core.annotation.Property
import org.koin.core.annotation.Singleton
import org.lighthousegames.logging.logging
import java.nio.file.Files
import kotlin.io.path.Path

private val logger = logging()

@Singleton
class Config(
    @Property("database.url")
    _databaseUrl: String = "jdbc:sqlite:productos.db",
    @Property("database.init.tables")
    _databaseInitTables: String = "true",
    @Property("database.init.data")
    _databaseInitData: String = "true",
    @Property("database.inmemory")
    _databaseInMemory: String = "true",
    @Property("storage.data")
    _storageData: String = "data",
    @Property("cache.size")
    _cacheSize: String = "5"
) {
    var databaseUrl: String = _databaseUrl
        private set
    var databaseInitTables: Boolean = _databaseInitTables.toBoolean()
        private set
    var databaseInitData: Boolean = _databaseInitData.toBoolean()
        private set
    var databaseInMemory: Boolean = _databaseInMemory.toBoolean()
        private set
    var storageData: String = _storageData
        private set
    var cacheSize: Int = _cacheSize.toInt()
        private set

    init {
        try {
            logger.debug { "Cargando configuración" }
            // crear el directorio si no existe
            Files.createDirectories(Path(storageData))

        } catch (e: Exception) {
            logger.error { "Error cargando configuración: ${e.message}" }
        }

    }
}