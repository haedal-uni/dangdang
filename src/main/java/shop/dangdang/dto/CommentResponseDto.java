package shop.dangdang.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import shop.dangdang.domain.Comment;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CommentResponseDto {
    private Long feedIdx;
    private List<Comment> comments;
}
