object DatosComisaria {
    val direccion: String = "Calle Central 123"
    val telefono: Int    = 2612345678
    private val codigoSeguridad: String = "POL-MASTER-2024"

    fun urlAcceso() = "https://$direccion:443"
    fun encabezadosAutenticacion() = mapOf("Autorizacion" to "Bearer $codigoSeguridad")
}

class Oficial private constructor(val id: Int, val nombre: String) {
    companion object {
        private var contadorId = 0

        fun registrar(nombre: String, badge: String): Oficial? {
            if (nombre.isBlank() || !badge.contains("-")) return null
            return Oficial(++contadorId, nombre.trim())
        }

        const val RANGO_DEFECTO = "Patrullero"
    }
}

fun main() {
    println(DatosComisaria.urlAcceso())

    val o = Oficial.registrar("García", "POL-001")
    println(o)
}
