package shop.dangdang.domain;

import shop.dangdang.dto.FeedRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Feed extends Timestamped {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long idx;                   // ID

    @ManyToOne
    private User NickName;              // 사용자 아이디

    @Column(nullable = false)
    private String createTime;          // 글 생성일자 또는 변경일자

    @Column(nullable = false)
    private String mainImagePath;       // 글 메인 이미지 파일명(ex-filename.png)

    @Column(nullable = false)
    private String content;             // 글 내용

    @Column(nullable = false)
    private String address;             // 글 or 사진을 올린 장소

    @Column(nullable = false)
    private String size;                // 강아지 크기

    @Column(nullable = false)
    private Long likeCount;             // 글 좋아요 개수


    // Feed 생성시 이용
    public Feed(FeedRequestDto feedDto){
        this.createTime = feedDto.getCreateTime();
        this.mainImagePath = feedDto.getMainImagePath();
        this.content = feedDto.getContent();
        this.address = feedDto.getAddress();
        this.size = feedDto.getSize();
        this.likeCount = feedDto.getLikeCount();
    }

}

