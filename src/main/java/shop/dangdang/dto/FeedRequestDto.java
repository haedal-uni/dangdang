package shop.dangdang.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FeedRequestDto {
    private String createTime;     // 글 생성일자 또는 변경일자
    private String mainImagePath;  // 글 메인 이미지 파일명(ex-filename.png)
    private String content;        // 글 내용
    private String address;        // 글 or 사진을 올린 장소
    private String size;           // 강아지 크기
    private Long likeCount;        // 글 좋아요 개수
}

