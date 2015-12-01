package com.visualdna.dockerit.model

import java.util.Properties

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.mock.MockitoSugar
import org.scalatest.{FunSpec, Matchers, path}
import slick.driver.MySQLDriver.api._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Await, Future}
import scala.util.{Failure, Success}
import scala.concurrent.duration._

@RunWith(classOf[JUnitRunner])
class SampleEntityDAOIT extends FunSpec with Matchers with MockitoSugar with MySqlTest {

  val db = getTestDb(new Properties())

  describe("SampleEntityDAO") {
    val setup = DBIO.seq(SampleEntityDAO.sampleEntityTable.schema.create)

    val dao = new SampleEntityDAO(db)
    println("javascript sucks")

    it("---") {
      println("inside it")
      val query = for {
        _ <- setup
        _ <- dao.save("scala", "rocks")
        _ <- dao.save("scala", "I told you it rocks")
        _ <- dao.save("javascript", "Mmmm... Seriously?")
        results <- dao.read("scala")
      } yield results

      val futureResult: Future[Seq[SampleEntity]] = db.run(query)

      Await.result(futureResult, 5 minutes) match {
        case result => result.size shouldBe 2
        case _ => fail()
      }

    }
  }

}
