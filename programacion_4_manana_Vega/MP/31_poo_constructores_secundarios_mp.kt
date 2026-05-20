class Celda(val ancho: Double, val alto: Double) {
    val areaConfinamiento: Double get() = ancho * alto
    val perimetroSeguridad: Double get() = 2 * (ancho + alto)
    constructor(lado: Double) : this(lado, lado)
    constructor(ancho: Int, alto: Int) : this(ancho.toDouble(), alto.toDouble())

    override fun toString() = "Celda(${ancho}x${alto}) | Área=$areaConfinamiento"
}

fun main() {
    val c1 = Celda(5.0, 3.0)
    val c2 = Celda(4.0)
    val c3 = Celda(6, 2)

    println(c1)
    println(c2)
}
