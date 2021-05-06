package com.ipsas.WebService.Services;

import com.ipsas.WebService.Models.User;
import com.ipsas.WebService.Models.UserPrinciple;
import com.ipsas.WebService.Repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {
    private UserRepository userRepository;

    public UserPrincipalDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User u = this.userRepository.findUsersByUsername(s);
        UserPrinciple UserPrinciple = new UserPrinciple(u);
        return UserPrinciple;
    }
}
