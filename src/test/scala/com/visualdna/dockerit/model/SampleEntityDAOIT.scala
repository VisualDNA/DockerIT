package com.visualdna.dockerit.model

import java.io.BufferedReader
import java.net.URL
import java.util.Properties

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.mock.MockitoSugar
import org.scalatest.{FunSpec, Matchers}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.concurrent.{Await, Future}

@RunWith(classOf[JUnitRunner])
class SampleEntityDAOIT extends FunSpec with Matchers with MockitoSugar with MySqlTest {


  private val resource: URL = getClass().getResource("/config.properties")
  private val reader: BufferedReader = io.Source.fromURL(resource).bufferedReader()
  private val properties: Properties = new Properties()
  properties.load(reader)
  println(properties.toString)

  val db = getTestDb(properties)

  describe("SampleEntityDAO") {

    val dao = new SampleEntityDAO(db)

    it("should be able to write and read from db") {
      println("inside it")

      val res = for {
        _ <- dao.save("javascript", "rocks")
        _ <- dao.save("javascript", "I told you it rocks")
        _ <- dao.save("java", "Hmmm... Seriously?")
      } yield {}

      val futureResult: Future[Seq[SampleEntity]] = res.flatMap( _ => dao.read("javascript"))

      Await.result(futureResult, 5 minutes) match {
        case result => result.size shouldBe 2
        case _ => fail()
      }

    }
  }

}
