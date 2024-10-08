package com.julien.springboat.DTO;

import com.julien.springboat.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommentaireDTO {
    private Long id;
    private String content;
    private UserCommentaireDto author;

    public CommentaireDTO(Long id, String content, User author) {
        this.id = id;
        this.content = content;
        this.author = new UserCommentaireDto(author.getName(), author.getEmail());
    }

    @Data
    @NoArgsConstructor
    public static class UserCommentaireDto {
        private String name;
        private String email;

        public UserCommentaireDto(String name, String email) {
            this.name = name;
            this.email = email;
        }
    }
}
