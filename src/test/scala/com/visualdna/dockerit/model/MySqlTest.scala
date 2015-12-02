package com.visualdna.dockerit.model

import java.util.Properties

import com.typesafe.config.ConfigFactory
import slick.jdbc.JdbcBackend

trait MySqlTest {


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
