// lib/main_mp.dart
import 'package:flutter/material.dart';
import 'package:modulo08_material3_mp/screens/catalogo_botones_mp.dart';
import 'package:modulo08_material3_mp/screens/pantalla_appbar_mp.dart';
import 'package:modulo08_material3_mp/screens/pantalla_dialogs_mp.dart';
import 'package:modulo08_material3_mp/screens/pantalla_navegacion_mp.dart';
import 'package:modulo08_material3_mp/screens/pantalla_tema_mp.dart';

const int paso = 5;

void main() => runApp(const AppExpedientes());

class AppExpedientes extends StatefulWidget {
  const AppExpedientes({super.key});
  @override
  State<AppExpedientes> createState() => _AppExpedientesState();
}

class _AppExpedientesState extends State<AppExpedientes> {
  ThemeMode _themeMode = ThemeMode.system;

  @override
  Widget build(BuildContext context) {
    const seedColor = Color(0xFF0D47A1);

    return MaterialApp(
      debugShowCheckedModeBanner: false,
      themeMode: _themeMode,
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(
            seedColor: seedColor, brightness: Brightness.light),
        useMaterial3: true,
      ),
      darkTheme: ThemeData(
        colorScheme: ColorScheme.fromSeed(
            seedColor: seedColor, brightness: Brightness.dark),
        useMaterial3: true,
      ),
      home: switch (paso) {
        1 => const _Paso1(),
        2 => PantallaTema(
          themeMode: _themeMode,
          onToggle: (mode) => setState(() => _themeMode = mode),
        ),
        3 => const PantallaAppBar(),
        4 => const CatalogoBotones(),
        5 => const PantallaNavegacion(),
        6 => const PantallaDialogs(),
        _ => Scaffold(
            body: Center(child: Text('Paso $paso'))),
      },
    );
  }
}

class _Paso1 extends StatelessWidget {
  const _Paso1();

  @override
  Widget build(BuildContext context) {
    final cs   = Theme.of(context).colorScheme;
    final text = Theme.of(context).textTheme;

    return Scaffold(
      appBar: AppBar(
        title: const Text('Gestión de Expedientes Policiales'),
        backgroundColor: cs.primaryContainer,
        foregroundColor: cs.onPrimaryContainer,
        actions: [
          IconButton(icon: const Icon(Icons.refresh), onPressed: () {}),
        ],
      ),
      body: Center(
        child: Column(
          mainAxisSize: MainAxisSize.min,
          children: [
            Icon(Icons.local_police, size: 64, color: cs.primary),
            const SizedBox(height: 16),
            Text(
              'Expediente #EXP-2026-0042',
              style: text.headlineMedium?.copyWith(fontWeight: FontWeight.bold),
            ),
            const SizedBox(height: 8),
            Text(
              'Fiscalía Central · Unidad de Investigación',
              style: text.bodyMedium?.copyWith(color: cs.onSurfaceVariant),
            ),
            const SizedBox(height: 24),
            FilledButton.icon(
              onPressed: () {},
              icon: const Icon(Icons.shield),
              label: const Text('Asignar Oficial'),
            ),
          ],
        ),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () {},
        child: const Icon(Icons.add_moderator),
      ),
    );
  }
}