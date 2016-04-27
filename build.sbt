lazy val jettyVersion = "9.3.7.v20160115"

libraryDependencies ++= Seq(
  "javax.servlet" % "javax.servlet-api" % "3.1.0",
  "junit" % "junit" % "4.12",
  "org.eclipse.jetty" % "jetty-annotations" % jettyVersion,
  "org.eclipse.jetty" % "jetty-webapp" % jettyVersion,
  "org.eclipse.jetty" % "apache-jsp" % jettyVersion,
  "org.eclipse.jetty" % "apache-jstl" % jettyVersion
)
