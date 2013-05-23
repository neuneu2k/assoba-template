package fr.assoba.open.template.compiler

import java.io.File
import scalax.file.{PathSet, Path}

object PathCompiler {

  def compile(path: File, output: File) {
    val templates: PathSet[Path] = Path(path) ** "*.stl"
    templates.foreach(
      f => {
        f.fileOption match {
          case Some(file: File) => file match {
            case h: File if h.getName.endsWith(".html.stl") => ScalaTemplateCompiler.compile(h, path, output, "HtmlFormat")
            case _ => ScalaTemplateCompiler.compile(file, path, output, "TxtFormat")
          }
          case None =>
        }
      }
    )
  }
}
