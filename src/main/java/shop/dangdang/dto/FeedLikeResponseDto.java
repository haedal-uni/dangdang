package shop.dangdang.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FeedLikeResponseDto {
    private Long feedIdx;
    private Boolean like;
}
