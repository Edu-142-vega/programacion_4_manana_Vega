import 'package:flutter/material.dart';
import 'screens/pantalla_topologia.dart';
// Desde lib/main.dart → lib/widgets/
import 'widgets/tarjeta_log.dart';
import 'widgets/fila_estado.dart';
import 'widgets/avatar_badge.dart';

// Desde lib/widgets/ → lib/models/
import '../models/dispositivo.dart';

// Desde lib/widgets/ → lib/widgets/
import 'avatar_badge.dart';

// Desde lib/screens/ → lib/widgets/
import '../widgets/chip_resumen.dart';
import '../widgets/fila_dispositivo.dart';

// Desde lib/screens/ → lib/models/
import '../models/dispositivo.dart';

void main() => runApp(const AppTopologia());

class AppTopologia extends StatelessWidget {
  const AppTopologia({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title:                      'Topología de Red',
      debugShowCheckedModeBanner: false,
      theme: ThemeData(
        colorScheme:  ColorScheme.fromSeed(seedColor: Colors.indigo),
        useMaterial3: true,
      ),
      home: const PantallaTopologia(),
    );
  }
}