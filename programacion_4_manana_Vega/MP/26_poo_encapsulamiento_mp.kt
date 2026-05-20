class ExpedientePolicial(numeroPlaca: String, titular: String) {

    val numeroPlaca: String = numeroPlaca

    private var presupuesto: Double = 0.0

    internal val numeroExpediente: String =
        "POL-${(100000..999999).random()}"

    protected open fun calcularCostos(): Double = presupuesto * 0.05
    fun asignarPresupuesto(monto: Double) {
        require(monto > 0) { "El monto debe ser positivo" }
        presupuesto += monto
        println("Presupuesto asignado: \$${String.format("%.2f", monto)} | Nuevo presupuesto: ${consultarPresupuesto()}")
    }

    fun gastarPresupuesto(monto: Double): Boolean {
        require(monto > 0) { "El monto debe ser positivo" }
        if (monto > presupuesto) {
            println("Presupuesto insuficiente para la operación")
            return false
        }
        presupuesto -= monto
        println("Gasto realizado: \$${String.format("%.2f", monto)} | Presupuesto restante: ${consultarPresupuesto()}")
        return true
    }

    fun consultarPresupuesto(): String = "\$${String.format("%.2f", presupuesto)}"
}

fun main() {
    val expediente = ExpedientePolicial("PLACA-001", "Oficial García")

    expediente.asignarPresupuesto(5000.0)
    expediente.gastarPresupuesto(2000.0)
    expediente.gastarPresupuesto(20000.0)

    println(expediente.numeroPlaca)
    println(expediente.consultarPresupuesto())
}
