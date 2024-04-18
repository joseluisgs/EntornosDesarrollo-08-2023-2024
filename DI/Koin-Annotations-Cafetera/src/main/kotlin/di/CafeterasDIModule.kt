package dev.joseluisgs.di

import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module

@Module // Indicamos que es un módulo de Koin
@ComponentScan // Escaneamos los componentes (Se le puede decir el paquete por parámetros)
class CafeterasDIModule