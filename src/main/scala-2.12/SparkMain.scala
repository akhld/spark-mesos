import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by akhld on 14/1/17.
  */

object SparkMain {

  def main(args: Array[String]): Unit ={

    val conf = new SparkConf()
      .setMaster("mesos://mesos-m1:5050")
      .setAppName("My spark app")
      .set("spark.executor.uri", "http://mesos-1/jar/spark-2.1.0-bin-hadoop2.7.tgz")

    val sc = new SparkContext(conf)


    sc parallelize( 1 to 100) collect() foreach println

    Thread.sleep(60000)

  }
}
