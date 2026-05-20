fun main() {
    
    val nombre= "Lion S"
    val apellido ="Kennedy"
    val edad=24
    //variable simple 
    println("Hola $nombre bienvenido a tu expediente Policial")
    //expresion
    println("nombre completo; ${nombre.uppercase()} ${apellido.uppercase()}")
    println("Edad : ${edad+6} anos")
    
    //string multilinea
    
    val tarjeta = """
    |Nombre: $nombre $apellido
    |edad: $edad
    |Acceso: ${if(edad>=18)"Permitido" else "Denegado"}
    """.trimMargin()
    println(tarjeta)
}