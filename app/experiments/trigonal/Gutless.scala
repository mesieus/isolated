package experiments.trigonal

import akka.actor.{Actor, ActorSystem, Props}
import com.google.inject.{Inject, Singleton}

import scala.util.Random

/**
  * Created by mesi on 1/09/17.
  */
@Singleton
class Gutless @Inject()
(
  actorSystem: ActorSystem
) {
  def create = {
    val height = 10
    val width = 10
    for {
      i <- 0 until height
      j <- 0 until width
    }
      yield {
        actorSystem.actorOf(GutlessElement.props(ElementState.randomize(i, j)))
      }
  }
}

class GutlessElement(initialState: ElementState) extends Actor {
  var state = initialState

  override def receive: Receive = ???
}

object GutlessElement {
  def props(state: ElementState) = Props(new GutlessElement(state))
}

case class ElementState
(
  up: Boolean,
  left: Boolean,
  down: Boolean,
  right: Boolean,
  position: (Int, Int)
)

object ElementState {
  def randomize(x: Int, y: Int) = {
    val random = new Random()
    ElementState(
      up = random.nextBoolean(),
      left = random.nextBoolean(),
      down = random.nextBoolean(),
      right = random.nextBoolean(),
      position = (x, y)
    )
  }
}

class GutlessSystem {
  def neighborhood: ElementState

  ()
}