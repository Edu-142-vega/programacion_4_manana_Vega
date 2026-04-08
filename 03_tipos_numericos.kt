/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */
fun main() {
 //Tipos basicos
//Numeros enteros 
val numero1:Byte=127
println("numero Byte $numero1")
val numero2: Short=32_765
println("numero Short $numero2")
val numero3: Int=12
println("numero Int $numero3")
val numero4:Long=12_122_122_122_123_123L
println("numero Long $numero4")

println("Numeros decimales")
val numero5:Float=3.14f
println("numero Float $numero5")
val numero6:Double=3.14159265
println("numero Double $numero6")

//Inferido

val nombre ="juana"
    val edad =56
    println("Nombre $nombre")
    val nombreTipo=nombre::class.simpleName
    println("Tipo inferido nombre: ${nombreTipo}")
    println("Edad $edad")
    val edadTipo=edad::class.simpleName
    println("Tipo inferido edad: ${edadTipo}")

    


}