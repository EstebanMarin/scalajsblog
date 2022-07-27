package com.esteban.frontend.components

import com.raquo.laminar.api.L.*
import io.laminext.syntax.tailwind.*
import com.raquo.laminar.builders.HtmlTag

object RootComponent:
  import extensions.*

  val footer = div(
    cls("footer footer-center prose"),
    div(
    a(cls("link"), href := "https://www.linkedin.com/in/estebanmarincom/", "linkedin").th,
    a(cls("link"), href := "https://github.com/EstebanMarin", "github").th,
    )
  ).th

  val navBar = div(
    cls("navbar"),
    div(
      h1("Another over engineered blog of coding")
    ).th,
  )

  val column1 = div(
    cls("flex-none"),
    p("Column1"),
  ).th

  val column2 = div(
    cls("flex-auto"),
    article(
      p(
        "My name is Esteban Marin. I love functional programming and code for living in Scala and Typescript"
      )
    ),
  ).th

  val columns = div(
    cls("flex flex-row flex-nowrap"),
    // column1,
    column2,
  ).th

  val pageTemplate = div(
    cls("max-w h-screen container px-4 prose"),
    navBar,
    columns,
    footer,
  ).th

  val root = div(
    pageTemplate
  ).th

object extensions:
  extension (el: HtmlElement)
    def th =
      el.amend(dataAttr("theme")("business"))
