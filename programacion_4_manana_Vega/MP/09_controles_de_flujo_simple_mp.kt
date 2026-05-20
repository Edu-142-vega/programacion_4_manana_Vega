fun main() {
    println("Controles de Flujo - Expediente Policial")
    println("Condicional If")
    println("Incluir Grado de Peligrosidad del detenido (1.0 - 50.0):")
    val peligrosidad = readLine()?.toDoubleOrNull() ?: 10.0
    
    if (peligrosidad >= 38.0) {
        println("Alerta detectada: requiere traslado en unidad blindada")
    }
    if (peligrosidad >= 40.0) {
        println("Riesgo extremo: solicitar refuerzos y vigilancia 24h")
    }
    println("Peligrosidad registrada: $peligrosidad puntos en el expediente")
}