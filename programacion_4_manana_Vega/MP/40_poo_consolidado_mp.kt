sealed class AlertaPolicial(val asunto: String, val contenido: String) {
    abstract fun formatear(): String

    data class AlertaBuscaPersona(
        val destinatario: String,
        val asunto_busqueda: String,
        val descripcion_persona: String
    ) : AlertaPolicial(asunto_busqueda, descripcion_persona) {
        override fun formatear() =
            "🚨 Alerta de Búsqueda → $destinatario\n   Asunto: $asunto\n   ${contenido.take(50)}..."
    }

    data class AlertaOperativo(val unidad: String, val prioridad: String = "Normal")
        : AlertaPolicial("Operativo", "") {
        override fun formatear() = "$prioridad Alerta de Operativo → Unidad $unidad: $asunto"
    }

    data class AlertaArresto(val detenido: String, val razon: String)
        : AlertaPolicial("Arresto", razon) {
        override fun formatear() = "🔗 Alerta de Arresto → $detenido: ${razon.take(160)}"
    }

    object SilenciosaSeguridad : AlertaPolicial("", "") {
        override fun formatear() = "🔇 Alerta silenciosa de seguridad interna"
    }
}

interface CentroDistribucionAlertas {
    val nombreCentro: String
    fun enviar(alerta: AlertaPolicial): Boolean
}

class CentroRadioComunicacion : CentroDistribucionAlertas {
    override val nombreCentro = "Radio Comunicación"
    override fun enviar(alerta: AlertaPolicial): Boolean {
        if (alerta !is AlertaPolicial.AlertaBuscaPersona) return false
        println("  [RADIO] → ${alerta.destinatario}")
        return true
    }
}

class CentroOperacionesMóvil : CentroDistribucionAlertas {
    override val nombreCentro = "Operaciones Móvil"
    override fun enviar(alerta: AlertaPolicial): Boolean {
        if (alerta !is AlertaPolicial.AlertaOperativo) return false
        println("  [MÓVIL] → Unidad ${alerta.unidad}")
        return true
    }
}

class ControlCentral(private val centros: List<CentroDistribucionAlertas>) {

    fun emitir(alerta: AlertaPolicial) {
        println(alerta.formatear())
        val exito = centros.any { it.enviar(alerta) }
        if (!exito) println("  ⚠️ Sin centro disponible para esta alerta")
        println()
    }
}

fun main() {
    val controlCentral = ControlCentral(listOf(CentroRadioComunicacion(), CentroOperacionesMóvil()))

    listOf(
        AlertaPolicial.AlertaBuscaPersona("Estación Centro", "Busca de fugitivo", "Varón, 1.75m, tatuajes visibles"),
        AlertaPolicial.AlertaOperativo("Unidad-5"),
        AlertaPolicial.AlertaArresto("Juan Pérez", "Sospechoso de robo"),
        AlertaPolicial.SilenciosaSeguridad
    ).forEach { controlCentral.emitir(it) }
}
