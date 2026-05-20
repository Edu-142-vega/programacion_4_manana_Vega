fun main() {
  println("SISTEMA DE EVIDENCIAS - LISTAS")
  val evidencias = listOf("arma", "celular", "ilegalidadxd", "celular", "dinero")
  println("Cantidad total: ${evidencias.size}")
  println("Primer registro: ${evidencias[0]}")
  println("Primera evidencia: ${evidencias.first()}")
  println("Ultima evidencia: ${evidencias.last()}")
  
  println("Evidencia en posicion 2: ${evidencias.get(2)}")
  println("Indice de hallazgo celular: ${evidencias.indexOf("celular")}")
  println("Existe droga en el registro: ${evidencias.contains("droga")}")
  println("Confirmar celular en lista: ${"celular" in evidencias}")

  println("Sublista de control: ${evidencias.subList(1, 3)}")
  println("Priorizar primeros 2: ${evidencias.take(2)}")
  println("Omitir primeros 3: ${evidencias.drop(3)}")
  println("Ultimos elementos: ${evidencias.takeLast(2)}")
  
  for(evidencia in evidencias){
      println("Articulo: $evidencia")
  }
  
  println("REGISTRO DE SOSPECHOSOS - MUTABLE")
  val sospechosos = mutableListOf("Sujeto_A", "Sujeto_B", "Sujeto_C", "Sujeto_D")
  
  println(sospechosos)
  sospechosos.add("Sujeto_E")
  println(sospechosos)
  sospechosos.add(0, "Sujeto_Prioritario")
  println(sospechosos)
  sospechosos.remove("Sujeto_E")
  println(sospechosos)
  sospechosos[1] = "Sujeto_Identificado"
  println(sospechosos)
  
  println("COLA DE PROCESAMIENTO JUDICIAL (DEQUE)")
  val colaProceso = ArrayDeque<Int>()
  println(colaProceso)
  colaProceso.addFirst(101)
  println(colaProceso)
  colaProceso.addLast(102)
  println(colaProceso)
  colaProceso.addLast(100)
  println(colaProceso)
  colaProceso.removeFirst()
  println(colaProceso)
  colaProceso.removeLast()
  println(colaProceso)
}