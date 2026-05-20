fun main() {
    println("Controles de Flujo When - Expediente Policial")
    println("Escriba el codigo de unidad asignada:")
    val codigo = readLine()?.toIntOrNull() ?: 0
    
    val unidadEspecializada = when(codigo) {
        1 -> "Patrullaje Preventivo"
        2 -> "Investigacion Criminal (DINASED)"
        3 -> "Antinarcoticos"
        4 -> "Policia Judicial"
        5 -> "Inteligencia Estrategica"
        6 -> "Criminalistica"
        else -> "Unidad no registrada en el sistema policial"
    }
    
    println("Unidad a cargo del caso: $unidadEspecializada")
}