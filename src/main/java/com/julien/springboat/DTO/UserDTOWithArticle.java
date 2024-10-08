package com.julien.springboat.DTO;


import com.julien.springboat.model.Article;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class UserDTOWithArticle {
    private Long id;
    private String name;
    private String email;
    private List<ArticleDTO> articles = new ArrayList<>();

    public UserDTOWithArticle(Long id, String name, String email, List<Article> articles) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.articles = articles.stream()
                .map(article -> new ArticleDTO(article.getId(), article.getTitle(), article.getContent()))
                .collect(Collectors.toList());

    }


}