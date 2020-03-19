package com.jazhnaneh.student.service;

import com.jazhnaneh.student.model.User;
import com.jazhnaneh.student.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository usersRepository;


    @Transactional
    public User registerUser(User users)  {

        return this.usersRepository.save(users);
    }

    public List<User> findAllUsers() {

        return usersRepository.findAll();
    }


    public User findByUserName(String userName) {

        return usersRepository.findByUserName(userName);
    }


}
