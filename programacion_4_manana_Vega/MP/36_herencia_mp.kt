class Delincuente(val nombre: String)

open class Delincuente(val nombre: String, val modoOperandi: String) {
    open fun cometer() = println("$nombre actúa como: $modoOperandi")
    open fun descripcion() = "Soy delincuente $nombre"
    fun estaReportado() = println("$nombre está reportado en el sistema")
}

class Estafador(nombre: String) : Delincuente(nombre, "Estafa electrónica") {
    override fun cometer() {
        super.cometer()
        println("(Roba identidades digitales)")
    }
    override fun descripcion() = "${super.descripcion()}, especializado en estafas"
}

class Narcotraficante(nombre: String, val red: String) : Delincuente(nombre, "Tráfico de drogas") {
    override fun descripcion() =
        "${super.descripcion()}, integrante de ${if (red.isNotEmpty()) "red $red" else "célula independiente"}"
}

fun main() {
    val estafador = Estafador("Carlos")
    estafador.cometer()

    val narco = Narcotraficante("Miguel", "Los Andes")
    println(narco.descripcion())

    estafador.estaReportado()
}
