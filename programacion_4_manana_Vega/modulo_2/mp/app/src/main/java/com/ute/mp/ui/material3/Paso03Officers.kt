package com.ute.mp.ui.material3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ute.mp.model.Oficial
import com.ute.mp.model.oficialesMuestra

@Composable
fun Paso03OfficersScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Paso 3 - Lista de Oficiales",
            style = MaterialTheme.typography.titleMedium)
        HorizontalDivider()
        OfficersList(oficialesMuestra)
    }
}

@Composable
private fun OfficersList(oficiales: List<Oficial>) {
    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(oficiales) { oficial ->
            Card(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Text("Nombre: ${oficial.nombre}", style = MaterialTheme.typography.labelMedium)
                    Text("Placa: ${oficial.placa}", style = MaterialTheme.typography.bodySmall)
                    Text("Rango: ${oficial.rango}", style = MaterialTheme.typography.bodySmall)
                    Text("Estado: ${if (oficial.activo) "Activo" else "Inactivo"}", 
                        style = MaterialTheme.typography.bodySmall)
                }
            }
        }
    }
}
