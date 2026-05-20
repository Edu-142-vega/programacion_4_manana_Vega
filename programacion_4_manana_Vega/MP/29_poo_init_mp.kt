class Sospechoso(val nombre: String, val cedula: String) {
    val nombreNormalizado: String
    val institucionSolicitante: String

    init {
        require(nombre.isNotBlank()) { "El nombre no puede estar vacío" }
        require(cedula.contains("-")) { "Cédula inválida: $cedula" }

        nombreNormalizado = nombre.trim().lowercase()
        institucionSolicitante = cedula.substringAfter("-")
    }
}

fun main() {
    val s = Sospechoso("  Juan Pérez  ", "V-12345678")
    println(s.nombreNormalizado)
    println(s.institucionSolicitante)
}
