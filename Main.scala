//Wissam ZIANE M2 IMSD projet Scala

package Project

object Main extends App {

  /* declaration de nos donnees d'entree on utilisant le package io.source et le fichier test */
  val serie_instructions = io.Source.fromResource("test")
  val instruction = serie_instructions.getLines()
  val limite_coord = instruction.next()

  //Création de la surface qu'on doit tondre qui est la pelouse qui est supposé être (0,0)) au début /

   val pelouse = new pelouse()


  pelouse.Pelouse(limite_coord) //Initialisation des limites de la pelouse //

  //nombre de tondeuses//
  var nb_tondeuse = 1
  println("Début du programme \n---> Les limites de la pelouse sont xlim= "+pelouse.get_Xlim+" et ylim= "+pelouse.get_Ylim)
  while (instruction.hasNext) {

    //Récupérer la position initiale de la tondeuse//
    val pos_tondeuse = instruction.next().split(" ")
    val tond_x=pos_tondeuse(0).toInt
    val tond_y=pos_tondeuse(1).toInt
    val tond_orientation=pos_tondeuse(2).charAt(0)

    if (List('N', 'S', 'E', 'W').contains(tond_orientation)) {
      //Initialiser de la tondeuse avec x et y //
      val tondeuse: Tondeuse = new Tondeuse(pelouse, tond_x, tond_y, tond_orientation)

      //les déplacement effectuer par la tondeuse//
      val serie_deplacements = instruction.next().toCharArray


      for (i <- 0 until serie_deplacements.length) {
        serie_deplacements(i) match {
          case 'D' => tondeuse.go_Right()
          case 'G' => tondeuse.go_Left()
          case 'A' => tondeuse.computeCoord()
          case _ => println("Pour la tondeuse n°:"+nb_tondeuse+", l'instruction de déplacement ne peut être autre que 'D' pour tourner à droite ou 'G' pour tourner à gauche ou 'A' pour avancer.\nL'instruction ("+serie_deplacements(i)+") a donc été ignorée.")
        }
      }
      println("Tondeuse " + nb_tondeuse + " : " + tondeuse.coordX + " " + tondeuse.coordY + " " + tondeuse.charOrientation)
      nb_tondeuse += 1
    }
    else{
      println("Orientation initiale ("+tond_orientation+") de la tondeuse n°"+nb_tondeuse+" est non reconnue. Elle a été ignorée. \n---> Rappel : L'orientation ne peut être autre que 'N, E, W, S'")
      val serie_deplacements = instruction.next().toCharArray
      nb_tondeuse += 1
    }

  }
  println("---> Nombre de tondeuses étudiées :"+(nb_tondeuse-1)+"\nFin du programme.")

}
