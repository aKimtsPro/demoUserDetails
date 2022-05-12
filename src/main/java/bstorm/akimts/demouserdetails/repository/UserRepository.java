package bstorm.akimts.demouserdetails.repository;

import bstorm.akimts.demouserdetails.models.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

}
