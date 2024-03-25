package com.junioroffers.domain.loginandregister;

import com.junioroffers.domain.loginandregister.dto.RegisterUserDto;
import com.junioroffers.domain.loginandregister.dto.RegistrationResultDto;
import com.junioroffers.domain.loginandregister.dto.UserDto;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InMemoryLoginRepositoryTest {
   LoginAndRegisterFacade loginFacade = new LoginAndRegisterFacade(
           new InMemoryLoginRepository()
   );
    @Test
    public void should_find_user_by_user_name() {
        //given
        RegisterUserDto registerUserDto = new RegisterUserDto("Tomek", "Kowalski");
        RegistrationResultDto register = loginFacade.register(registerUserDto);
        //when
        UserDto userByName = loginFacade.findByUserName(register.username());
        //then
        assertThat(userByName).isEqualTo(new UserDto(register.id(), "Tomek", "Kowalski"));
    }

    @Test
    public void should_throw_exception_when_user_not_found() {
        //given

        //when

        //then
    }

    @Test
    public void should_register_user() {
        //given

        //when

        //then
    }
}