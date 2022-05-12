package bstorm.akimts.demouserdetails.models.dto;

import bstorm.akimts.demouserdetails.models.entity.User;
import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import java.util.Collection;
import java.util.List;

@Data
@Builder
public class UserDTO implements UserDetails {

    private String username;
    private String password;

    private boolean active;

    private List<String> roles;

    public static UserDTO of(User entity){
        if ( entity == null)
            return null;

        return UserDTO.builder()
                .username(entity.getUsername())
                .password(entity.getPassword())
                .active(entity.isActive())
                .roles(entity.getRoles())
                .build();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
                .map( SimpleGrantedAuthority::new )
                .toList();
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.active;
    }
}
