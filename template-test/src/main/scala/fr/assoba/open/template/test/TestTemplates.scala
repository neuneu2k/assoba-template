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
