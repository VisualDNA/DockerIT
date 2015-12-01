package com.visualdna.dockerit.model

import java.util.Properties

import com.typesafe.config.ConfigFactory
import slick.jdbc.JdbcBackend

trait MySqlTest {


  def getTestDb(properties: Properties): JdbcBackend.Database = {
    //    val host = properties.getProperty("vdna.services.mysql.attempt.hosts")
    //    val port = properties.getProperty("vdna.services.mysql.attempt.port")
    //    val dbName = properties.getProperty("vdna.services.mysql.attempt.database")
    val host = "192.168.99.100"
    val port = "3306"
    val dbName = "testDb"
    JdbcBackend.Database.forConfig("testDb",
      //      ConfigFactory.load(ConfigFactory.parseString(
      //        s"""
      //           |testDb = {
      //           |  dataSourceClass = "com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource"
      //           |  properties = {
      //           |    user = "${properties.getProperty("vdna.services.mysql.attempt.username")}"
      //           |    password = "${properties.getProperty("vdna.services.mysql.attempt.password")}"
      //           |    url = "jdbc:mysql://$host:$port/$dbName"
      //           |  }
      //           |  numThreads = ${properties.getProperty("vdna.services.mysql.attempt.threads")}
      //           |}
      //       """.stripMargin))
      ConfigFactory.load(ConfigFactory.parseString(
        s"""
         |testDb = {
         |  dataSourceClass = "com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource"
         |  properties = {
         |    user = "root"
         |    password = ""
         |    url = "jdbc:mysql://$host:$port/$dbName"
         |  }
         |  numThreads = 10
         |}
       """.stripMargin))
    )
    }
}
