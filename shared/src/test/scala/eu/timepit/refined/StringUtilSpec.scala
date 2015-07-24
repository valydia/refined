package eu.timepit.refined

import eu.timepit.refined.implicits._
import eu.timepit.refined.util.string._
import org.scalacheck.Prop._
import org.scalacheck.Properties
import shapeless.test.illTyped

class StringUtilSpec extends Properties("util.string") {

  property("uuid success") = secure {
    uuid("9ecce884-47fe-4ba4-a1bb-1a3d71ed6530") ?=
      java.util.UUID.fromString("9ecce884-47fe-4ba4-a1bb-1a3d71ed6530")
  }

  property("uuid failure") = secure {
    illTyped("""uuid("whops")""", "(?s)Predicate isValidUuid.*failed.*")
    true
  }
}
