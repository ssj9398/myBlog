package myblog.pro.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import myblog.pro.dto.NoticeBoardRequestDto;
import myblog.pro.dto.NoticeBoardResponseDto;
import myblog.pro.service.NoticeBoardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequiredArgsConstructor
@Slf4j
public class NoticeBoardController {

    private final NoticeBoardService noticeBoardService;

    @PostMapping("/post")
    public void postAdd(@RequestBody NoticeBoardRequestDto noticeBoardRequestDto) {
        noticeBoardService.addPost(noticeBoardRequestDto);
    }

    @GetMapping("/post")
    public List<NoticeBoardResponseDto> PostGetAll() {
        return noticeBoardService.findPostAll().stream()
                .map(NoticeBoardResponseDto::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/post/{board_id}")
    public Stream<Object> PostGetOne(@PathVariable Long board_id) {
        Stream<Object> postOne = noticeBoardService.findPostOne(board_id).stream()
                .map(NoticeBoardResponseDto::new);
        return postOne;
    }

    @DeleteMapping("/post/{board_id}")
    public void postRemove(@PathVariable Long board_id) {
        noticeBoardService.removePost(board_id);
    }

    @PatchMapping("/post/{board_id}")
    public void postModify(@PathVariable Long board_id, NoticeBoardRequestDto noticeBoardRequestDto) {
        noticeBoardService.modifyPost(board_id, noticeBoardRequestDto);
    }
}