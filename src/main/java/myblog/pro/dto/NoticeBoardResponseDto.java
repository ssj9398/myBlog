package myblog.pro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import myblog.pro.domain.Comment;
import myblog.pro.domain.NoticeBoard;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoticeBoardResponseDto {

    private Long id;

    private String title;

    private String writer;

    private String content;

    private LocalDateTime boardDate;

    private List<CommentResponseDto> comment;

    public NoticeBoardResponseDto(NoticeBoard noticeBoards) {
        this.id = noticeBoards.getId();
        this.writer= noticeBoards.getWriter();
        this.title=noticeBoards.getTitle();
        this.content=noticeBoards.getContent();
        this.boardDate = noticeBoards.getBoardDate();
        this.comment = noticeBoards.getComments().stream()
                .map(CommentResponseDto::new)
                .collect(Collectors.toList());
    }
}