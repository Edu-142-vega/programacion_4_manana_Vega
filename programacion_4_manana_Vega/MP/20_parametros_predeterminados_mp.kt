fun main() {
    println("SISTEMA DE EXPEDIENTES - REGISTRO DE PERSONAL")
    println(registrarOficial("Jhon", 25, "oficial", true))
    println(registrarOficial("Luis"))
    println(registrarOficial("Maria", 30))
    println(registrarOficial("Juan", 30, "detective"))
    
    println(registrarOficial(edad=30, nombre="Yamilet", activo=false))
}

fun registrarOficial(
    nombre: String,
    edad: Int = 20,
    rango: String = "patrullero",
    activo: Boolean = true
): String {
    return "Oficial[$nombre, edad=$edad, rango=$rango, activo=$activo]"
}