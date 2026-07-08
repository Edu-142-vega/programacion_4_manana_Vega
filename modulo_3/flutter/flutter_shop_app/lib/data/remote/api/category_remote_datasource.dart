// lib/data/remote/api/auth_remote_datasource.dart

import 'package:dio/dio.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import '../../../core/error/api_exception.dart';
import 'dio_client.dart';
import '../../local/secure_storage.dart';
import '../../../domain/model/auth_models.dart';

abstract class AuthRemoteDatasource {
  Future<LoggedUser> login(String username, String password);
  Future<LoggedUser> register(String username, String email, String password, String password2);
  Future<void>       logout();
  Future<void>       requestPasswordReset(String email);
  Future<void>       confirmPasswordReset({
    required String uid,
    required String token,
    required String newPassword,
    required String newPassword2,
  });
}

class AuthRemoteDatasourceImpl implements AuthRemoteDatasource {
  final Dio           _dio;
  final SecureStorage _storage;

  AuthRemoteDatasourceImpl(this._dio, this._storage);

  // ... login, register, logout sin cambios ...

  @override
  Future<void> requestPasswordReset(String email) async {
    try {
      await _dio.post(
        '/auth/password-reset/',
        data: {'email': email},
      );
    } on DioException catch (e) {
      throw ApiException.fromDioError(e);
    }
  }

  @override
  Future<void> confirmPasswordReset({
    required String uid,
    required String token,
    required String newPassword,
    required String newPassword2,
  }) async {
    try {
      await _dio.post(
        '/auth/password-reset/confirm/',
        data: {
          'uid':           uid,
          'token':         token,
          'new_password':  newPassword,
          'new_password2': newPassword2,
        },
      );
    } on DioException catch (e) {
      throw ApiException.fromDioError(e);
    }
  }
}

final authDatasourceProvider = Provider<AuthRemoteDatasource>((ref) {
  return AuthRemoteDatasourceImpl(
    ref.watch(dioProvider),
    ref.watch(secureStorageProvider),
  );
});

// En la clase abstracta:
abstract class UserRemoteDatasource {
  // ... métodos existentes ...
  Future<Map<String, dynamic>> sendNotification({
    required String subject,
    required String message,
    int? userId,
  });
}

// En la implementación:
@override
Future<Map<String, dynamic>> sendNotification({
  required String subject,
  required String message,
  int? userId,
}) async {
  try {
    final res = await _dio.post(
      '/emails/send/',
      data: {
        'subject': subject,
        'message': message,
        if (userId != null) 'user_id': userId,
      },
    );
    return res.data as Map<String, dynamic>;
  } on DioException catch (e) {
    throw ApiException.fromDioError(e);
  }
}
userId opcional: si es null, el campo user_id no se incluye en el JSON y el backend interpreta esto como envío masivo.
13.8 SendNotificationProvider
lib/presentation/providers/sendnotificationprovider.dart

dart
Copiar
// lib/presentation/providers/send_notification_provider.dart

import 'package:flutter_riverpod/flutter_riverpod.dart';
import '../../data/remote/api/user_remote_datasource.dart';

sealed class SendNotificationState {
  const SendNotificationState();
}

class SendNotificationIdle    extends SendNotificationState { const SendNotificationIdle(); }
class SendNotificationLoading extends SendNotificationState { const SendNotificationLoading(); }

class SendNotificationSuccess extends SendNotificationState {
  final String detail;
  final int    sent;
  final int    failed;
  const SendNotificationSuccess({
    required this.detail,
    required this.sent,
    required this.failed,
  });
}

class SendNotificationError extends SendNotificationState {
  final String message;
  const SendNotificationError(this.message);
}

class SendNotificationNotifier extends StateNotifier<SendNotificationState> {
  final UserRemoteDatasource _datasource;

  SendNotificationNotifier(this._datasource) : super(const SendNotificationIdle());

  Future<void> send({
    required String subject,
    required String message,
    int? userId,
  }) async {
    if (state is SendNotificationLoading) return;
    state = const SendNotificationLoading();
    try {
      final res = await _datasource.sendNotification(
        subject: subject,
        message: message,
        userId:  userId,
      );
      state = SendNotificationSuccess(
        detail: res['detail'] as String? ?? '',
        sent:   res['sent']   as int?    ?? 0,
        failed: res['failed'] as int?    ?? 0,
      );
    } catch (e) {
      state = SendNotificationError(
        e.toString().replaceAll('Exception: ', ''),
      );
    }
  }

  void reset() => state = const SendNotificationIdle();
}

final sendNotificationProvider = StateNotifierProvider.autoDispose<
    SendNotificationNotifier, SendNotificationState>((ref) {
  return SendNotificationNotifier(ref.watch(userDatasourceProvider));
});