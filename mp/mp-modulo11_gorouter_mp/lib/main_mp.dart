// lib/main_mp.dart
import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:modulo11_gorouter_mp/providers/auth_provider_mp.dart';
import 'package:modulo11_gorouter_mp/router/app_router_paso4_mp.dart';
import 'package:modulo11_gorouter_mp/router/app_router_paso5_mp.dart';
import 'package:modulo11_gorouter_mp/router/approuterpaso2_mp.dart';
import 'package:modulo11_gorouter_mp/router/approuterpaso3_mp.dart';
import 'router/app_router_mp.dart';

const int paso = 5;

void main() {
  runApp(
    ProviderScope(
      child: AppExpedientesGoRouter(paso: paso),
    ),
  );
}

class AppExpedientesGoRouter extends ConsumerWidget {
  final int paso;
  const AppExpedientesGoRouter({super.key, required this.paso});

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    ref.watch(authProvider);

    final router = switch (paso) {
      1 => appRouter,
      2 => appRouterPaso2,
      3 => appRouterPaso3,
      4 => appRouterPaso4,
      5 => appRouterPaso5(ref),
      _ => appRouter,
    };

    return MaterialApp.router(
      title: 'Sistema de Gestión de Expedientes Policiales',
      debugShowCheckedModeBanner: false,
      routerConfig: router,
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: const Color(0xFF0D47A1)),
        useMaterial3: true,
      ),
    );
  }
}



