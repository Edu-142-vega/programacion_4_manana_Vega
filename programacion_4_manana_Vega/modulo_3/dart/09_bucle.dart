import 'dart:io';

void main() {
  stdout.write('¿Qué tabla de multiplicar deseas ver? ');
  String? entrada = stdin.readLineSync();
  int numero = int.tryParse(entrada ?? '') ?? 0;

  print('\n--- Tabla del $numero ---');
  for (int i = 1; i <= 10; i++) {
    int resultado = numero * i;
    print('$numero x $i = $resultado');
  }
}