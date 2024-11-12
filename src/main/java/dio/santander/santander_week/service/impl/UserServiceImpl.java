package dio.santander.santander_week.service.impl;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dio.santander.santander_week.model.User;
import dio.santander.santander_week.repository.UserRepository;
import dio.santander.santander_week.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User findbyId(Long id) {
        Optional<User> usuario = userRepository.findById(id);

        // usuario.orElseGet(() -> {
        // return null;
        // });

        usuario.orElseThrow(NoSuchElementException::new);

        return usuario.get();
    }

    @Override
    public User create(User user) {

        /*
         * if (user.getId() != null && userRepository.existsById(user.getId())) {
         * throw new IllegalArgumentException("Usuario ja existe");
         * }
         */

        if (userRepository.existsByAccountNumber(user.getAccount().getNumber())) {
            throw new IllegalArgumentException("Number is exist");
        }

        return userRepository.save(user);
    }

    @Override
    public Iterable<User> buscarTodos() {
        return userRepository.findAll();
    }

}
