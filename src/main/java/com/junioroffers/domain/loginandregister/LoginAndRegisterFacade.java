package com.junioroffers.domain.loginandregister;

import com.junioroffers.domain.loginandregister.dto.RegisterUserDto;
import com.junioroffers.domain.loginandregister.dto.RegistrationResultDto;
import com.junioroffers.domain.loginandregister.dto.UserDto;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LoginAndRegisterFacade {
    private final UserRepository userRepository;
    private static final String USER_NOT_FOUND = "User not found";

    public RegistrationResultDto register(RegisterUserDto registerUserDto) {
        final User user = User.builder()
                .username(registerUserDto.username())
                .password(registerUserDto.password())
                .build();
        User savedUser = userRepository.save(user);
        return new RegistrationResultDto(savedUser.id(), true, savedUser.username());
    }

    public UserDto findByUserName(String username) {
        return userRepository.findByUserName(username)
                .map(user -> new UserDto(user.id(), user.username(), user.password()))
                .orElseThrow(() -> new UserNameNotFoundException(USER_NOT_FOUND));
    }
}
