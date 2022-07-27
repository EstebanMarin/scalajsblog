package com.esteban.frontend

import com.raquo.laminar.api.L.*
import org.scalajs.dom
import com.esteban.frontend.components.RootComponent.root

@main def Main(args: String*): Unit =

  val _ = documentEvents
    .onDomContentLoaded
    .foreach { _ =>
      val appContainer = dom.document.querySelector("#app")
      appContainer.innerHTML = ""
      println("Grande Esteban")
      val _ = render(appContainer, root)
    }(unsafeWindowOwner)
