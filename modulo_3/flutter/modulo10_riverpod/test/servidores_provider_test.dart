import 'package:flutter_test/flutter_test.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:modulo10_riverpod/models/servidor_ssh.dart';
import 'package:modulo10_riverpod/providers/servidores_provider.dart';

void main() {
  test('el provider inicializa con 3 servidores', () {
    final container = ProviderContainer();
    addTearDown(container.dispose);

    final servidores = container.read(servidoresProvider);

    expect(servidores, isA<List<ServidorSSH>>());
    expect(servidores.length, 3);
  });

  test('toggleFavorito actualiza el estado', () {
    final container = ProviderContainer();
    addTearDown(container.dispose);

    final notifier = container.read(servidoresProvider.notifier);
    notifier.toggleFavorito('1');

    final servidores = container.read(servidoresProvider);
    final servidor = servidores.firstWhere((s) => s.id == '1');

    expect(servidor.favorito, isTrue);
  });
}
