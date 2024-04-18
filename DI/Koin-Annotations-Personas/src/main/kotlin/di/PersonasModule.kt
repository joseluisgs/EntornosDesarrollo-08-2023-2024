package di

import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module

// Modulo que indica cómo son las dependencias.
@Module // Indicamos que es un módulo de Koin
@ComponentScan // Escaneamos los componentes (Se le puede decir el paquete por parámetros)
class PersonasModule