package myblog.pro.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import myblog.pro.domain.NoticeBoard;
import myblog.pro.dto.NoticeBoardRequestDto;
import myblog.pro.dto.NoticeBoardResponseDto;
import myblog.pro.model.GetPost;
import myblog.pro.model.Success;
import myblog.pro.service.NoticeBoardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequiredArgsConstructor
@Slf4j
public class NoticeBoardController {

    private final NoticeBoardService noticeBoardService;

    @PostMapping("/post")
    public ResponseEntity<Success> postAdd(@RequestBody NoticeBoardRequestDto noticeBoardRequestDto) {
        noticeBoardService.addPost(noticeBoardRequestDto);
        return new ResponseEntity<>(new Success(true,"게시글 등록 완료!"), HttpStatus.OK);
    }

    @GetMapping("/post")
    public List<NoticeBoardResponseDto> PostGetAll() {
        return noticeBoardService.findPostAll().stream()
                .map(NoticeBoardResponseDto::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/post/{board_id}")
    public ResponseEntity<GetPost> PostGetOne(@PathVariable Long board_id) {
        List<NoticeBoard> postOne = noticeBoardService.findPostOne(board_id);
        return new ResponseEntity<>(new GetPost(true,"게시물 조회 성공",postOne.stream()
                .map(NoticeBoardResponseDto::new)
                .collect(Collectors.toList())),HttpStatus.OK);
    }

    @DeleteMapping("/post/{board_id}")
    public ResponseEntity<Success> postRemove(@PathVariable Long board_id) {
        noticeBoardService.removePost(board_id);
        return new ResponseEntity<>(new Success(true,"게시글 삭제 완료!"), HttpStatus.OK);
    }

    @PatchMapping("/post/{board_id}")
    public ResponseEntity<Success> postModify(@PathVariable Long board_id,@RequestBody NoticeBoardRequestDto noticeBoardRequestDto) {
        noticeBoardService.modifyPost(board_id, noticeBoardRequestDto);
        return new ResponseEntity<>(new Success(true,"게시글 수정 완료!"), HttpStatus.OK);
    }
}