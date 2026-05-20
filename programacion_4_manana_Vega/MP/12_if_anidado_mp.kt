fun main() {
    println("¿Es reincidente el detenido? (s/n)")
    val esReincidente = readLine()?.trim()?.lowercase() == "s"

    println("Nivel de agresividad detectado (0-150)")
    val agresividad = readLine()?.toIntOrNull() ?: 0

    if (esReincidente) {
        println("Estado: Sujeto con historial delictivo previo")
        if (agresividad < 50) {
            println("Protocolo: Vigilancia estandar en celda comun")
        } else if (agresividad > 100) {
            println("Protocolo: Traslado inmediato a máxima seguridad")
        } else {
            println("Protocolo: Monitoreo preventivo")
        }
    } else {
        println("Estado: Primer ingreso al sistema")
        if (agresividad < 50 || agresividad > 100) {
            println("Alerta: Comportamiento atipico, requiere evaluación psicológica")
        } else {
            println("Estado: Procedimiento administrativo normal")
        }
    }
}