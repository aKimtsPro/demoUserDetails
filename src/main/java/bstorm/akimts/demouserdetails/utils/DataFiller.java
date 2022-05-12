package bstorm.akimts.demouserdetails.utils;

import bstorm.akimts.demouserdetails.models.entity.User;
import bstorm.akimts.demouserdetails.repository.UserRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class DataFiller implements InitializingBean {

    private final UserRepository repository;
    private final PasswordEncoder encoder;

    public DataFiller(UserRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        User user = new User(
                0L,
                UUID.randomUUID(),
                "user",
                encoder.encode("pass"),
                true,
                List.of("USER")
        );

        repository.save(user);

    }
}
