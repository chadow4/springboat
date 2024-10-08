package com.julien.springboat.controller;

import com.julien.springboat.DTO.ArticleDTOWithAuthor;
import com.julien.springboat.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getArticleById(@PathVariable Long id) {
        Optional<ArticleDTOWithAuthor> articleDTO = articleService.getArticleById(id);
        return articleDTO.isPresent()
                ? new ResponseEntity<>(articleDTO.get(), HttpStatus.OK)
                : new ResponseEntity<>("Article not found", HttpStatus.NOT_FOUND);
    }
}