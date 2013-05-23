/*
 * Copyright 2013 Josselin Pujo
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

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
