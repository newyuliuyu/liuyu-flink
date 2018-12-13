package liuyu.flink

import org.apache.flink.api.java.io.TextInputFormat
import org.apache.flink.api.scala._
import org.apache.flink.core.fs.Path

/**
  * ClassName: ReadMultText <br/>
  * Function:  ADD FUNCTION. <br/>
  * Reason:  ADD REASON(可选). <br/>
  * date: 18-8-31 下午4:01 <br/>
  *
  * @author liuyu
  * @version v1.0
  * @since JDK 1.7+
  */
object ReadMultTextTest {
  def main(args: Array[String]): Unit = {
    val env = ExecutionEnvironment.getExecutionEnvironment
    //    读取目录下面的所有文件
    //    var mydate = env.readTextFile("/home/liuyu/workeidea/liuyu-flink/data/")
    //    mydate.print()

    val format = new TextInputFormat(new Path("/home/liuyu/workeidea/liuyu-flink/data/data1.csv"))
    format.setFilePaths("/home/liuyu/workeidea/liuyu-flink/data/data3.csv")
    format.setCharsetName("UTF-8")
    var mydate = env.createInput(format)
    mydate.print()
  }
}
