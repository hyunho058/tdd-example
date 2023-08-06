package com.example.tddexample.treason;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UserRegisterTest {
    private UserRegister userRegister;
    private StubWeakPasswordChecker weakPasswordChecker = new StubWeakPasswordChecker();
    private MemoryUserRepository fakeRepository = new MemoryUserRepository();
    private final SpyEmailNotifier emailNotifier = new SpyEmailNotifier();

    @BeforeEach
    void setUp() {
        userRegister = new UserRegister(weakPasswordChecker, fakeRepository ,emailNotifier);
    }

    @DisplayName("약한 암호면 가입 실패")
    @Test
    void weakPassword() {
        //given //when
        weakPasswordChecker.setWeak(true);
        //then
        assertThrows(
                IllegalArgumentException.class,
                () -> userRegister.register("id", "pw", "email")
        );
    }

    @DisplayName("이미 같은 ID가 존재하면 가입 실패")
    @Test
    void dupIdExist() {
        //이미 같은 ID 존재하는 상황 만들기
        User newUser = new User("id", "pw1", "email@email.com");
        fakeRepository.save(newUser);

        assertThrows(IllegalArgumentException.class, () -> {
            userRegister.register("id", "pw2", "email");
        });
    }

    @DisplayName("같은 ID가 없으면 가입 성공함")
    @Test
    void noDupId_RegisterSuccess() {
        userRegister.register("id", "pw", "email");
        User savedUser = fakeRepository.findById("id");

        assertThat(savedUser.getEmail()).isEqualTo("email");
    }

    @DisplayName("가입하면 메일을 전송함")
    @Test
    void whenRegisterThenSendMail() {
        //given
        userRegister.register("id", "pw", "email");
        //when

        //then
        assertThat(emailNotifier.isCalled()).isTrue();
        assertThat(emailNotifier.getEmail()).isEqualTo("email");
    }
}
