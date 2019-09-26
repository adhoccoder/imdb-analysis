package com.imdb.analysis

import org.apache.spark.sql.SparkSession
import org.scalatest.{BeforeAndAfterEach, FunSuite}
import org.apache.spark.sql.functions._


class TopTitlesTest extends FunSuite with BeforeAndAfterEach {

  implicit var sparkSession: SparkSession = _
  override def beforeEach() {
    sparkSession = SparkSession.builder().appName("topTitlesTest")
      .master("local")
      .getOrCreate()
  }

  override def afterEach() {
    sparkSession.stop()
  }

  test("test top title functions"){
    val testdataFolder = "src/test/resources"
    val titleBasics = TsvDataLoader.load(s"$testdataFolder/title.basics.tsv")
    val titleRatings = TsvDataLoader.load(s"$testdataFolder/title.ratings.tsv")

    val topMovieByRank = TopTitles
      .getTopNTitles(titleRatings, titleBasics, 1, "movie", 10)
        .select(col("tconst")).collect()
    System.out.println(topMovieByRank.head.getString(0))
    assert(topMovieByRank.head.getString(0) == "tt0111161") // Shawshank Redemption
  }

}
