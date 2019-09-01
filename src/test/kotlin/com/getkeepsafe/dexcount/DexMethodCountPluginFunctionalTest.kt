package com.getkeepsafe.dexcount

import org.gradle.testkit.runner.GradleRunner
import org.junit.Assert.assertTrue
import org.junit.Test
import java.io.File

class DexMethodCountPluginFunctionalTest {

    @Test
    fun integrationTestsAndroid() {
        val integrationRoot = File("src/test/fixtures/integration")
        val gradleRoot = File(integrationRoot, "gradle").apply {
            mkdir()
        }
        File("gradle/wrapper").copyRecursively(File(gradleRoot, "wrapper"), true)

        val runner = GradleRunner.create()
            .withProjectDir(integrationRoot)
            .withPluginClasspath()
            .withArguments("clean", "countDebugDexMethods", "--stacktrace")

        val result = runner.build()
        assertTrue(result.output.contains("BUILD SUCCESSFUL"))
    }
}
