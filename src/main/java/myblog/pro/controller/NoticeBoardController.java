package myblog.pro.controller;

import lombok.RequiredArgsConstructor;
import myblog.pro.dto.NoticeBoardRequestDto;
import myblog.pro.service.NoticeBoardService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class NoticeBoardController {

    private final NoticeBoardService noticeBoardService;

    @PostMapping("/post")
    public void postAdd(@RequestBody NoticeBoardRequestDto noticeBoardRequestDto){
        noticeBoardService.addPost(noticeBoardRequestDto);
    }
}
