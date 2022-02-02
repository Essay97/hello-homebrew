import picocli.CommandLine
import picocli.CommandLine.Command
import picocli.CommandLine.Option
import java.util.concurrent.Callable
import kotlin.system.exitProcess

@Command(name = "hello", description = ["This is my first command distributed with Homebrew!"],
    mixinStandardHelpOptions = true, version = ["Hello 1.0"])
class Hello: Callable<Int> {

    @Option(names = ["--flag", "-f"], description = ["Changes the message"])
    var flag = false

    override fun call(): Int {
        if (flag) {
            println("Hello Homebrew (with flag)!")
        } else {
            println("Hello Homebrew!")
        }
        return 0
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            exitProcess(CommandLine(Hello()).execute(*args))
        }
    }
}