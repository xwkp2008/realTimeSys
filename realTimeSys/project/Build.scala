import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "realTimeSys"
  val appVersion      = "1.0-SNAPSHOT"

  val others = Seq(
	    "nexus" at "http://124.72.94.12:88/nexus/content/groups/public/",
	    "nexus-snapshot" at "http://124.72.94.12:88/nexus/content/repositories/snapshots/",
	    "Local Maven Repository" at Path.userHome.asURL + "/.m2/repository"
	  )

  val appDependencies = Seq(
    // Add your project dependencies here,
    javaCore,
    javaJdbc,
    javaEbean,
    "tng.ark" % "common" % "0.4-SNAPSHOT" withSources(),
    "ark-ui-dwz" % "ark-ui-dwz_2.10" % "1.0-SNAPSHOT"
  )

  val main = play.Project(appName, appVersion, appDependencies).settings(
     resolvers:=others      
  )

}
