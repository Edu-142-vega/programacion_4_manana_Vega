package com.ute.mp.ui.material3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Paso01OfficialScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Text("Paso 1 - Registro de Oficiales",
            style = MaterialTheme.typography.titleMedium)
        HorizontalDivider()
        OfficialRegistration()
    }
}

@Composable
private fun OfficialRegistration() {
    Text("Gestor de Oficiales Policiales",
        style = MaterialTheme.typography.labelLarge,
        color = MaterialTheme.colorScheme.primary)
}
