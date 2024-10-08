package com.julien.springboat.DTO;

import com.julien.springboat.model.Commentaire;
import com.julien.springboat.model.User;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ArticleDTOWithAuthor {
    private Long id;
    private String title;
    private String content;
    private ArticleAuthorDto author;
    private List<ArticleCommentaireDTO> commentaires = new ArrayList<>();

    public ArticleDTOWithAuthor(Long id, String title, String content, User author, List<Commentaire> commentaires) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = new ArticleAuthorDto(author.getName(), author.getEmail());
        this.commentaires = commentaires.stream()
                .map(commentaire -> new ArticleCommentaireDTO(commentaire.getId(), commentaire.getContent(), commentaire.getAuthor()))
                .collect(java.util.stream.Collectors.toList());
    }

    @Data
    public static class ArticleAuthorDto {
        private String name;
        private String email;

        public ArticleAuthorDto(String name, String email) {
            this.name = name;
            this.email = email;
        }
    }

    @Data
    public static class ArticleCommentaireDTO {
        private Long id;
        private String content;
        private UserCommentaireDto author;

        public ArticleCommentaireDTO(Long id, String content, User author) {
            this.id = id;
            this.content = content;
            this.author = new UserCommentaireDto(author.getName(), author.getEmail());
        }

        @Data
        public static class UserCommentaireDto {
            private String name;
            private String email;

            public UserCommentaireDto(String name, String email) {
                this.name = name;
                this.email = email;
            }
        }
    }


}