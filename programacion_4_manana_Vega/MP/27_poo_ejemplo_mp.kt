class Oficial(val nombre: String, val edad: Int)
class OficialAvanzado(val nombre: String, val edad: Int) {
    fun presentarse() = "Soy oficial $nombre y tengo $edad años en el cuerpo"
    fun esAptoParaOperacion() = edad >= 18
}

fun main() {
    val o = Oficial("García", 28)
    println(o.nombre)
    println(o.edad)

    val o2 = OficialAvanzado("López", 17)
    println(o2.presentarse())
    println(o2.esAptoParaOperacion())
}
