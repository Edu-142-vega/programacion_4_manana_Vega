class NivelRiesgo(riesgoInicial: Double) {

    var riesgo: Double = riesgoInicial
        set(value) {
            require(value >= 0.0) { "El nivel de riesgo no puede ser negativo" }
            field = value
        }
    val clasificacion: String
        get() = when {
            riesgo < 20.0  -> "Bajo"
            riesgo < 40.0  -> "Moderado"
            riesgo < 60.0  -> "Alto"
            riesgo < 80.0  -> "Muy Alto"
            else           -> "Crítico"
        }

    val recomendacion: String
        get() = when {
            riesgo < 20.0  -> "Vigilancia normal"
            riesgo < 40.0  -> "Vigilancia reforzada"
            riesgo < 60.0  -> "Custodia especial"
            riesgo < 80.0  -> "Aislamiento preventivo"
            else           -> "Protocolo de máxima seguridad"
        }
}

fun main() {
    val nivel = NivelRiesgo(45.0)
    println("Nivel de riesgo: ${nivel.riesgo}° = ${nivel.clasificacion}")
    println(nivel.recomendacion)

    nivel.riesgo = 15.0
    println("Nivel de riesgo: ${nivel.riesgo}° → ${nivel.clasificacion}")
}
