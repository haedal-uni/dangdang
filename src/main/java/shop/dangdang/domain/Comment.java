package shop.dangdang.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Comment {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name="CommentId")
    private Long idx;

    @ManyToOne
    @JoinColumn(name="MembershipId")
    @JsonManagedReference
    Membership membership;    // 댓글 사용자

    @ManyToOne
    @JoinColumn(name = "feed")
    @JsonManagedReference
    Feed feed;                 // 댓글 사용자

    @Column(nullable = false)
    String content;             // 댓글 내용

    @CreatedDate
    LocalDateTime createDate;

    public Comment(Membership membership, String content, Feed feed){
        this.membership = membership;
        this.content = content;
        writeComment(feed);
    }

    private void writeComment(Feed feed) {
        this.feed = feed;
        feed.getComments().add(this);
    }
}