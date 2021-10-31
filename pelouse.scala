package Project

class pelouse {
  private var xlim = 0
  private var ylim = 0


  def get_Xlim : Int = xlim /* la limite de la pelouse sur l'axe X */

  def get_Ylim : Int = ylim  /* la limite de la pelouse sur l'axe Y */

  /* on se basant sur notre fichier d'entrée on défini les coordonnée de la pelouse  */
  def Pelouse(coord: String): Unit ={

    val point_supdroit = coord.split(" ")

    this.xlim= point_supdroit(0).toInt
    this.ylim = point_supdroit(1).toInt
  }
}

