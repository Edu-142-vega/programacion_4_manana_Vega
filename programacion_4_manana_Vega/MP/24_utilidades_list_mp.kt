fun main() {
     println("UTILIDADES DE EXPEDIENTES - LISTAS")
     
     val idCasos = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
     println(idCasos)
    
     val codigosCeldas = idCasos.map { it * it }    
     println(codigosCeldas)
     
     val etiquetasExpediente = idCasos.map { "expediente:$it" }
     println(etiquetasExpediente)
     
     println("Filtros de busqueda")
     val casosPrioritarios = idCasos.filter { it % 2 == 0 }
     println(casosPrioritarios)
    
     val casosRecientes = idCasos.filter { it > 5 }
     println(casosRecientes)
    
     val alertasCriticas = idCasos.filter { it % 2 == 0 && it > 5 }
     println(alertasCriticas)
    
     val casosPendientes = idCasos.filterNot { it % 2 == 0 }
     println(casosPendientes)
    
     val evidenciaMezclada = listOf(1, "Arma", 2, "ilegalxd", true, 42)
     val soloTextoEvidencia = evidenciaMezclada.filterIsInstance<String>()
     println(soloTextoEvidencia)
    
     println("Procesamiento acumulado (Reduce)")
     val multasReducidas = listOf(1, 2, 3, 4, 5)
     val sumaMultas = multasReducidas.reduce { acc, n -> acc + n }
     println(sumaMultas)
     val impactoTotal = multasReducidas.reduce { acc, n -> acc * n }
     println(impactoTotal)
    
    
     println("Procesamiento con base (Fold)")
     val baseHistorial = 100
     val totalConHistorial = multasReducidas.fold(baseHistorial) { acc, n -> acc + n }
     println(totalConHistorial)
     val calculoEspecial = multasReducidas.fold(baseHistorial) { acc, n -> acc * n }
     println(calculoEspecial)
    
     println("Ordenacion de registros")
     println("Ascendente: ${idCasos.sorted()}")
     println("Descendente: ${idCasos.sortedDescending()}")
     println("Por prioridad inversa: ${idCasos.sortedBy { -it }}")

     println("Agregacion de datos")
     println("Suma total casos: ${idCasos.sum()}")
     println("Promedio gravedad: ${idCasos.average()}")
     println("ID minimo: ${idCasos.minOrNull()}")
     println("ID maximo: ${idCasos.maxOrNull()}")
     println("Conteo casos graves: ${idCasos.count { it > 4 }}")

     println("Busqueda en base de datos")
     println("Buscar primer registro: ${idCasos.find { it > 4 }}")
     println("Buscar ultimo registro: ${idCasos.findLast { it > 4 }}")
     println("Existe algun riesgo: ${idCasos.any { it > 4 }}")
     println("Todos cumplen norma: ${idCasos.all { it > 0 }}")
     println("Ninguno supera limite: ${idCasos.none { it > 10 }}")
}