package com.ute.mp.ui.material3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ute.mp.model.Evidencia
import com.ute.mp.model.evidenciasMuestra

@Composable
fun Paso02EvidenceScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Paso 2 - Catalogo de Evidencias",
            style = MaterialTheme.typography.titleMedium)
        HorizontalDivider()
        EvidenceList(evidenciasMuestra)
    }
}

@Composable
private fun EvidenceList(evidencias: List<Evidencia>) {
    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(evidencias) { evidencia ->
            Card(modifier = Modifier.fillMaxSize()) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Text("Tipo: ${evidencia.tipo}", style = MaterialTheme.typography.labelMedium)
                    Text("Desc: ${evidencia.descripcion}", style = MaterialTheme.typography.bodySmall)
                    Text("Cantidad: ${evidencia.cantidad}", style = MaterialTheme.typography.bodySmall)
                    Text("Expediente: ${evidencia.expediente}", style = MaterialTheme.typography.bodySmall)
                }
            }
        }
    }
}
