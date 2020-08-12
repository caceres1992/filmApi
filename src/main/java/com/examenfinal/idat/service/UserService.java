package com.examenfinal.idat.service;

import com.examenfinal.idat.entity.User;
import com.examenfinal.idat.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User validate(String username, String password) {
        return userRepository.validate(username, password);
    }


}
