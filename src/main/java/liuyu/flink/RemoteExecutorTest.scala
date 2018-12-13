package liuyu.flink

import java.nio.file.{Path, Paths}
import java.util
import java.util.List

import org.apache.flink.client.RemoteExecutor
import org.apache.flink.client.cli.{CliFrontend, CustomCommandLine}
import org.apache.flink.configuration.{Configuration, GlobalConfiguration}

/**
  * ClassName: RemoteExecutorTest <br/>
  * Function:  ADD FUNCTION. <br/>
  * Reason:  ADD REASON(可选). <br/>
  * date: 18-8-24 下午5:15 <br/>
  *
  * @author liuyu
  * @version v1.0
  * @since JDK 1.7+
  */
object RemoteExecutorTest {

  def main(args: Array[String]): Unit = {
    //    val path = Paths.get("/home/liuyu/installSoft/flink-1.6.0/examples/batch/WordCount.jar")
    //    var file = path.toUri.toURL
    ////    var executor = new RemoteExecutor("localhost", 6123, file)
    //    var executor = new RemoteExecutor("localhost", 8081, file)
    //
    //    executor.start()
    // 1. find the configuration directory
//    val configurationDirectory: String = CliFrontend.getConfigurationDirectoryFromEnv
    val configurationDirectory="/home/liuyu/installSoft/flink-1.6.0/conf"
    // 2. load the global configuration
    val configuration: Configuration = GlobalConfiguration.loadConfiguration(configurationDirectory)
    // 3. load the custom command lines
    val customCommandLines: util.List[CustomCommandLine[_]] = CliFrontend.loadCustomCommandLines(configuration, configurationDirectory)
    val cli = new CliFrontend(configuration, customCommandLines)
    var kk = Array("run", "/home/liuyu/installSoft/flink-1.6.0/examples/batch/WordCount.jar")
    cli.parseParameters(kk)
    println()
  }
}
