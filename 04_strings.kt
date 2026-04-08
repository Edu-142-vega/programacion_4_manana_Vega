fun main() {
    
    val nombre= "Peter"
    val apellido ="Parker"
    val edad=28
    //variable simple 
    println("Hola $nombre")
    //expresion
    println("nombre completo; ${nombre.uppercase()} ${apellido.uppercase()}")
    println("Edad : ${edad+6} años")
    
    //string multilinea
    
    val tarjeta = """
    |Nombre: $nombre $apellido
    |edad: $edad
    |Acceso: ${if(edad>=18)"Permitido" else "Denegado"}
    """.trimMargin()
    println(tarjeta)
}