package di

import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.dsl.koinApplication
import org.koin.fileProperties
import org.koin.ksp.generated.defaultModule
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
            defaultModule.verify()
        }
    }

    @Test
    fun checkModules() {
        koinApplication {
            fileProperties()
            checkModules {
                defaultModule
            }
        }

    }
}