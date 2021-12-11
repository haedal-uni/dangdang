package shop.dangdang.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import shop.dangdang.dto.RegistryDto;

import javax.persistence.*;
import java.lang.reflect.Member;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Feed {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long idx;

    @ManyToOne
    @JoinColumn(name = "writerIdx")
    private Membership writer;                // 글 작성자
    @CreatedDate
    private LocalDateTime createdDate;  // 글 생성일자
    @Column(nullable = true)
    private String mainImagePath;       // 글 메인 이미지 파일명(ex-filename.png)
    @Column(nullable = false)
    private String content;             // 글 내용
    @Column(nullable = false)
    private String address;             // 글 or 사진을 올린 장소
    @Column(nullable = false)
    private Long likeCount;             // 글 좋아요 개수

    @OneToMany(mappedBy = "feed")
    private final List<shop.dangdang.domain.FeedLikeUser> likeUsers = new ArrayList<>();

    @OneToMany(mappedBy = "feed")
    @JsonBackReference
    private final List<Comment> comments = new ArrayList<>();

    public Feed(Membership writer, String mainImagePath, String content, String address) {
        setWriter(writer);
        this.mainImagePath = mainImagePath;
        this.content = content;
        this.address = address;
        this.likeCount = 0L;
    }

    public Feed(RegistryDto registryDto, String image, Membership writer) {
        setWriter(writer);
        this.mainImagePath = image;
        this.content = registryDto.getContent();
        this.address = registryDto.getAddress();
        this.likeCount = 0L;
    }

    public void setWriter(Membership writer) {
        this.writer = writer;

        if(!writer.getWrittenFeeds().contains(this)) {
            writer.getWrittenFeeds().add(this);
        }
    }

    public void setLike(Boolean isLike) {
        if(isLike) {
            likeCount += 1;
        } else {
            likeCount -= 1;
        }
    }
}
