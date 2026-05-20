fun main() {
    println("SISTEMA DE EXPEDIENTES - FUNCIONES")
    
    val informe = generarInforme()
    println("$informe")

    val sumaEvidencias = sumarCasos(10, 5)
    println(sumaEvidencias)
    
    println(calcularSentenciaExpresion(20, 5))
    println(calcularSentenciaInferido(15, 3))
    
    registrarDetenido("Sujeto_B")
}

fun generarInforme(): String {
    return "Registro de entrada desde funcion activa"
}

fun sumarCasos(a: Int, b: Int): Int {
    return a + b 
}

fun calcularSentenciaExpresion(a: Int, b: Int) = a - b

fun calcularSentenciaInferido(a: Int, b: Int) = a - b

fun registrarDetenido(nombre: String) {
    println("Procesando a: $nombre")
}