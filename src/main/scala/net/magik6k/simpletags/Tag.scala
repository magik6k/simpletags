package net.magik6k.simpletags

import org.scalajs.dom._
import org.scalajs.jquery._

import scala.scalajs.js


abstract class Tag(inner: Tag*) {
  def getNode: Node

  def $: JQuery = jQuery(getNode)

  def find(selector: String): JQuery = $.find(selector)
  def find(element: js.Any): JQuery = $.find(element)
  def find(obj: JQuery): JQuery = $.find(obj)
}

object Tag {
  implicit def tagOfString(str: String): Tag = {
    new Tag() {
      val element = document.createElement("span")
      element.innerHTML = str.replaceAll(">","&gt;").replaceAll("<","&lt;")
      override def getNode: Node = element
    }
  }

  implicit def tagOfElement(element: Element): Tag = {
    new Tag() {
      override def getNode: Node = element
    }
  }

  implicit def elementTag(tag: Tag): Element = tag.getNode.asInstanceOf[Element]
}

