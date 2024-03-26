package com.junioroffers.domain.loginandregister;

import com.junioroffers.domain.loginandregister.dto.RegisterUserDto;
import com.junioroffers.domain.loginandregister.dto.RegistrationResultDto;
import com.junioroffers.domain.loginandregister.dto.UserDto;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertAll;

public class InMemoryLoginRepositoryTest {
    LoginAndRegisterFacade loginFacade = new LoginAndRegisterFacade(
            new InMemoryLoginRepository()
    );

    @Test
    public void should_find_user_by_user_name() {
        //given
        RegisterUserDto registerUserDto = new RegisterUserDto("Tom", "password");
        RegistrationResultDto register = loginFacade.register(registerUserDto);
        //when
        UserDto userByName = loginFacade.findByUserName(register.username());
        //then
        assertThat(userByName).isEqualTo(new UserDto(register.id(), "Tom", "password"));
    }

    @Test
    public void should_throw_exception_when_user_not_found() {
        //given
        String username = "Tom214";

        //when, then
        assertThrows(UserNameNotFoundException.class, () -> {
            loginFacade.findByUserName(username);
        });
    }

    @Test
    public void should_register_user() {
        //given
        RegisterUserDto registerUserDto = new RegisterUserDto("username", "password");
        //when
        RegistrationResultDto register = loginFacade.register(registerUserDto);
        //then
        assertAll(
                () -> assertThat(register.created()).isTrue(),
                () -> assertThat(register.username()).isEqualTo("username")
        );
    }
}