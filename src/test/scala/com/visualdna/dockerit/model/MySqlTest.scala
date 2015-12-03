package com.visualdna.dockerit.model

import java.io.BufferedReader
import java.net.URL
import java.util.Properties

import com.typesafe.config.ConfigFactory
import slick.jdbc.JdbcBackend

trait MySqlTest {
  private val resource: URL = getClass().getResource("/config.properties")
  private val reader: BufferedReader = io.Source.fromURL(resource).bufferedReader()
  private val properties: Properties = new Properties()
  properties.load(reader)

  val db = getTestDb(properties)


  def getTestDb(properties: Properties): JdbcBackend.Database = {
    val host = properties.getProperty("db.host")
    val port = properties.getProperty("db.port")
    val dbName = properties.getProperty("db.database")

    JdbcBackend.Database.forConfig("testDb",
      ConfigFactory.load(ConfigFactory.parseString(
        s"""
           |testDb = {
           |  dataSourceClass = "com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource"
           |  properties = {
           |    user = "${properties.getProperty("db.username")}"
           |    password = "${properties.getProperty("db.password")}"
           |    url = "jdbc:mysql://$host:$port/$dbName"
           |  }
           |  numThreads = ${properties.getProperty("db.threads")}
           |}
             """.stripMargin))
    )
  }
}
