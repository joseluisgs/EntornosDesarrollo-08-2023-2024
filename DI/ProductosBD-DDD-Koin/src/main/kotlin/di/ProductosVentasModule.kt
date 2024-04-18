package dev.joseluisgs.di

import dev.joseluisgs.clientes.repositories.ClientesRepositoryImpl
import dev.joseluisgs.config.Config
import dev.joseluisgs.database.service.SqlDeLightManager
import dev.joseluisgs.productos.cache.ProductosCache
import dev.joseluisgs.productos.reposiitories.ClientesRepository
import dev.joseluisgs.productos.reposiitories.ProductosRepository
import dev.joseluisgs.productos.repositories.ProductosRepositoryImpl
import dev.joseluisgs.productos.services.ProductosService
import dev.joseluisgs.productos.services.ProductosServicesImpl
import dev.joseluisgs.productos.storage.ProductosStorage
import dev.joseluisgs.productos.storage.ProductosStorageImpl
import dev.joseluisgs.productos.validators.ProductoValidator
import dev.joseluisgs.ventas.repositories.VentasRepository
import dev.joseluisgs.ventas.repositories.VentasRepositoryImpl
import dev.joseluisgs.ventas.services.VentasService
import dev.joseluisgs.ventas.services.VentasServiceImpl
import dev.joseluisgs.ventas.storage.VentasStorage
import dev.joseluisgs.ventas.storage.VentasStorageHtmlImpl
import dev.joseluisgs.ventas.storage.VentasStorageJsonImpl
import org.koin.core.qualifier.named
import org.koin.dsl.module

/**
 * Módulo de inyección de dependencias para Productos y Ventas
 * Preparamos la inyección de dependencias para los módulos de Productos y Ventas
 */

val productosVentasModule = module {

    // Config, para la configuración de la aplicación, leeremos de un fichero de propiedades con Koin
    single {
        Config(
            _databaseUrl = getProperty("database.url", "jdbc:sqlite:productos.db"),
            _databaseInitTables = getProperty("database.init.tables", "false"),
            _databaseInitData = getProperty("database.init.data", "true"),
            _databaseInMemory = getProperty("database.inmemory", "true"),
            _storageData = getProperty("storage.data", "data"),
            _cacheSize = getProperty("cache.size", "5").toInt()
        )
    }

    // SQLManager
    single {
        SqlDeLightManager(config = get())
    }

    // Clientes
    single<ClientesRepository> { ClientesRepositoryImpl(dbManager = get()) }

    // Productos
    single<ProductosRepository> { ProductosRepositoryImpl(dbManager = get()) }
    single { ProductoValidator() }
    single { ProductosCache(config = get()) }
    single<ProductosStorage> { ProductosStorageImpl() }
    single<ProductosService> {
        ProductosServicesImpl(
            productosRepository = get(),
            productoValidator = get(),
            productosCache = get(),
            productosStorage = get()
        )
    }

    // Ventas
    single<VentasRepository> {
        VentasRepositoryImpl(
            dbManager = get(),
            productosRepository = get(),
            clientesRepository = get()
        )
    }
    single<VentasStorage>(named("json")) { VentasStorageJsonImpl() }
    single<VentasStorage>(named("html")) { VentasStorageHtmlImpl() }
    single<VentasService> {
        VentasServiceImpl(
            ventasRepository = get(),
            productosRepository = get(),
            clientesRepository = get(),
            ventasStorageJson = get(named("json")),
            ventasStorageHtml = get(named("html"))
        )
    }

}