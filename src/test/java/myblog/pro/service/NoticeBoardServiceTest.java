package myblog.pro.service;

import myblog.pro.domain.NoticeBoard;
import myblog.pro.repository.NoticeBoardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional(readOnly = true)
class NoticeBoardServiceTest {

    @Autowired
    private NoticeBoardRepository noticeBoardRepository;

    @Test
    void addPost() {
        //given
        NoticeBoard noticeBoard = NoticeBoard.builder()
                .writer("저자")
                .content("내용")
                .title("제목")
                .boardDate(LocalDateTime.now())
                .build();
        NoticeBoard saveBoard = noticeBoardRepository.save(noticeBoard);

        //when
        Optional<NoticeBoard> boardId = noticeBoardRepository.findById(saveBoard.getId());

        //then
        assertThat(noticeBoard).isEqualTo(boardId.get());
    }

    @Test
    void findPostAll() {
        //given
        NoticeBoard noticeBoard = NoticeBoard.builder()
                .writer("저자")
                .content("내용")
                .title("제목")
                .boardDate(LocalDateTime.now())
                .build();
        noticeBoardRepository.save(noticeBoard);
        //when
        List<NoticeBoard> allByOrderByBoardDateDesc = noticeBoardRepository.findAllByOrderByBoardDateDesc();
        //then
        assertThat(allByOrderByBoardDateDesc.size()).isEqualTo(5);
    }

    @Test
    void findPostOne(){
        //given
        NoticeBoard noticeBoard = NoticeBoard.builder()
                .writer("저자")
                .content("내용")
                .title("제목")
                .boardDate(LocalDateTime.now())
                .build();
        NoticeBoard saveBoard = noticeBoardRepository.save(noticeBoard);
        //when
        Optional<NoticeBoard> findBoard = noticeBoardRepository.findById(saveBoard.getId());
        //then
        assertThat(findBoard.get().getId()).isSameAs(saveBoard.getId());
    }
}