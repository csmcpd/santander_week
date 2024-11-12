package dio.santander.santander_week.service;

import dio.santander.santander_week.model.User;

public interface UserService {

    Iterable<User> buscarTodos();

    User findbyId(Long id);

    User create(User user);
}
