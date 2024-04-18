package di

import dev.joseluisgs.di.productosVentasModule
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.dsl.koinApplication
import org.koin.fileProperties
import org.koin.test.check.checkModules
import org.koin.test.junit5.AutoCloseKoinTest
import org.koin.test.verify.verify
import kotlin.test.Test

@OptIn(KoinExperimentalAPI::class)
class ModuleVerificationTest : AutoCloseKoinTest() {

    @Test
    fun verifyModules() {
        koinApplication {
            fileProperties()
            productosVentasModule.verify()
        }
    }

    @Test
    fun checkModules() {
        checkModules {
            modules(productosVentasModule)
        }
    }
}