name := "imdb-data-analysis"

version := "1.0"

version := "1.0"

scalaVersion := "2.11.8"

scalacOptions ++= Seq("-feature", "-unchecked", "-deprecation", "-encoding", "UTF-8")

val hadoopVersion = "2.7.3"

val sparkVersion = "2.3.0"

libraryDependencies ++= Seq(
  "org.apache.hadoop" % "hadoop-aws" % hadoopVersion excludeAll ExclusionRule(organization = "javax.servlet"), // it has serlvet 2.5 dep, but spark has servlet 3.0 dep
  "org.apache.hadoop" % "hadoop-client" % hadoopVersion excludeAll ExclusionRule(organization = "javax.servlet"),
  "org.apache.hadoop" % "hadoop-yarn-client" % hadoopVersion excludeAll ExclusionRule(organization = "javax.servlet"),
  "org.apache.hadoop" % "hadoop-yarn-server-web-proxy" % hadoopVersion excludeAll ExclusionRule(organization = "javax.servlet"),
  //"org.apache.spark" %% "spark-yarn" % sparkVersion excludeAll ExclusionRule(organization = "org.apache.hadoop"),
  "org.apache.spark" %% "spark-mllib" % sparkVersion excludeAll ExclusionRule(organization = "org.apache.hadoop"),
  "org.apache.spark" %% "spark-hive" % sparkVersion excludeAll ExclusionRule(organization = "org.apache.hadoop"),
  "org.apache.spark" %% "spark-core" % sparkVersion ,
  "org.apache.spark" %% "spark-sql" % sparkVersion excludeAll ExclusionRule(organization = "org.apache.hadoop"),

  // 3th parties
  "org.scalanlp" %% "breeze-viz" % "0.13", //use the same version as the one of spark-mllib

  //Test
  "org.scalatest" %% "scalatest" % "3.0.8" % "test"

)
