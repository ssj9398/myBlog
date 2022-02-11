//package myblog.pro.service;
//
//import myblog.pro.domain.NoticeBoard;
//import myblog.pro.repository.NoticeBoardRepository;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.time.LocalDateTime;
//import java.util.Optional;
//
//@SpringBootTest
//@Transactional
//class NoticeBoardServiceTest {
//
//    @Autowired
//    private NoticeBoardRepository noticeBoardRepository;
//
//    @Test
//    void addPost() {
//        //given
//        NoticeBoard noticeBoard = NoticeBoard.builder()
//                .writer("저자")
//                .content("내용")
//                .title("제목")
//                .boardDate(LocalDateTime.now())
//                .build();
//        NoticeBoard saveBoard = noticeBoardRepository.save(noticeBoard);
//
//        //when
//        Optional<NoticeBoard> boardId = noticeBoardRepository.findById(saveBoard.getId());
//
//        //then
//        Assertions.assertThat(noticeBoard).isEqualTo(boardId.get());
//    }
//}