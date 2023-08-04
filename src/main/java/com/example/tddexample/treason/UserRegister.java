package com.example.tddexample.treason;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class UserRegister {
    private final WeakPasswordChecker weakPasswordChecker;
    private final UserRepository userRepository;
    private final EmailNotifier emailNotifier;

    public void register(String id, String pw, String email) {
        if (weakPasswordChecker.checkPasswordWeak(pw)){
            throw new IllegalArgumentException();
        }

        User user = userRepository.findById(id);
        if (user != null) {
            throw new IllegalArgumentException("이미 존재하는 ID");
        }

        userRepository.save(new User(id, pw, email));

        emailNotifier.sendRegisterEmail(email);
    }
}
