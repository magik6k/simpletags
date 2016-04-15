version := "1.0.0-SNAPSHOT"
organization := "net.magik6k"
name := "simpletags"
crossPaths := false

crossScalaVersions in ThisBuild := Seq("2.11.8", "2.10.6", "2.12.0-M4")
scalaVersion in ThisBuild := crossScalaVersions.value.head

lazy val root = project.in(file(".")).
  enablePlugins(ScalaJSPlugin)

libraryDependencies ++= Seq(
  "org.scala-js" %%% "scalajs-dom" % "0.8.0",
  "be.doeraene" %%% "scalajs-jquery" % "0.8.0"
)

pomIncludeRepository := { _ => false }
pomExtra := (
  <url>https://github.com/magik6k/simpletags/</url>
  <licenses>
    <license>
      <name>MIT</name>
      <url>https://opensource.org/licenses/MIT</url>
      <distribution>repo</distribution>
    </license>
  </licenses>
  <scm>
    <url>https://github.com/magik6k/simpletags.git</url>
    <connection>scm:git:git@github.com:magik6k/simpletags.git</connection>
  </scm>
  <developers>
    <developer>
      <id>Magik6k</id>
      <name>Łukasz Magiera</name>
      <url>https://magik6k.net</url>
    </developer>
  </developers>)


publishMavenStyle := true

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases" at nexus + "service/local/staging/deploy/maven2")
}
