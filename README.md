# simpletags

A very simple tag library for https://www.scala-js.org/ with great integration with scalajs-dom

```scala
import net.magik6k.simpletags.Tags._
import org.scalajs.dom._

def saySomething(text: String) {
  document.getElementById("main").appendChild(span("Important message: ", strong(text)))
}
```
