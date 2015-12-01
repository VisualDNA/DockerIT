package com.visualdna.dockerit.model

import java.util.Properties

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.mock.MockitoSugar
import org.scalatest.{Matchers, path}
import slick.driver.MySQLDriver.api._

@RunWith(classOf[JUnitRunner])
class SampleEntityDAOTest extends path.FunSpec with Matchers with MockitoSugar with MySqlTest {
  
  val db = getTestDb(new Properties())

  describe("SampleEntityDAO") {
    val setup = DBIO.seq(SampleEntityDAO.sampleEntityTable.schema.create)

    val dao = new SampleEntityDAO(db)
    it("should be able to connect to the database") {
    }
  }

}
