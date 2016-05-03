import dependencies._

lazy val runner = project.in(file("runner"))
  .settings(commonSettings: _*)
  .settings(libraryDependencies ++= runnerDependencies)
  .settings(mainClass in assembly := Some("org.eclipse.jetty.demo.Main"))
  .settings(assemblyJarName in assembly := "project.jar")
  .dependsOn(server)

lazy val server = project.in(file("server"))
  .settings(commonSettings: _*)
  .settings(libraryDependencies ++= serverDependencies)

lazy val commonSettings = Seq(
  scalaVersion := "2.10.1"
)
