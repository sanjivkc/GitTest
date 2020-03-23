package com.vihaans.core.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vihaans.core.dao.model.User;
import com.vihaans.core.dao.model.UserDetail;
import com.vihaans.core.dao.repo.UserRepository;

import java.util.Optional;

@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUserId(username);

        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + username));

        return user.map(UserDetail::new).get();
    }

}
