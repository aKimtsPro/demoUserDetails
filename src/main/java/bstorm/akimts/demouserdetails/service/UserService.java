package bstorm.akimts.demouserdetails.service;

import bstorm.akimts.demouserdetails.models.dto.UserDTO;
import bstorm.akimts.demouserdetails.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUsername( username )
                .map( UserDTO::of )
                .orElseThrow( () -> new UsernameNotFoundException("L'utilisateur n'existe pas") );
    }

}
