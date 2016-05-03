import dependencies._

lazy val root = (project in file(".")).
  aggregate(runner, server, swingws)

lazy val runner = project.in(file("runner"))
  .settings(commonSettings: _*)
  .settings(libraryDependencies ++= runnerDependencies)
  .settings(mainClass in assembly := Some("org.eclipse.jetty.demo.Main"))
  .settings(assemblyJarName in assembly := "runner.jar")
  .dependsOn(server)

lazy val server = project.in(file("server"))
  .settings(commonSettings: _*)
  .settings(libraryDependencies ++= serverDependencies)

lazy val swingws = project.in(file("swingws"))
  .settings(commonSettings: _*)
  .settings(mainClass in assembly := Some("view.SwingWs"))
  .settings(assemblyJarName in assembly := "swingws.jar")

lazy val commonSettings = Seq(
  scalaVersion := "2.10.1"
)

lazy val assemblySwingWs = taskKey[File]("build only swingws project")

assemblySwingWs := (assembly in swingws).value

lazy val copyStatic = taskKey[Unit]("copy static web resources")

copyStatic := IO.copyDirectory((baseDirectory in server).value / "src" / "main" / "resources" / "webroot", baseDirectory.value / "webapp1")
