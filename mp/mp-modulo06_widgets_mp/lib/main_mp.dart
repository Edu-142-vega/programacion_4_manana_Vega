import 'package:flutter/material.dart';
import 'package:modulo06_widgets_mp/widgets/catalogo_basicos_mp.dart';
import 'package:modulo06_widgets_mp/widgets/contador_limitado_mp.dart';
import 'package:modulo06_widgets_mp/widgets/etiqueta_mp.dart';
import 'package:modulo06_widgets_mp/widgets/pantalla_contexto_mp.dart';
import 'package:modulo06_widgets_mp/widgets/reloj_mp.dart';
import 'package:modulo06_widgets_mp/widgets/servicio_estado_mp.dart';

const int paso = 2;

void main() => runApp(MaterialApp(
  debugShowCheckedModeBanner: false,
  theme: ThemeData(
    colorScheme: ColorScheme.fromSeed(
      seedColor: Colors.indigo,
      brightness: Brightness.dark,
    ),
    useMaterial3: true,
  ),
  home: switch (paso) {
    1 => const Scaffold(body: Center(child: SaludoPolicial())),
    2 => const CatalogoBasicos(),
    3 => const Scaffold(
      body: Center(
        child: Wrap(
          spacing: 12,
          runSpacing: 8,
          children: [
            Etiqueta(texto: 'En Investigación', color: Colors.blue),
            Etiqueta(texto: 'Prioridad Alta', color: Colors.red, relleno: true),
            Etiqueta(texto: 'En Espera de Fiscal', color: Colors.orange),
            Etiqueta(texto: 'Cerrado', color: Colors.green, relleno: true),
          ],
        ),
      ),
    ),
    4 => const Scaffold(
      body: Center(
        child: ServicioEstado(nombre: 'EXP-2026-0042'),
      ),
    ),
    5 => Scaffold(
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            ContadorLimitado(
              etiqueta: 'Intento de Acceso a Registro Confidencial',
              limite: 3,
              color: Colors.indigo,
              textoBoton: 'Verificar credencial',
              onLimite: () => debugPrint('¡Acceso bloqueado por seguridad!'),
            ),
          ],
        ),
      ),
    ),
    6 => Scaffold(
      appBar: AppBar(title: const Text('Tiempo Transcurrido del Incidente')),
      body: const Center(child: Reloj()),
    ),
    7 => const PantallaContexto(),
    _ => Scaffold(body: Center(child: Text('Paso $paso'))),
  },
));

class SaludoPolicial extends StatelessWidget {
  const SaludoPolicial({super.key});

  @override
  Widget build(BuildContext context) {
    return const SelectableText(
      'Sistema de Gestión de Expedientes Policiales activo. Registro digital de incidentes y evidencias asignado a la central operativa.',
      style: TextStyle(
        fontSize: 24,
        fontWeight: FontWeight.bold,
        color: Colors.indigoAccent,
      ),
      textAlign: TextAlign.center,
    );
  }
}