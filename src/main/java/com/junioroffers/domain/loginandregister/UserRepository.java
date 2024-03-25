package com.junioroffers.domain.loginandregister;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findByUserName(String name);
    User save(User user);
}
