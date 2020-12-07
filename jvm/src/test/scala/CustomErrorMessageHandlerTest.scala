package org.rogach.scallop

import org.scalatest.funsuite.AnyFunSuite

class CustomErrorMessageHandlerTest extends AnyFunSuite with UsefulMatchers {
  throwError.value = false

  case object Err extends Exception

  test ("custom error message handler") {
    intercept[Err.type] {
      new ScallopConf(Seq("-a")) {
        errorMessageHandler = error => throw Err
        verify()
      }
    }
  }
}
