// lib/models/servidor_ssh.dart
class ServidorSSH {
  final String id;
  final String nombre;
  final String ip;
  final int    puerto;
  final bool   ssdl;
  bool         favorito;

  ServidorSSH({
    required this.id,
    required this.nombre,
    required this.ip,
    required this.puerto,
    required this.ssdl,
    this.favorito = false,
  });
}