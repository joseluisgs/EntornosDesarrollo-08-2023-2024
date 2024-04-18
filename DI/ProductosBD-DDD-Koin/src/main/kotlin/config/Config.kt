package dev.joseluisgs.config

import org.lighthousegames.logging.logging
import java.nio.file.Files
import kotlin.io.path.Path

private val logger = logging()

class Config(
    _databaseUrl: String = "jdbc:sqlite:productos.db",
    _databaseInitTables: String = "true",
    _databaseInitData: String = "true",
    _databaseInMemory: String = "true",
    _storageData: String = "data",
    _cacheSize: Int = 5
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
    var cacheSize: Int = _cacheSize
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