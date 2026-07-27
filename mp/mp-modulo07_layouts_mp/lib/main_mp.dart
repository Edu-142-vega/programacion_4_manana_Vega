// lib/main_mp.dart
import 'package:flutter/material.dart';
import 'package:modulo07_layouts_mp/widgets/avatar_badge_mp.dart';
import 'package:modulo07_layouts_mp/widgets/tarjeta_log_mp.dart';

const int paso = 2;

void main() => runApp(MaterialApp(
  debugShowCheckedModeBanner: false,
  home: switch (paso) {
    1 => _paso1(),
    2 => Scaffold(
      appBar: AppBar(title: const Text('Logs de Expedientes Policiales')),
      body: ListView(
        children: [
          TarjetaLog(nivel: 'ERROR', componente: 'expediente-core',
              mensaje: 'Intento de acceso no autorizado a EXP-2026-0099',
              timestamp: DateTime.now()),
          TarjetaLog(nivel: 'WARN', componente: 'evidencia-vault',
              mensaje: 'Evidencia #E-442 pendiente de firma del fiscal',
              timestamp: DateTime.now().subtract(const Duration(minutes: 10))),
          TarjetaLog(nivel: 'INFO', componente: 'oficiales-dispatch',
              mensaje: 'Oficial Det. Carlos Mendoza asignado a EXP-2026-0042',
              timestamp: DateTime.now().subtract(const Duration(minutes: 30))),
          TarjetaLog(nivel: 'DEBUG', componente: 'audit-log',
              mensaje: 'Actualización de estado: En Investigación -> Remitido',
              timestamp: DateTime.now().subtract(const Duration(hours: 1))),
        ],
      ),
    ),
    4 => const Scaffold(
      body: Center(
        child: Row(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            AvatarBadge(nombre: 'Det. Mendoza', alertas: 3, activo: true),
            SizedBox(width: 24),
            AvatarBadge(nombre: 'Insp. Rivas', alertas: 0, activo: true),
            SizedBox(width: 24),
            AvatarBadge(nombre: 'Agte. Torres', alertas: 1, activo: false),
          ],
        ),
      ),
    ),
    _ => Scaffold(body: Center(child: Text('Paso $paso'))),
  },
));

Widget _paso1() => Scaffold(
  body: Center(
    child: Container(
      width: double.infinity,
      height: 80,
      margin: const EdgeInsets.all(24),
      padding: const EdgeInsets.symmetric(horizontal: 16, vertical: 12),
      decoration: BoxDecoration(
        color: Colors.indigo.shade50,
        borderRadius: BorderRadius.circular(8),
        border: const Border(left: BorderSide(color: Colors.indigo, width: 4)),
        boxShadow: [
          BoxShadow(
            color: Colors.black.withOpacity(0.2),
            blurRadius: 8,
            offset: const Offset(0, 2),
          ),
        ],
      ),
      child: const Text(
        'Expediente Policial #EXP-2026-0042',
        style: TextStyle(fontWeight: FontWeight.bold, fontSize: 16),
      ),
    ),
  ),
);