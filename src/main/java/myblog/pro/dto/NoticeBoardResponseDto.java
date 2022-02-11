package myblog.pro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import myblog.pro.domain.NoticeBoard;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoticeBoardResponseDto {

    private String title;

    private String writer;

    private String content;

    private LocalDateTime boardDate;

    public NoticeBoardResponseDto(NoticeBoard noticeBoards) {
        this.writer= noticeBoards.getWriter();
        this.title=noticeBoards.getTitle();
        this.content=noticeBoards.getContent();
        this.boardDate = noticeBoards.getBoardDate();
    }
}
