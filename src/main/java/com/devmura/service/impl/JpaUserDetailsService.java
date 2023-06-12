package com.devmura.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.devmura.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class JpaUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.devmura.entity.User o = repository
                .findByUsername(username);

        if (o == null) {
            throw new UsernameNotFoundException(String.format("User: %s doesn't exist in the system!", username));
        }
        com.devmura.entity.User user = o;

        List<GrantedAuthority> authorities = user.getUserRoles()
                .stream()
                .map(r -> new SimpleGrantedAuthority(r.getAuth().getName()))
                .collect(Collectors.toList());

        return new User(
                user.getUsername(),
                user.getPassword(),
                true,
                true,
                true,
                true,
                authorities);

    }

}
