data class CategoriaDelito(val id: Int, val nombre: String)

data class Delito(
    val id:              Int,
    val nombre:          String,
    val penaAnyos:       Double,
    val casosRegistrados: Int,
    val categoriaDelito: CategoriaDelito,
    val vigente:         Boolean = true
) {
    // ABSTRACCIÓN: el usuario consulta severidad sin saber la lógica
    val severidad: Boolean get() = vigente && casosRegistrados > 0
    val penaltyMultiple: Double get() = penaAnyos * 1.25

    fun aplicarAgravante(porcentaje: Double): Delito {
        require(porcentaje in 0.0..100.0) { "Agravante debe ser entre 0 y 100%" }
        return copy(penaAnyos = penaAnyos * (1 + porcentaje / 100))
    }
}

object CatalogoDelitos {
    private val categorias = mutableListOf(
        CategoriaDelito(1, "Violencia"),
        CategoriaDelito(2, "Tráfico"),
        CategoriaDelito(3, "Fraude")
    )
    private val delitos = mutableListOf<Delito>()
    private var siguienteId = 1

    fun agregarDelito(nombre: String, pena: Double, casos: Int, categoriaId: Int): Delito? {
        val categoria = categorias.find { it.id == categoriaId } ?: return null
        val delito = Delito(siguienteId++, nombre, pena, casos, categoria)
        delitos.add(delito)
        return delito
    }

    fun listar(): List<Delito>              = delitos.toList()
    fun vigentes(): List<Delito>            = delitos.filter { it.severidad }
    fun porCategoria(id: Int): List<Delito> = delitos.filter { it.categoriaDelito.id == id }
    fun buscar(query: String): List<Delito> =
        delitos.filter { it.nombre.contains(query, ignoreCase = true) }
}

fun main() {
    CatalogoDelitos.agregarDelito("Homicidio",           30.0, 15, 1)
    CatalogoDelitos.agregarDelito("Tráfico de cocaína",  15.0,  0, 2)
    CatalogoDelitos.agregarDelito("Estafa electrónica", 20.0,  5, 3)
    CatalogoDelitos.agregarDelito("Asalto a mano armada", 10.0, 8, 1)

    println("=== Todos los delitos ===")
    CatalogoDelitos.listar().forEach { d ->
        val estado = if (d.severidad) "✅" else "❌"
        println("$estado ${d.nombre} — ${String.format("%.2f", d.penaltyMultiple)} años")
    }

    println("\n=== Vigentes con agravante del 10% ===")
    CatalogoDelitos.vigentes()
        .map { it.aplicarAgravante(10.0) }
        .forEach { println("  ${it.nombre}: ${String.format("%.2f", it.penaAnyos)} años") }
}
