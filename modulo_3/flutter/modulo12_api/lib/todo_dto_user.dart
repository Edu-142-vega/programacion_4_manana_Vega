class TodoDtoUser {
  final int id;
  final String name;
  final bool completed;

  const TodoDtoUser({
    required this.id,
    required this.name,
    required this.completed,
  });

  factory TodoDtoUser.fromJson(Map<String, dynamic> json) => TodoDtoUser(
    id:json['id']as int,
    name:json['name']as String,
    completed: json['completed'] as bool,
  );
}