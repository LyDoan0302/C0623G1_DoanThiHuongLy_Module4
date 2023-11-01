package com.codegym.service;

import com.codegym.model.MyUserDetail;
import com.codegym.model.User;
import com.codegym.reposiotry.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private IUserRepository iUserRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = iUserRepository.findByUserName(username);

        if(user == null) {
            throw new UsernameNotFoundException("User name :" + username + " not found.");
        }

        return new MyUserDetail(user);
    }
}
