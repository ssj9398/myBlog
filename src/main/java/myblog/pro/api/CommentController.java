package myblog.pro.api;

import lombok.RequiredArgsConstructor;
import myblog.pro.dto.CommentRequestDto;
import myblog.pro.dto.CommentResponseDto;
import myblog.pro.model.Success;
import myblog.pro.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/comment/{post_id}")
    public ResponseEntity<Success> commentAdd(@PathVariable Long post_id, @RequestBody CommentRequestDto commentRequestDto){
        commentService.addComment(post_id, commentRequestDto);
        return new ResponseEntity<>(new Success(true,"댓글 등록 완료!"), HttpStatus.OK);
    }

    @GetMapping("/comment/{post_id}")
    public Stream<CommentResponseDto> commentList(@PathVariable Long post_id){
        Stream<CommentResponseDto> commentResponseDtoStream = commentService.findComment(post_id).stream()
                .map(CommentResponseDto::new);
        return commentResponseDtoStream;
    }

    @DeleteMapping("/comment/{comment_id}")
    public ResponseEntity<Success> commentRemove(@PathVariable Long comment_id){
        commentService.removeComment(comment_id);
        return new ResponseEntity<>(new Success(true,"댓글 삭제 완료!"), HttpStatus.OK);
    }

    @PatchMapping("/comment/{comment_id}")
    public ResponseEntity<Success> commentModify(@PathVariable Long comment_id, @RequestBody CommentRequestDto commentRequestDto){
        commentService.modifyComment(comment_id,commentRequestDto);
        return new ResponseEntity<>(new Success(true,"댓글 수정 성공!"), HttpStatus.OK);
    }
}