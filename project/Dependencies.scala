import sbt._

object Dependencies {
  object org {
    object scalatest {
      val scalatest =
        "org.scalatest" %% "scalatest" % "3.2.12"
    }

    object typelevel {
      val cats =
        "org.typelevel" %% "cats-core" % "2.7.0"
    }

//    object frontend {
//      val laminar =
//        "com.raquo" %%% "laminar" % "0.14.2"
//    }

    object scalatestplus {
      val `scalacheck-1-16` =
        "org.scalatestplus" %% "scalacheck-1-16" % "3.2.12.0"
    }
  }
}
