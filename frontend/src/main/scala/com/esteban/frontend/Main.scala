package com.esteban.frontend

// import com.raquo.laminar.api.L.{ *, given }
import com.raquo.laminar.api.L.*
import org.scalajs.dom

import io.laminext.syntax.tailwind.*

val nameVar = Var("")
def TextInput(): Input = input(typ("text"))
val inputElement =
  div(
    cls("sm bg-black test-class"),
    "Please enter your name",
    TextInput().amendThis(thisNode => List(onInput.mapTo(thisNode.ref.value) --> nameVar)),
    span(
      cls("lg"),
      "Hello, ",
      child.text <-- nameVar.signal.map(identity),
    ),
  )

def Counter(label: String, initialStep: Int): HtmlElement =
  val allowedSteps = List(1, 2, 3, 5, 10)
  val stepVar = Var(initialStep)
  val diffBus = new EventBus[Int]
  val $count = diffBus.events.foldLeft(initial = 0)(_ + _)
  div(
    p(
      cls := "bg-red",
      "Step: ",
      select(
        value <-- stepVar.signal.map(_.toString),
        inContext(thisNode => onChange.mapTo(thisNode.ref.value.toInt) --> stepVar),
        allowedSteps.map(step => option(value(step.toString), step)),
      ),
    ),
    p(
      label + ": ",
      b(child.text <-- $count),
      " ",
      // Two different ways to get stepVar's value:
      button(
        "–",
        onClick.mapTo(-1 * stepVar.now()) --> diffBus,
      ),
      button(
        "+",
        onClick.mapTo(+1 * stepVar.now()) --> diffBus,
      ),
    ),
  )

val root = div(
  className := "Name Input",
  placeholder := "Enter name here",
  span("Hello, world"),
  inputElement,
  Counter("Sheep", initialStep = 3),
  div(cls("inline-block cursor-pointer rounded-md bg-gray-800 px-4 py-3 text-center text-sm font-semibold uppercase text-white transition duration-200 ease-in-out hover:bg-gray-900"))
)

@main def Main(args: String*): Unit =

  val _ = documentEvents
    .onDomContentLoaded
    .foreach { _ =>
      val appContainer = dom.document.querySelector("#app")
      appContainer.innerHTML = ""
      println("Grande Esteban")
      val _ = render(appContainer, root)
    }(unsafeWindowOwner)
