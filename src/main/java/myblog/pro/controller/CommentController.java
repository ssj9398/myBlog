package myblog.pro.controller;

import lombok.RequiredArgsConstructor;
import myblog.pro.dto.CommentRequestDto;
import myblog.pro.service.CommentService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/comment/{post_id}")
    public void commentAdd(@PathVariable Long post_id, @RequestBody CommentRequestDto commentRequestDto){
        commentService.addComment(post_id, commentRequestDto);
    }
}
