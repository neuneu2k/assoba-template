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

package fr.assoba.open.template.test

object TestTemplates extends App {
  val t = test.render()
  println(t.toString)
  val t2 = test2.render("toto")
  println(t2.toString)

  def f = {
    val x = 2 + 2
    <h1>x={x}</h1>
  }
}
