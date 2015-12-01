package com.visualdna.dockerit.model

import slick.driver.MySQLDriver.api._
import slick.jdbc.JdbcBackend


class SampleEntityDAO(db: JdbcBackend.Database) {
  val sampleEntityTable = TableQuery[SampleEntityTable]

  def save(firstAttribute: String, secondAttribute: String) = {
    sampleEntityTable.map(e => (e.firstAttribute, e.secondAttribute )) += (firstAttribute, secondAttribute)
  }

}

class SampleEntityTable(tag: Tag) extends Table[SampleEntity](tag, "sample_entity") {
  def id = column[Long]("id", O.PrimaryKey, O.AutoInc)

  def firstAttribute = column[String]("firstAttribute")

  def secondAttribute = column[String]("secondAttribute")

  override def * = (id, firstAttribute, secondAttribute) <>(SampleEntity.tupled, SampleEntity.unapply)
}
