fun main() {
    println("Controles de flujo")
    println("Condicional If - Múltiples condiciones (Expediente Policial)")
    
    println("Nivel de Gravedad del Incidente (Puntaje 0-200):")
    val gravedad = readLine()?.toIntOrNull() ?: 0

    val clasificacion = if (gravedad <= 50) {
        "Infracción Menor / Falta administrativa"
    } else if (gravedad <= 80) {
        "Delito de Grado 1 / Alteración del orden"
    } else if (gravedad <= 110) {
        "Delito de Grado 2 / Robo con fuerza"
    } else if (gravedad <= 140) {
        "Delito Grave / Asalto agravado"
    } else if (gravedad <= 179) {
        "Peligrosidad Alta / Crimen organizado"
    } else {
        "Código Rojo / Amenaza a la Seguridad Nacional"
    }
    
    println("Clasificación del caso: $clasificacion")
}