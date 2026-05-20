fun main() {
println("Controoles de flujo")
println("Condicional If - Multiples condiciones")
println("Presion sistolica mmHg")
val sistolica=readLine()?.toIntOrNull()?:0

val clasificacion = if (sistolica<=90){
    "hipertension"
} else if(sistolica<=119){
    "normal"
} else if(sistolica<=129){
    "Elevada"
} else if (sistolica<=139){
    "Hiperternsion Grado 1"
} else if(sistolica<=179){
    "Hipertencion Grado 2"
    }
    else{
        "Crisis Hipertensiva"
    }
println("Clasificacion: $clasificacion")
}