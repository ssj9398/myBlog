//package myblog.pro.service;
//
//import myblog.pro.domain.NoticeBoard;
//import myblog.pro.dto.NoticeBoardRequestDto;
//import myblog.pro.repository.NoticeBoardRepository;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.Optional;
//
//import static org.assertj.core.api.Assertions.*;
//
//@SpringBootTest
//@Transactional(readOnly = true)
//class NoticeBoardServiceTest {
//
//    @Autowired
//    private NoticeBoardRepository noticeBoardRepository;
//
//    @Autowired
//    private NoticeBoardService noticeBoardService;
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
//        assertThat(noticeBoard).isEqualTo(boardId.get());
//    }
//
//    @Test
//    void findPostAll() {
//        //given
//        NoticeBoard noticeBoard = NoticeBoard.builder()
//                .writer("저자")
//                .content("내용")
//                .title("제목")
//                .boardDate(LocalDateTime.now())
//                .build();
//        noticeBoardRepository.save(noticeBoard);
//        //when
//        List<NoticeBoard> allByOrderByBoardDateDesc = noticeBoardRepository.findAllByOrderByBoardDateDesc();
//        //then
//        assertThat(allByOrderByBoardDateDesc.size()).isEqualTo(4);
//    }
//
//    @Test
//    void findPostOne(){
//        //given
//        NoticeBoard noticeBoard = NoticeBoard.builder()
//                .writer("저자")
//                .content("내용")
//                .title("제목")
//                .boardDate(LocalDateTime.now())
//                .build();
//        NoticeBoard saveBoard = noticeBoardRepository.save(noticeBoard);
//        //when
//        Optional<NoticeBoard> findBoard = noticeBoardRepository.findById(saveBoard.getId());
//        //then
//        assertThat(findBoard.get().getId()).isSameAs(saveBoard.getId());
//    }
//
//    @Test
//    @Rollback(false)
//    void removePost(){
//        //given
//        NoticeBoard noticeBoard = NoticeBoard.builder()
//                .writer("저자")
//                .content("내용")
//                .title("제목")
//                .boardDate(LocalDateTime.now())
//                .build();
//        NoticeBoard saveBoard = noticeBoardRepository.save(noticeBoard);
//        //when
//        noticeBoardRepository.deleteById(saveBoard.getId());
//        //then
//        assertThat(saveBoard.getContent()).isEqualTo("내용");
//    }
//
//    @Test
//    @Rollback(value = false)
//    void modifyPost(){
//        //given
//        NoticeBoard noticeBoard = NoticeBoard.builder()
//                .writer("저자")
//                .content("내용")
//                .title("제목")
//                .boardDate(LocalDateTime.now())
//                .build();
//        NoticeBoard saveBoard = noticeBoardRepository.save(noticeBoard);
//        NoticeBoardRequestDto noticeBoardRequestDto = new NoticeBoardRequestDto("제목33","저자11","내용22");
//        //when
//        noticeBoardService.modifyPost(saveBoard.getId(), noticeBoardRequestDto);
//        Optional<NoticeBoard> byId = noticeBoardRepository.findById(saveBoard.getId());
//        //then
//        assertThat(byId.get().getContent()).isEqualTo("내용22");
//    }
//}