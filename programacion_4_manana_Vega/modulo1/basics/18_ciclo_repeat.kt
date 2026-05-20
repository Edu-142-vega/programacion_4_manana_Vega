fun main() {
    println("Controles de Flujo Iteraciones, Ciclos repetitivos - Ciclo Repeat")
    println("Cuantas pulsaciones tomar para calcular frecuencia cardiaca")
    
    val mediciones = 6
    var temperaturaTotal= 0
    val fiebreTotal =0

    repeat(mediciones) { i ->
        println("escriba su temperatura")
         println("medicion ${i + 1} (temperatura cada 4 horas)")
        val temperatura= readLine()?.toIntOrNull() ?: 0
        temperaturaTotal +=temperatura
        if(temperatura >=38.5){
            fiebreTotal +1 }
    }

        val promedio = fiebreTotal / mediciones
        println("primedio :$promedio")
        if(fiebreTotal>2)
        println("si tiene fiebre sostenida")
}