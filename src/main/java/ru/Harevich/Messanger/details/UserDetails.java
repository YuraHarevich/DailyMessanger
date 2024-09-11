package ru.Harevich.Messanger.details;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import ru.Harevich.Messanger.entity.User;

import java.util.Collection;
import java.util.List;


public class UserDetails implements org.springframework.security.core.userdetails.UserDetails {
    private final User user;

    public UserDetails(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return "";
    }

    @Override
    public String getUsername() {
        return "";
    }
}
