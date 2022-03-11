import org.gradle.testfixtures.ProjectBuilder
import org.junit.jupiter.api.Test

class ExamplePluginTests {

    @Test
    fun test() {
        val project = ProjectBuilder.builder().build()
        project.pluginManager.apply("com.example.example-plugin")
    }
}
