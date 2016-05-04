import sbt._
import Keys._

object dependencies {

  lazy val jettyVersion = "9.2.10.v20150310"

  lazy val jettyPlus = "org.eclipse.jetty" % "jetty-plus" % jettyVersion
  lazy val jettyJsp = "org.eclipse.jetty" % "apache-jsp" % jettyVersion
  lazy val jettyJstl = "org.eclipse.jetty" % "apache-jstl" % jettyVersion
  lazy val jettyServer = "org.eclipse.jetty" % "jetty-server" % jettyVersion
  lazy val jettyWebapp = "org.eclipse.jetty" % "jetty-webapp" % jettyVersion
  lazy val jettyAnnotations = "org.eclipse.jetty" % "jetty-annotations" % jettyVersion  
  lazy val javaxServlet = "javax.servlet" % "javax.servlet-api" % "3.1.0"
  lazy val monocleCore = "com.github.julien-truffaut" % "monocle-core_2.11" % "1.2.1"
  lazy val monocleMacro = "com.github.julien-truffaut" % "monocle-macro_2.11" % "1.2.1"
  lazy val junit = "junit" % "junit" % "4.12"

  val commonsCodec         = "commons-codec" % "commons-codec" % "1.8"
  val commonsDbcp          = "commons-dbcp" % "commons-dbcp" % "1.4"
  val slf4jApi             = "org.slf4j" % "slf4j-api" % "1.7.12"
  val slf4jJcl             = "org.slf4j" % "slf4j-jcl" % "1.7.12"
  val apacheCommonIo       = "org.apache.commons" % "commons-io" % "1.3.2"


  lazy val serverDependencies = Seq(
    jettyPlus,
    jettyJsp,
    jettyJstl,
    jettyServer,
    jettyWebapp,
    javaxServlet,
    monocleCore,
    monocleMacro,
    commonsCodec,
    commonsDbcp,
    slf4jApi,
    slf4jJcl,
    apacheCommonIo
  )

  lazy val runnerDependencies = Seq(
    jettyJsp,
    jettyJstl,
    jettyServer,
    jettyWebapp,
    javaxServlet,
    jettyAnnotations,
    junit,
    commonsCodec,
    commonsDbcp,
    slf4jApi,
    slf4jJcl,
    apacheCommonIo
  )
}
