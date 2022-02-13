package myblog.pro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import myblog.pro.domain.Comment;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentResponseDto {

    private Long id;
    private String contents;

    private LocalDateTime commentDate;

    public CommentResponseDto(Comment comment) {
        this.id = comment.getId();
        this.commentDate = comment.getCommentDate();
        this.contents = comment.getContents();
    }
}
