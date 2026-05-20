fun main() {
  println("REGISTRO DE HUELLAS - SET")
  val registrosUnicos = setOf(101, 102, 103, 104, 108, 101, 103)
  println("ID de registros unicos: ${registrosUnicos}")

  println("Analisis de evidencia por sector")
  val sectorA = setOf(2, 4, 6, 8, 10)
  val sectorB = setOf(3, 6, 9, 12)
  println("Evidencias Sector A: ${sectorA}")
  println("Evidencias Sector B: ${sectorB}")

  println("Union de pruebas (Total): ${sectorA union sectorB}")
  println("Interseccion (Evidencia en ambos): ${sectorA intersect sectorB}")
  println("Substraccion (Solo en Sector A): ${sectorA subtract sectorB}")

  println("SISTEMA DE ETIQUETAS - SET MUTABLE")
  val etiquetas = mutableSetOf("robo", "balatro", "narcotico")
  println(etiquetas)
  
  etiquetas.add("robo")
  println(etiquetas)
  
  etiquetas.add("asalto")
  println(etiquetas)
  
  etiquetas.remove("hurto")
  println(etiquetas)
  
  println("Verificar etiqueta 'robo' en sistema: ${"robo" in etiquetas}")
  println("Verificar etiqueta 'hurto' en sistema: ${"hurto" in etiquetas}")
}