class Arma(
    val id:           Int,
    val modelo:       String,
    val calibre:      Double,
    private val municiones: Int
) {
    val valorRiesgo: Double
        get() = calibre * 2.5

    val operativa: Boolean
        get() = municiones > 0

    override fun toString() = "$modelo (Calibre: ${String.format("%.2f", calibre)})"
}

fun main() {
    val pistola = Arma(1, "Glock 9mm", 9.0, 15)

    println(pistola.operativa)
    println(pistola.valorRiesgo)
    println(pistola)
    
}
