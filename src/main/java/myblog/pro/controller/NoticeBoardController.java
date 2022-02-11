package myblog.pro.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import myblog.pro.dto.NoticeBoardRequestDto;
import myblog.pro.dto.NoticeBoardResponseDto;
import myblog.pro.service.NoticeBoardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@Slf4j
public class NoticeBoardController {

    private final NoticeBoardService noticeBoardService;

    @PostMapping("/post")
    public void postAdd(@RequestBody NoticeBoardRequestDto noticeBoardRequestDto){
        noticeBoardService.addPost(noticeBoardRequestDto);
    }

    @GetMapping("/post")
    public List<NoticeBoardResponseDto> PostGet(){
        return noticeBoardService.findPost().stream()
                .map(NoticeBoardResponseDto::new)
                .collect(Collectors.toList());
    }
}
