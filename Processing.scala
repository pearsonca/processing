package edu.cap10.processing

import sbt._
import sbt.IO._
import Keys._

object Processing extends Plugin {
  lazy val sketchSrcDir = settingKey[File]("The location of *.spde files to convert into sketches; defaults to baseDirectory.")
  lazy val sketch = taskKey[Unit]("Compile a sketch.")  
  lazy val processingSettings = Seq(
    sketchSrcDir := baseDirectory.value,
    sketch := {
      val files = listFiles(sketchSrcDir.value).filter( _.getName.endsWith(".spde") )
      println("For each of those files, I should create runnable PApplet object with the appropriate imports.")
    }
  )
  
}
