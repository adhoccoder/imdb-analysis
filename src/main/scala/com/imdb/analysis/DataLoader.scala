package com.imdb.analysis

import org.apache.spark.sql
import org.apache.spark.sql.SparkSession

trait DataLoader {
  def load(path: String, delim: String)(implicit session: SparkSession): sql.DataFrame
}

object TsvDataLoader extends DataLoader {
  val delimiter = "\t"
  override def load(path: String, delim: String = delimiter)(implicit session: SparkSession):sql.DataFrame = {
    session.read
      .option("sep", delim)
      .option("header", true)
      .option("inferSchema", true)
      .option("ignoreLeadingWhiteSpace", true)
      .option("ignoreTrainingWhiteSpace", true)
      .option("nullValue", "None")
      .csv(path)
  }
}
