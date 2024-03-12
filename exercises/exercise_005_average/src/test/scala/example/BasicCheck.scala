package example

import org.scalatest.flatspec.AnyFlatSpec

class BasicCheck extends AnyFlatSpec {

  "1" should "not equal 2" in {
      assert(1 != 2)
  }

}
