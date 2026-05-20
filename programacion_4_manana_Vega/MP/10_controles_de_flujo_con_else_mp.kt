fun main() {
    println("Controles de Flujo")
    println("Condicional If - else")
    
    println("¿Tiene antecedentes penales? s/n:")
    val tieneAntecedentes = readLine()?.trim()?.lowercase() == "s"
    
    println("Multa base por infracción: ")
    val costoBase = readLine()?.toDoubleOrNull() ?: 0.0
    
    if (tieneAntecedentes) {
        // Si tiene antecedentes, se aplica un recargo por reincidencia del 80%
        val recargo = costoBase * 0.80
        val total = costoBase + recargo
        println("Reincidente detectado: se aplica recargo del 80%")
        println("Monto total con recargo: $${"%.2f".format(total)}")
    } else {
        // Si no tiene, paga el costo base sin penalización extra
        println("Sin antecedentes previos. Pago de multa base: $${"%.2f".format(costoBase)}")
    }
}