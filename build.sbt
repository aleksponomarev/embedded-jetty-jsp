import dependencies._

lazy val root = (project in file(".")).
  aggregate(jettyrunner, server, swingws)

lazy val webapp1 = baseDirectory in jettyrunner

lazy val jettyrunner = project.in(file("runner"))
  .settings(commonSettings: _*)
  .settings(libraryDependencies ++= runnerDependencies)
  .settings(mainClass in assembly := Some("org.eclipse.jetty.demo.Main"))
  .settings(assemblyJarName in assembly := "runner.jar")
  .settings(

  // handle conflicts during assembly task
  mergeStrategy in assembly <<= (mergeStrategy in assembly) {
    (old) => {
      case "about.html" => MergeStrategy.first
      case x => old(x)
    }
  },

  // copy web resources to /webapp folder
  resourceGenerators in Compile <+= (resourceManaged, baseDirectory) map {
    (managedBase, base) =>
    val webappBase = base / "src" / "main" / "webapp1"
    for {
      (from, to) <- webappBase ** "*" x rebase(webappBase, managedBase)
    } yield {
      Sync.copy(from, to)
      to
    }
  }
  )
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

assemblySwingWs := {

  val f = (assembly in swingws).value
  println("assemblySwingWs Done.")
  f
}

lazy val assemblyRunner = taskKey[File]("build only runner project")

assemblyRunner := {

  val f = (assembly in jettyrunner).value
  println("assemblyRunner Done.")
  f
}

lazy val copyStatic = taskKey[Unit]("copy static web resources")

copyStatic := {

  IO.copyDirectory(
    (baseDirectory in server).value / "src" / "main" / "resources" / "webroot",
    webapp1.value / "src" / "main" / "webapp1")
  println("copyStatic Done.")
}

lazy val copySwingws = taskKey[Unit]("copy swingws as resources")

copySwingws := {

  IO.copyDirectory(
    (baseDirectory in swingws).value / "target" / "scala-2.10",
    webapp1.value / "src" / "main" / "webapp1")
  println("copyDirectory Done.")
}

lazy val assemblyAll = taskKey[File]("assembly with background")

assemblyAll := Def.sequential (

  assemblySwingWs,
  copyStatic,
  copySwingws,
  assemblyRunner
).value
