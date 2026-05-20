fun main() {
  println("Controles de Flujo")
  println("Condicional If - else")
  println("Tiene seguro médico s/n:")
  val tieneSeguro = readLine()?.trim()?.lowercase()=="s"
  println("Costo Base: ")
      println("Fiebre detectada: derivar consulta prioritaria")
 val costoBase =readLine()?.toDoubleOrNull()?:0.0
  if(tieneSeguro){
      val cobertura = costoBase*0.80
      println("Seguro cubre: $${"%.2f".format(cobertura)}")
  } else {
  println("Pago Particular: $${"%.2f".format(costoBase)}")
  }
}