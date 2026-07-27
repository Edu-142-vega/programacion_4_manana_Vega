// lib/main_mp.dart
import 'package:flutter/material.dart';
import 'package:modulo09_formularios_mp/models/servidor_ssh_mp.dart';
import 'package:modulo09_formularios_mp/screens/pantalla_busqueda_mp.dart';
import 'package:modulo09_formularios_mp/screens/pantalla_buses_mp.dart';
import 'package:modulo09_formularios_mp/widgets/fila_servidor_mp.dart';
import 'package:modulo09_formularios_mp/widgets/formulario_servidor_mp.dart';

const int paso = 5;

void main() => runApp(MaterialApp(
  debugShowCheckedModeBanner: false,
  theme: ThemeData(
    colorScheme: ColorScheme.fromSeed(
      seedColor: const Color(0xFF0D47A1),
    ),
    useMaterial3: true,
  ),
  home: switch (paso) {
    1 => const _Paso1(),
    2 => const _Paso2(),
    3 => const _Paso3(),
    4 => const PantallaBuses(),
    5 => const PantallaBusqueda(),
    _ => Scaffold(
        body: Center(child: Text('Paso $paso'))),
  },
));

class _Paso1 extends StatefulWidget {
  const _Paso1();
  @override
  State<_Paso1> createState() => _Paso1State();
}

class _Paso1State extends State<_Paso1> {
  final _ctrlNumero = TextEditingController();
  final _ctrlTitulo = TextEditingController();
  final _ctrlOficial = TextEditingController();
  final _focusTitulo = FocusNode();
  final _focusOficial = FocusNode();

  @override
  void dispose() {
    _ctrlNumero.dispose();
    _ctrlTitulo.dispose();
    _ctrlOficial.dispose();
    _focusTitulo.dispose();
    _focusOficial.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    final cs = Theme.of(context).colorScheme;
    return Scaffold(
      appBar: AppBar(
        title: const Text('Registro Rápido de Expediente'),
        backgroundColor: cs.primaryContainer,
        foregroundColor: cs.onPrimaryContainer,
      ),
      body: SingleChildScrollView(
        padding: const EdgeInsets.all(16),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: [
            TextField(
              controller: _ctrlNumero,
              decoration: const InputDecoration(
                labelText: 'Número de Expediente',
                hintText: 'EXP-2026-0042',
                prefixIcon: Icon(Icons.folder),
                border: OutlineInputBorder(),
              ),
              textInputAction: TextInputAction.next,
              onSubmitted: (_) => _focusTitulo.requestFocus(),
            ),
            const SizedBox(height: 12),
            TextField(
              controller: _ctrlTitulo,
              focusNode: _focusTitulo,
              decoration: const InputDecoration(
                labelText: 'Título del Caso',
                hintText: 'Robo en Zona Comercial',
                prefixIcon: Icon(Icons.gavel),
                border: OutlineInputBorder(),
              ),
              textInputAction: TextInputAction.next,
              onSubmitted: (_) => _focusOficial.requestFocus(),
            ),
            const SizedBox(height: 12),
            TextField(
              controller: _ctrlOficial,
              focusNode: _focusOficial,
              decoration: const InputDecoration(
                labelText: 'Oficial Asignado',
                prefixIcon: Icon(Icons.person_pin),
                border: OutlineInputBorder(),
              ),
              textInputAction: TextInputAction.done,
              onSubmitted: (_) => FocusScope.of(context).unfocus(),
            ),
            const SizedBox(height: 20),
            FilledButton.icon(
              onPressed: () {
                FocusScope.of(context).unfocus();
                ScaffoldMessenger.of(context).showSnackBar(
                  SnackBar(
                    content: Text(
                      'Registrando expediente ${_ctrlNumero.text}: ${_ctrlTitulo.text}',
                    ),
                    behavior: SnackBarBehavior.floating,
                  ),
                );
              },
              icon: const Icon(Icons.save),
              label: const Text('Guardar Expediente'),
            ),
          ],
        ),
      ),
    );
  }
}

class _Paso2 extends StatelessWidget {
  const _Paso2();

  @override
  Widget build(BuildContext context) {
    final cs = Theme.of(context).colorScheme;
    return Scaffold(
      appBar: AppBar(
        title: const Text('Formulario Completo de Expediente'),
        backgroundColor: cs.primaryContainer,
        foregroundColor: cs.onPrimaryContainer,
      ),
      body: SingleChildScrollView(
        padding: const EdgeInsets.all(16),
        child: FormularioBus(
          onGuardar: (datos) {
            ScaffoldMessenger.of(context).showSnackBar(
              SnackBar(
                content: Text(
                    'Expediente registrado: ${datos['nombre']} (${datos['ip']})'),
                behavior: SnackBarBehavior.floating,
              ),
            );
          },
        ),
      ),
    );
  }
}

class _Paso3 extends StatefulWidget {
  const _Paso3();
  @override
  State<_Paso3> createState() => _Paso3State();
}

class _Paso3State extends State<_Paso3> {
  final List<dynamic> _buses = [
    BusSSH(id:'1', nombre:'EXP-2026-0042', ruta:'Robo Comercial', capacidad:1, conductor:'Det. Carlos Mendoza', modelo:'Homicidios', clima:true, favorito:true),
    BusSSH(id:'2', nombre:'EXP-2026-0043', ruta:'Fraude Bancario', capacidad:2, conductor:'Insp. Ana Torres', modelo:'Delitos Financieros', clima:true),
  ];

  @override
  Widget build(BuildContext context) {
    final cs = Theme.of(context).colorScheme;

    return Scaffold(
      appBar: AppBar(
        title: Text('Expedientes Activos (${_buses.length})'),
        backgroundColor: cs.primaryContainer,
        foregroundColor: cs.onPrimaryContainer,
      ),
      body: ListView.separated(
        itemCount: _buses.length,
        separatorBuilder: (_, __) => const Divider(height: 1, indent: 72),
        itemBuilder: (ctx, i) {
          final item = _buses[i];
          return FilaBus(
            bus: item,
            onFavorito: () => setState(() => item.favorito = !item.favorito),
            onEliminar: () => setState(() => _buses.removeAt(i)),
          );
        },
      ),
    );
  }
}

