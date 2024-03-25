package com.junioroffers.domain.loginandregister;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryLoginRepository implements UserRepository{
    Map<String, User> users = new ConcurrentHashMap<>();


    @Override
    public Optional<User> findByUserName(String name) {
        return Optional.ofNullable(users.get(name));
    }

    @Override
    public User save(User entity) {
        UUID id = UUID.randomUUID();
        User user = new User(
                id.toString(),
                entity.username(),
                entity.password()
        );
        users.put(user.username(), user);
        return user;
    }
}
