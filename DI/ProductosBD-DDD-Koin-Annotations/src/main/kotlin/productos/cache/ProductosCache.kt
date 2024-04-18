package dev.joseluisgs.productos.cache

import dev.joseluisgs.cache.CacheImpl
import dev.joseluisgs.config.Config
import dev.joseluisgs.productos.model.Producto
import org.koin.core.annotation.Singleton

@Singleton
class ProductosCache(config: Config) : CacheImpl<Long, Producto>(config.cacheSize)