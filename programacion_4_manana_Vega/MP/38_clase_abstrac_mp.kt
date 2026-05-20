abstract class Delito(val nombre: String) {
    abstract val penal: Double
    abstract val plazo: Double
    abstract fun descripcion(): String
    fun compararGravedad(otro: Delito): String = when {
        penal > otro.penal -> "$nombre es más grave que ${otro.nombre}"
        penal < otro.penal -> "$nombre es menos grave que ${otro.nombre}"
        else             -> "$nombre y ${otro.nombre} tienen la misma gravedad"
    }

    override fun toString() = "${descripcion()} | Pena: ${String.format("%.2f", penal)} años"
}

class DelitoHomicidio(val tipoHomicidio: String) : Delito("Homicidio") {
    override val penal:    Double get() = 30.0
    override val plazo:    Double get() = 60.0
    override fun descripcion() = "Homicidio de tipo $tipoHomicidio"
}

class DelitoRobo(val valoresRobados: Double) : Delito("Robo") {
    override val penal:    Double get() = 8.0
    override val plazo:    Double get() = 10.0
    override fun descripcion() = "Robo de \$${String.format("%.2f", valoresRobados)}"
}

class DelitoTraficodeDrogas(val kilosIncautados: Double) : Delito("Tráfico de Drogas") {
    override val penal:    Double get() = (Math.sqrt(3.0) / 4) * kilosIncautados
    override val plazo:    Double get() = 3 * kilosIncautados
    override fun descripcion() = "Tráfico de drogas: ${kilosIncautados}kg incautados"
}

fun main() {
    val delitos: List<Delito> = listOf(
        DelitoHomicidio("Premeditado"),
        DelitoRobo(50000.0),
        DelitoTraficodeDrogas(8.0)
    )

    delitos.forEach { println(it) }

    val masGrave = delitos.maxByOrNull { it.penal }
    println("\nDelito más grave: ${masGrave?.nombre}")

    println(delitos[0].compararGravedad(delitos[1]))
}
