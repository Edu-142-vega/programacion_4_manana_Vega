import 'package:flutter/material.dart';

class CatalogoBasicos extends StatelessWidget {
  const CatalogoBasicos({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Widgets Básicos - Expedientes Policiales')),
      body: ListView(
        padding: const EdgeInsets.all(16),
        children: [
          // ── Text básico ───────────────────────────────────────────────────────
          const Text(
            'EXP-2026-0042: En Investigación',
            style: TextStyle(
              fontSize: 20,
              fontWeight: FontWeight.bold,
              color: Colors.blueAccent,
              letterSpacing: 0.5,
              shadows: [Shadow(color: Colors.black26, blurRadius: 4, offset: Offset(2, 2))]
            ),
          ),
          const SizedBox(height: 8),

          // ── Alineación y desbordamiento ───────────────────────────────────────
          const SizedBox(
            width: double.infinity,
            child: Text(
              'Lugar del Incidente: Av. Central #450, Distrito Metropolitano',
              textAlign: TextAlign.justify,
              maxLines: 2,
              overflow: TextOverflow.fade,
              softWrap: false,
            ),
          ),
          const SizedBox(height: 8),

          // ── Text.rich ────────────────────────────────────────────────────────
          const Text.rich(
            TextSpan(
              children: [
                TextSpan(
                  text: 'Prioridad: ',
                  style: TextStyle(fontWeight: FontWeight.w600),
                ),
                TextSpan(
                  text: 'ALTA / CRÍTICA',
                  style: TextStyle(
                    color: Colors.red,
                    fontWeight: FontWeight.bold,
                  ),
                ),
                TextSpan(
                  text: ' — Asignado a Det. Carlos Mendoza',
                  style: TextStyle(color: Colors.grey, fontSize: 12),
                ),
              ],
            ),
          ),
          const SizedBox(height: 8),

          // ── SelectableText ───────────────────────────────────────────────────
          const SelectableText(
            'Código Único de Evidencia: EVID-99482-2026',
            style: TextStyle(fontFamily: 'monospace', fontSize: 14),
          ),
          const Divider(height: 32),

          // ── Iconos ───────────────────────────────────────────────────────────
          Row(
            mainAxisAlignment: MainAxisAlignment.spaceEvenly,
            children: [
              Icon(Icons.verified_user, size: 40, color: Theme.of(context).colorScheme.primary),
              const Icon(Icons.warning, size: 40, color: Colors.amber),
              const Icon(Icons.local_police, size: 40, color: Colors.indigo),
              const Icon(Icons.folder_special, size: 40, color: Colors.blueGrey),
            ],
          ),
          const SizedBox(height: 8),
          const Icon(
            Icons.security,
            size: 24,
            color: Colors.blueGrey,
            semanticLabel: 'Sistema de Seguridad Policial',
          ),
          const Divider(height: 32),

          // ── Botones ─────────────────────────────────────────────────────────
          Wrap(
            spacing: 8,
            runSpacing: 8,
            children: [
              ElevatedButton(
                onPressed: () {},
                child: const Text('Abrir Expediente'),
              ),
              FilledButton(onPressed: () {}, child: const Text('Asignar Oficial')),
              OutlinedButton(onPressed: () {}, child: const Text('Adjuntar Evidencia')),
              TextButton(onPressed: () {}, child: const Text('Ver Historial')),
            ],
          ),
          const SizedBox(height: 12),

          // ── Variantes .icon ───────────────────────────────────────────────────
          Wrap(
            spacing: 8,
            runSpacing: 8,
            children: [
              ElevatedButton.icon(
                onPressed: () {},
                icon: const Icon(Icons.refresh, size: 18),
                label: const Text('Actualizar Estado'),
              ),
              FilledButton.icon(
                onPressed: () {},
                icon: const Icon(Icons.lock, size: 18),
                label: const Text('Cerrar Caso'),
              ),
              IconButton(
                onPressed: () {},
                icon: const Icon(Icons.print),
                color: Colors.indigo,
                iconSize: 28,
                tooltip: 'Imprimir Reporte Policial'
              ),
            ],
          ),
          const SizedBox(height: 12),

          ElevatedButton(
            onPressed: () {},
            style: ElevatedButton.styleFrom(
              backgroundColor: Colors.red.shade700,
              foregroundColor: Colors.white,
              padding: const EdgeInsets.symmetric(horizontal: 32, vertical: 14),
              shape: const StadiumBorder(),
            ),
            child: const Text(
              'Emitir Alerta de Captura',
              style: TextStyle(fontWeight: FontWeight.bold),
            ),
          ),
          const Divider(height: 32),

          // ── Tarjetas de Ejemplo ──────────────────────────────────────────────
          Card(
            elevation: 0,
            margin: const EdgeInsets.only(bottom: 8),
            shape: RoundedRectangleBorder(
              borderRadius: BorderRadius.circular(12),
            ),
            color: Colors.blue.shade50,
            child: ListTile(
              contentPadding: const EdgeInsets.symmetric(horizontal: 20, vertical: 12),
              leading: const Icon(Icons.folder_open, color: Colors.indigo, size: 36),
              title: const Text('EXP-2026-0042 — Robo a Mano Armada'),
              subtitle: const Text('Investigación en curso. Se analizan videos de seguridad del establecimiento comercial.'),
              trailing: const Icon(Icons.circle, color: Colors.red, size: 12),
              isThreeLine: true,
              onTap: () {},
            ),
          ),
          Card(
            elevation: 4,
            child: ListTile(
              leading: CircleAvatar(
                backgroundColor: Colors.indigo.shade100,
                child: const Icon(Icons.person, color: Colors.indigo, size: 20),
              ),
              title: const Text('Oficial Responsable: Det. Carlos Mendoza'),
              subtitle: const Text('Placa #88421 · Unidad de Delitos Financieros'),
              trailing: TextButton(onPressed: () {}, child: const Text('Perfil')),
            ),
          ),
          const Divider(height: 32),

          // ── Chips ───────────────────────────────────────────────────────────
          Wrap(
            spacing: 8,
            runSpacing: 8,
            children: [
              const Chip(label: Text('Homicidio')),
              const Chip(label: Text('Robo')),
              const Chip(label: Text('Fraude')),
              const Chip(
                avatar: Icon(Icons.check, size: 16, color: Colors.white),
                label: Text('Evidencia Custodiada'),
                backgroundColor: Colors.blue,
                labelStyle: TextStyle(color: Colors.white, fontSize: 12),
              ),
              FilterChip(
                label: const Text('Solo Pendientes'),
                selected: true,
                onSelected: (_) {},
              ),
            ],
          ),
          const Divider(height: 32),

          // ── Progress Indicators ─────────────────────────────────────────────
          Row(
            mainAxisAlignment: MainAxisAlignment.spaceEvenly,
            children: [
              const SizedBox(width: 48, height: 48, child: CircularProgressIndicator()),
              SizedBox(
                width: 48,
                height: 48,
                child: CircularProgressIndicator(
                  value: 0.75,
                  color: Colors.green,
                  strokeWidth: 6,
                  backgroundColor: Colors.grey.shade200,
                ),
              ),
            ],
          ),
          const SizedBox(height: 16),
          const LinearProgressIndicator(value: 0.6, color: Colors.indigo),
          const Divider(height: 32),
        ],
      ),
    );
  }
}