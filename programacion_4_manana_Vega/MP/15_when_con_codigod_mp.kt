fun main() {
    println("SISTEMA DE EXPEDIENTE POLICIAL - REGISTRO DE DETENIDOS")

    println("Nombre del Detenido")
    val nombreDetenido = readLine()?.trim()?.lowercase() ?: "Sin identificar"
    
    println("Grado de Peligrosidad (ALTO/MEDIO/BAJO/MINIMO)")
    val nivelPeligrosidad = readLine()?.trim()?.uppercase() ?: ""

    when (nivelPeligrosidad) {
        "ALTO" -> {
            println("ALERTA DE SEGURIDAD: Detenido: $nombreDetenido")
            println("Traslado inmediato a celda de maxima seguridad")
            println("Activar protocolo de vigilancia 24/7")
        }
        
        "MEDIO" -> {
            println("RESTRICCION MEDIA: Detenido: $nombreDetenido")
            println("Ingreso a zona general con custodia")
        }
        
        "BAJO" -> println("Riesgo Bajo: Detenido: $nombreDetenido")
        
        "MINIMO" -> println("Riesgo Minimo: Detenido: $nombreDetenido - Procesar libertad bajo fianza")
        
        else -> println("Estado del detenido no reconocido en la base de datos")
    }
}