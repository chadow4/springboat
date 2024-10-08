package com.julien.springboat.service;


import com.julien.springboat.DTO.UserDTOWithArticle;
import com.julien.springboat.model.Article;
import com.julien.springboat.model.User;
import com.julien.springboat.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDTOWithArticle getUserById(Long id) {
       Optional<User> user = userRepository.findById(id);
        return user.map(value -> new UserDTOWithArticle(value.getId(), value.getName(), value.getEmail(), value.getArticles())).orElse(null);

    }
}