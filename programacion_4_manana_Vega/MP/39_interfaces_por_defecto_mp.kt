interface Reporteable {
    val numeroExpediente: String
    fun generarReporte(): String
    val version: Int get() = 1
}

interface Verificable {
    val inconsistencias: List<String>
    val esValido: Boolean get() = inconsistencias.isEmpty()

    fun verificar(): Boolean
    fun mostrarInconsistencias() {
        if (inconsistencias.isEmpty()) println("Sin inconsistencias")
        else inconsistencias.forEach { println("  ❌ $it") }
    }
}

data class Denuncia(
    override val numeroExpediente: String,
    val denunciante: String,
    val hechos: List<String>,
    val fecha: String
) : Reporteable, Verificable {

    override fun generarReporte() =
        "$numeroExpediente|$denunciante|${hechos.joinToString(",")}|$fecha"

    override val inconsistencias: List<String> get() = buildList {
        if (denunciante.isBlank()) add("Denunciante no puede estar vacío")
        if (hechos.isEmpty())      add("La denuncia debe describir los hechos")
        if (fecha.isBlank())       add("La fecha de denuncia debe especificarse")
    }

    override fun verificar() = esValido
}

fun main() {
    val denuncia1 = Denuncia("DEN-001", "Víctima García", listOf("Robo en comercio"), "2024-05-11")
    val denuncia2 = Denuncia("DEN-002", "",    emptyList(),                           "")

    fun procesarReporteable(r: Reporteable) = println("→ ${r.generarReporte()}")
    fun procesarVerificable(v: Verificable) {
        println("Válido: ${v.esValido}")
        v.mostrarInconsistencias()
    }

    procesarReporteable(denuncia1)
    procesarVerificable(denuncia1)
    procesarVerificable(denuncia2)
}
