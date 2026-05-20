package com.ute.mp.model

data class Oficial(
    val id: Int,
    val nombre: String,
    val placa: String,
    val rango: String,
    val contacto: String,
    val activo: Boolean = true
)

val oficialesMuestra = listOf(
    Oficial(1, "Carlos Garcia", "PLACA-001", "Inspector", "555-0001", true),
    Oficial(2, "Maria Lopez", "PLACA-002", "Sargento", "555-0002", true),
    Oficial(3, "Juan Rodriguez", "PLACA-003", "Patrullero", "555-0003", true),
    Oficial(4, "Ana Martinez", "PLACA-004", "Inspector", "555-0004", false),
    Oficial(5, "Pedro Sanchez", "PLACA-005", "Patrullero", "555-0005", true)
)

data class Evidencia(
    val id: Int,
    val tipo: String,
    val descripcion: String,
    val cantidad: Int,
    val expediente: String
)

val evidenciasMuestra = listOf(
    Evidencia(1, "Arma", "Pistola 9mm", 1, "EXP-2026-001"),
    Evidencia(2, "Documentos", "Pasaporte falso", 2, "EXP-2026-001"),
    Evidencia(3, "Drogas", "Cocaina 500g", 5, "EXP-2026-002"),
    Evidencia(4, "Dinero", "Billete de 100 USD", 50, "EXP-2026-003")
)
