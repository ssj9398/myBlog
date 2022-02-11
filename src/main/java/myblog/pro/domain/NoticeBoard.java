package myblog.pro.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class NoticeBoard {

    @Id @GeneratedValue
    @Column(name = "board_id")
    private Long id;

    @NotBlank(message = "제목은 공백일수가 없어^^")
    private String title;

    @NotBlank(message = "저자는 공백일수가 없어^^")
    private String writer;

    @NotBlank(message = "내용은 공백일수가 없어^^")
    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime boardDate;

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    @Builder
    public NoticeBoard(String title, String writer, String content, LocalDateTime boardDate){
        this.title = title;
        this.writer = writer;
        this.content = content;
        this.boardDate = boardDate;
    }

}
