fun main() {
    println("Funciones")
    val saludo = saludo()
    println("$saludo")

    val suma = sumar(5,4)
    println(suma)
    println(restarTipoExpresion(5,3))
    println(restarTipoInferido(5,3))
    
    saludar("pedro")
}


fun saludo(): String {
    return "Hello desde una funcion"
}


fun sumar (a: Int, b: Int): Int{
    return a+b 
}

//tipo de exprecion

fun restarTipoExpresion(a: Int, b: Int)=a-b

//tipo de inferido

fun restarTipoInferido(a: Int, b: Int)=a-b
fun saludar(nombre: String){
println("Hola $nombre")
}
