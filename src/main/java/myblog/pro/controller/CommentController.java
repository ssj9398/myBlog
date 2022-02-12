package myblog.pro.controller;

import lombok.RequiredArgsConstructor;
import myblog.pro.dto.CommentRequestDto;
import myblog.pro.dto.CommentResponseDto;
import myblog.pro.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/comment/{post_id}")
    public void commentAdd(@PathVariable Long post_id, @RequestBody CommentRequestDto commentRequestDto){
        commentService.addComment(post_id, commentRequestDto);
    }

    @GetMapping("/comment/{post_id}")
    public Stream<CommentResponseDto> commentList(@PathVariable Long post_id){
        Stream<CommentResponseDto> commentResponseDtoStream = commentService.findComment(post_id).stream()
                .map(CommentResponseDto::new);
        return commentResponseDtoStream;
    }

    @DeleteMapping("/comment/{comment_id}")
    public void commentRemove(@PathVariable Long comment_id){
        commentService.removeComment(comment_id);
    }

    @PatchMapping("/comment/{comment_id}")
    public void commentModify(@PathVariable Long comment_id, @RequestBody CommentRequestDto commentRequestDto){
        commentService.modifyComment(comment_id,commentRequestDto);
    }
}