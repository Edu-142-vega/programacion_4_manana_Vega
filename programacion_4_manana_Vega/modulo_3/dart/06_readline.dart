import 'dart:io';

void main(){
    print('Ingrese su nombre: ');
    String? nombre = stdin.readLineSync();
    print('Hola $nombre');

    print('Ingrese su numero entero: ');
    String? nombre = int.parse(stdin.readLineSync);
    print('Numero: $numero');


    print('Ingrese un decimal: ');
    String? nombre = double.parse(stdin.readLineSync);
    print('valor: $valor');


    
}
