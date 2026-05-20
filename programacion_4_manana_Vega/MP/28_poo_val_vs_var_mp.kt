class UbicacionInmutable(val latitud: Double, val longitud: Double)

class ContadorPistas(var cantidad: Int = 0) {
    fun registrarPista() { cantidad++ }
    fun limpiarRegistro()  { cantidad = 0 }
}

class Denuncia(numeroRadicado: String) {
    val numeroNormalizado = numeroRadicado.uppercase()
}
