import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';
import '../models/servidor_ssh.dart';

class PantallaServidoresFiltro extends StatelessWidget {
  final bool soloSSL;

  const PantallaServidoresFiltro({super.key, this.soloSSL = false});

  @override
  Widget build(BuildContext context) {
    final servidores = soloSSL
        ? servidoresSimulados.where((s) => s.ssl).toList()
        : servidoresSimulados;

    return Scaffold(
      appBar: AppBar(
        title: const Text('Servidores filtrados'),
      ),
      body: ListView.builder(
        itemCount: servidores.length,
        itemBuilder: (context, index) {
          final servidor = servidores[index];
          return ListTile(
            leading: const Icon(Icons.dns),
            title: Text(servidor.nombre),
            subtitle: Text(servidor.ip),
            onTap: () => context.push('/servidores/${servidor.id}', extra: servidor),
          );
        },
      ),
    );
  }
}