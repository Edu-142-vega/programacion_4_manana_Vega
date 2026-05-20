interface MetodoInterrogatorio {
    fun interrogar(sospechoso: String): Boolean
    val nombreMetodo: String
}

class InterrogatorioDirecto(val nombreOficial: String) : MetodoInterrogatorio {
    override val nombreMetodo = "Interrogatorio Directo"
    override fun interrogar(sospechoso: String): Boolean {
        println("👮 Oficial $nombreOficial interroga a $sospechoso")
        return true
    }
}

class TecnicaEmpatia(val psicologoNombre: String) : MetodoInterrogatorio {
    override val nombreMetodo = "Técnica de Empatía"
    override fun interrogar(sospechoso: String): Boolean {
        println("🧠 Psicólogo $psicologoNombre usa técnica empática con $sospechoso")
        return true
    }
}

class Videovigilancia(val camaraNro: Int) : MetodoInterrogatorio {
    override val nombreMetodo = "Vigilancia por Video"
    override fun interrogar(sospechoso: String): Boolean {
        println("📹 Cámara #$camaraNro monitoreando a $sospechoso")
        return true
    }
}

fun procesarInterrogatorio(sospechoso: String, metodo: MetodoInterrogatorio) {
    println("Iniciando interrogatorio con ${metodo.nombreMetodo}...")
    val exito = metodo.interrogar(sospechoso)
    println(if (exito) "✅ Información obtenida" else "❌ Interrogatorio fallido")
}

fun main() {
    val metodos: List<MetodoInterrogatorio> = listOf(
        InterrogatorioDirecto("Inspector García"),
        TecnicaEmpatia("Dr. López"),
        Videovigilancia(5)
    )

    metodos.forEach { procesarInterrogatorio("Juan Pérez", it) }
}
