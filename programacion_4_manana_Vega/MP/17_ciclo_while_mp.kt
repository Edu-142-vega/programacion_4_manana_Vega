fun main() {
    println("SISTEMA DE MONITOREO - CICLOS WHILE")

    println("Conteo de patrullas")
    var unidades = 1
    while (unidades <= 5) {
        println("Unidad $unidades en linea")
        unidades++
    }

    println("Verificacion de celdas")
    unidades = 1
    do {
        println("Celda $unidades asegurada")
        unidades++
    } while (unidades <= 5)

    println("Escaneo de perimetros")
    var zona = 1
    while (zona <= 10) {
        zona++
        if (zona == 3) continue
        if (zona == 7) break
        println("Zona $zona despejada")
    }

    var entrada: String
    while (true) {
        println("Ingrese codigo de oficial o 'salir'")
        entrada = readLine() ?: ""
        if (entrada == "salir") break
        println("Oficial registrado: $entrada")
    }
}