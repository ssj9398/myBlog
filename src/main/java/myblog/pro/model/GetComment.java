package myblog.pro.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import myblog.pro.dto.CommentResponseDto;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetComment {

    private boolean success;

    private String msg;

    private  Long comment_id;

    private String contents;

    private LocalDateTime commentDate;

    public GetComment(boolean success, String msg, CommentResponseDto commentResponseDto){
        this.success = success;
        this.msg = msg;
        this.comment_id = commentResponseDto.getId();
        this.contents = commentResponseDto.getContents();
        this.commentDate = commentResponseDto.getCommentDate();
    }

}
