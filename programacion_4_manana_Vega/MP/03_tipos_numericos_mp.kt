/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */
fun main() {
 //Tipos basicos
//Numeros enteros 
val nombre="Lion s Kennedy"
val edad = 24
val numero1:Byte=47
println("ID del oficial $nombre: $numero1")
val numero2: Short=32767
println("Num del oficial $nombre: $numero2")
val numero3: Int=24
println("Edad del Oficial $nombre: $numero3")
val numero4:Long=12_122_122_122_123_123L
println("C.I. del oficial $nombre: $numero4")

println("calificacion del oficial: $nombre")
val numero5:Float=3.14f
println(" $numero5")
val numero6:Double=3.14159265
println("nota completa: $numero6")

//Inferido


    println("Nombre $nombre")
    val nombreTipo=nombre::class.simpleName
    println("Tipo inferido nombre: ${nombreTipo}")
    println("Edad $edad")
    val edadTipo=edad::class.simpleName
    println("Tipo inferido edad: ${edadTipo}")

}
