fun main() {
    println("SISTEMA DE MONITOREO DE RECLUSOS - CICLO REPEAT")
    
    val mediciones = 6
    var sumaTemperatura = 0
    var casosFiebre = 0

    repeat(mediciones) { i ->
        println("Medicion ${i + 1}: Ingrese temperatura")
        val temperatura = readLine()?.toIntOrNull() ?: 0
        
        sumaTemperatura += temperatura
        
        if (temperatura >= 38) {
            casosFiebre++ 
        }
    }

    val promedio = sumaTemperatura / mediciones
    
    println("Promedio de temperatura: $promedio")
    println("Alertas detectadas: $casosFiebre")
    
    if (casosFiebre > 2) {
        println("Alerta: Fiebre sostenida. Notificar a enfermeria.")
    } else {
        println("Estado estable.")
    }
}