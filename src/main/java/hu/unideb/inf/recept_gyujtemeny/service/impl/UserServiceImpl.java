package hu.unideb.inf.recept_gyujtemeny.service.impl;

import hu.unideb.inf.recept_gyujtemeny.data.repository.FelhasznaloRepository;
import hu.unideb.inf.recept_gyujtemeny.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    FelhasznaloRepository repo;
    @Override
    public UserDetailsService getUserDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return repo.findByFelhNev(username);
            }
        };
    }
}