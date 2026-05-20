data class TipoEvidencia(val id: Int, val nombre: String)

data class Evidencia(
    val id:            Int,
    val descripcion:   String,
    val peso:          Double,
    val cantidad:      Int,
    val tipoEvidencia: TipoEvidencia,
    val catalogada:    Boolean = true
) {
    // ABSTRACCIÓN: el usuario consulta disponible sin saber la lógica
    val disponible: Boolean get() = catalogada && cantidad > 0
    val pesoTotal: Double get() = peso * 1.25

    fun aplicarDecomisoTemporal(porcentaje: Double): Evidencia {
        require(porcentaje in 0.0..100.0) { "Decomiso debe ser entre 0 y 100%" }
        return copy(cantidad = (cantidad * (1 - porcentaje / 100)).toInt())
    }
}

object RegistroEvidencias {
    private val tiposEvidencia = mutableListOf(
        TipoEvidencia(1, "Arma"),
        TipoEvidencia(2, "Documentos"),
        TipoEvidencia(3, "Drogas")
    )
    private val evidencias = mutableListOf<Evidencia>()
    private var siguienteId = 1

    fun agregarEvidencia(descripcion: String, peso: Double, cantidad: Int, tipoId: Int): Evidencia? {
        val tipo = tiposEvidencia.find { it.id == tipoId } ?: return null
        val evidencia = Evidencia(siguienteId++, descripcion, peso, cantidad, tipo)
        evidencias.add(evidencia)
        return evidencia
    }

    fun listar(): List<Evidencia>              = evidencias.toList()
    fun disponibles(): List<Evidencia>         = evidencias.filter { it.disponible }
    fun porTipo(id: Int): List<Evidencia>      = evidencias.filter { it.tipoEvidencia.id == id }
    fun buscar(query: String): List<Evidencia> =
        evidencias.filter { it.descripcion.contains(query, ignoreCase = true) }
}

fun main() {
    RegistroEvidencias.agregarEvidencia("Pistola 9mm",        2.5, 1, 1)
    RegistroEvidencias.agregarEvidencia("Pasaporte falso",    0.1, 0, 2)
    RegistroEvidencias.agregarEvidencia("Cocaína 500g",      10.0, 5, 3)
    RegistroEvidencias.agregarEvidencia("Billetera",          0.5, 8, 2)

    println("=== Todas las evidencias ===")
    RegistroEvidencias.listar().forEach { e ->
        val estado = if (e.disponible) "✅" else "❌"
        println("$estado ${e.descripcion} — ${String.format("%.2f", e.pesoTotal)}kg")
    }

    println("\n=== Disponibles con 10% decomiso ===")
    RegistroEvidencias.disponibles()
        .map { it.aplicarDecomisoTemporal(10.0) }
        .forEach { println("  ${it.descripcion}: ${it.cantidad} unidades") }
}
