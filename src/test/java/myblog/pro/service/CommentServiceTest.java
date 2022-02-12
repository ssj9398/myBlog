//package myblog.pro.service;
//
//import myblog.pro.domain.Comment;
//import myblog.pro.domain.NoticeBoard;
//import myblog.pro.dto.CommentRequestDto;
//import myblog.pro.dto.CommentResponseDto;
//import myblog.pro.dto.NoticeBoardRequestDto;
//import myblog.pro.dto.NoticeBoardResponseDto;
//import myblog.pro.repository.CommentRepository;
//import myblog.pro.repository.NoticeBoardRepository;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//import static org.assertj.core.api.Assertions.*;
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//class CommentServiceTest {
//
//    @Autowired
//    private CommentRepository commentRepository;
//
//    @Autowired
//    private NoticeBoardRepository noticeBoardRepository;
//
//    @Test
//    @Rollback(false)
//    void addComment() {
//        //given
//        // 게시글 값 받기
//        NoticeBoardRequestDto noticeBoardRequestDto = new NoticeBoardRequestDto("제목임","저자임","내용임");
//
//        // 게시글 저장하기
//        NoticeBoard noticeBoard = NoticeBoard.builder()
//                .boardDate(LocalDateTime.now())
//                .content(noticeBoardRequestDto.getContent())
//                .writer(noticeBoardRequestDto.getWriter())
//                .title(noticeBoardRequestDto.getTitle())
//                .build();
//        NoticeBoard saveBoard = noticeBoardRepository.save(noticeBoard);
//
//        // 저장한 게시글 id로 찾기
//        Optional<NoticeBoard> saveId = noticeBoardRepository.findById(saveBoard.getId());
//
//        // 저장한 게시글 id로 찾는데 ResponseDto로 변환
//        List<NoticeBoardResponseDto> saveBoardId = noticeBoardRepository.findById(saveBoard.getId()).stream()
//                .map(NoticeBoardResponseDto::new)
//                .collect(Collectors.toList());
//
//        //when
//        // 댓글 내용 받기
//        CommentRequestDto commentRequestDto = new CommentRequestDto("내용내용임");
//
//        // 게시글 저장하기
//        Comment comment = Comment.builder()
//                .contents(commentRequestDto.getContents())
//                .commentDate(LocalDateTime.now())
//                .build();
//        Comment saveCommentId = commentRepository.save(comment);
//        //saveBoardId.get(1).addComment(comment);
//        //saveBoardId.get();
//
//        //then
//        System.out.println("saveBoardId" + saveBoardId);
//        //System.out.println("saveStreamCommentId" + saveStreamCommentId);
//        assertThat(saveCommentId.getContents()).isEqualTo("내용내용임");
//
//    }
//
//    @Test
//    void findComment() {
//
//        //given
//        // 게시글 값 받기
//        NoticeBoardRequestDto noticeBoardRequestDto = new NoticeBoardRequestDto("제목임","저자임","내용임");
//
//        // 게시글 저장하기
//        NoticeBoard noticeBoard = NoticeBoard.builder()
//                .boardDate(LocalDateTime.now())
//                .content(noticeBoardRequestDto.getContent())
//                .writer(noticeBoardRequestDto.getWriter())
//                .title(noticeBoardRequestDto.getTitle())
//                .build();
//        NoticeBoard saveBoard = noticeBoardRepository.save(noticeBoard);
//
//        // 저장한 게시글 id로 찾는데 ResponseDto로 변환
//        List<NoticeBoardResponseDto> saveBoardId = noticeBoardRepository.findById(saveBoard.getId()).stream()
//                .map(NoticeBoardResponseDto::new)
//                .collect(Collectors.toList());
//
//        //when
//        // 댓글 내용 받기
//        CommentRequestDto commentRequestDto = new CommentRequestDto("내용내용임");
//
//        // 게시글 저장하기
//        Comment comment = Comment.builder()
//                .contents(commentRequestDto.getContents())
//                .commentDate(LocalDateTime.now())
//                .build();
//        Comment saveCommentId = commentRepository.save(comment);
//
//        // 저장한 게시글 id로 찾기기
//       Optional<Comment> commentId = commentRepository.findById(saveCommentId.getId());
//
//        //then
//        assertThat(commentId.get().getId()).isEqualTo(saveCommentId.getId());
//    }
//
//    @Test
//    void removeComment() {
//        //given
//        // 게시글 저장하기
//        Comment comment = Comment.builder()
//                .contents("commentRequestDto.getContents()")
//                .commentDate(LocalDateTime.now())
//                .build();
//        Comment saveCommentId = commentRepository.save(comment);
//
//        //when
//        // 저장한 게시글 id로 찾기기
//        Optional<Comment> commentId = commentRepository.findById(saveCommentId.getId());
//        List<Comment> all = commentRepository.findAll();
//
//        commentRepository.deleteById(saveCommentId.getId());
//        List<Comment> modifyAll = commentRepository.findAll();
//        //then
//        assertThat(all.size()).isEqualTo(modifyAll.size()+1);
//        //assertThat(commentId.get().getId()).isEqualTo(saveCommentId.getId());
//
//    }
//
//    @Test
//    void modifyComment() {
//        //given
//        // 게시글 저장하기
//        Comment comment = Comment.builder()
//                .contents("commentRequestDto.getContents()")
//                .commentDate(LocalDateTime.now())
//                .build();
//        Comment saveCommentId = commentRepository.save(comment);
//
//        //when
//        // 댓글 내용 받기
//        CommentRequestDto commentRequestDto = new CommentRequestDto("내용내용임");
//        saveCommentId.updateComment(commentRequestDto);
//        //then
//        assertThat(comment.getContents()).isEqualTo("내용내용임");
//    }
//}