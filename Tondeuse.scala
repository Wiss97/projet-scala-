// Wissam ZIANE M2 IMSD

package Project

class Tondeuse(pelouse: pelouse, var x: Int, var y: Int, var direction : Char) {

  /* Récupération de la position de la tondeuse */
  def coordX: Int = x
  def coordY: Int = y
  def charOrientation: Char = direction

  /* faire pivoter la tondeuse de 90°a gauche   */
  def go_Left(): Unit = {
    direction = direction match {
      case 'N' => 'W'
      case 'E' => 'N'
      case 'S' => 'E'
      case 'W' => 'S'
      case _ => direction
    }
  }

  /* faire pivoter la tondeuse de 90° vers la droite */
  def go_Right(): Unit = {
    direction = direction match {
      case 'N' => 'E'
      case 'E' => 'S'
      case 'S' => 'W'
      case 'W' => 'N'
      case _ => direction
    }
  }

  /* ensuite on récupère les nouvelles coordonnées qu'on souhaite avoir */

  def computeCoord(): Unit = {
    direction match {
      case 'N' => if (y + 1 <= pelouse.get_Ylim) y += 1 else y
      case 'E' => if (x + 1 <= pelouse.get_Xlim) x += 1 else x
      case 'W' => if (x - 1 >= 0) x -= 1 else x
      case 'S' => if (y - 1 >= 0) y -= 1 else y
      case _ => x & y
    }
  }

}
