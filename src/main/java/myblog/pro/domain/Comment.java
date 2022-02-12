package myblog.pro.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment {

    @Id @GeneratedValue
    @Column(name = "comment_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private NoticeBoard board;

    @NotBlank
    @Column(columnDefinition = "TEXT")
    private String contents;

    private LocalDateTime commentDate;

    @Builder
    public Comment(String contents, LocalDateTime commentDate){
        this.contents = contents;
        this.commentDate = commentDate;
    }

    public void setPost(NoticeBoard noticeBoard){
        this.board = noticeBoard;
    }
}
