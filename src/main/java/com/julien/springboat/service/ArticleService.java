package com.julien.springboat.service;


import com.julien.springboat.DTO.ArticleDTOWithAuthor;
import com.julien.springboat.model.Article;
import com.julien.springboat.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public Optional<ArticleDTOWithAuthor> getArticleById(Long id) {
        Optional<Article> article = articleRepository.findById(id);
        return article.map(value ->
                new ArticleDTOWithAuthor(value.getId(), value.getTitle(), value.getContent(),value.getAuthor(),value.getCommentaires()));
    }
}