enum class EstadoExpediente(val descripcion: String, val esFinal: Boolean) {
    ABIERTO    ("Expediente en investigación",      false),
    EN_ANALISIS("Siendo analizado por fiscalía",    false),
    RESUELTO   ("Caso finalizado exitosamente",     true),
    SOBRESEIDO ("Caso cerrado sin culpables",       true),
    PRESCRITO  ("Delito prescritos legalmente",     true);

    fun puedeTransicionarA(siguiente: EstadoExpediente): Boolean = when (this) {
        ABIERTO    -> siguiente == EN_ANALISIS || siguiente == PRESCRITO
        EN_ANALISIS-> siguiente == RESUELTO || siguiente == SOBRESEIDO
        else       -> false
    }
}

fun main() {
    val estado = EstadoExpediente.EN_ANALISIS
    println(estado.descripcion)
    println(estado.esFinal)

    val icono = when (estado) {
        EstadoExpediente.ABIERTO    -> "🔍"
        EstadoExpediente.EN_ANALISIS-> "📋"
        EstadoExpediente.RESUELTO   -> "✅"
        EstadoExpediente.SOBRESEIDO -> "⚖️"
        EstadoExpediente.PRESCRITO  -> "⏳"
    }
    println(icono)

    println(estado.puedeTransicionarA(EstadoExpediente.RESUELTO))
}
