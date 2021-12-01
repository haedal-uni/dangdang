package com.sparta.dangdang.dto;

import com.sparta.dangdang.domain.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CommentResponseDto {
    private Long feedIdx;
    private List<Comment> comments;
}
