package com.julien.springboat.DTO;

import com.julien.springboat.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ArticleDTO {
    private Long id;
    private String title;
    private String content;

    public ArticleDTO(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;

    }

}