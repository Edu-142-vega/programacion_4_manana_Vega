fun main() {
  println("MAPA DE ASIGNACION DE CELDAS - INMUTABLE")
  val celdas = mapOf(
    "SectorA" to "Detenido_01",
    "SectorB" to "Detenido_02",
    "SectorC" to "Detenido_03",
    "SectorD" to "Detenido_04",
  )
  
  println(celdas["SectorA"])
  println(celdas["SectorZ"])
  println(celdas.getOrDefault("SectorA", "No asignado"))
  println(celdas.getOrDefault("SectorZ", "No asignado"))
  
  println(celdas)
  println(celdas.keys)
  println(celdas.values)
  println(celdas.entries)
  
  for ((sector, recluso) in celdas) {
    println("$sector - $recluso")
  }
    
  println("INVENTARIO DE ARMERIA - MUTABLE")
  val armeria = mutableMapOf(
    "Fusiles" to 10,
    "Patrullas" to 4,
    "Chalecos" to 12,
    "Radios" to 8,
  )
  
  armeria["Escudos"] = 5
  println(armeria)
  
  armeria["Fusiles"] = 20
  println(armeria)
  
  armeria.remove("Radios")
  println(armeria)
  
  armeria.getOrPut("Municion") { 15 }
  println(armeria)
  
  armeria.getOrPut("Chalecos") { 15 }
  println(armeria)
}