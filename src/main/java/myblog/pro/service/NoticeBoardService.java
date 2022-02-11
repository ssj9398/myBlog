package myblog.pro.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import myblog.pro.domain.NoticeBoard;
import myblog.pro.dto.NoticeBoardRequestDto;
import myblog.pro.repository.NoticeBoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class NoticeBoardService {

    private final NoticeBoardRepository noticeBoardRepository;

    @Transactional(readOnly = false)
    public void addPost(NoticeBoardRequestDto noticeBoardRequestDto) {
        NoticeBoard noticeBoard = NoticeBoard.builder()
                .title(noticeBoardRequestDto.getTitle())
                .content(noticeBoardRequestDto.getContent())
                .writer(noticeBoardRequestDto.getWriter())
                .boardDate(LocalDateTime.now())
                .build();
        noticeBoardRepository.save(noticeBoard);
    }

    @Transactional
    public List<NoticeBoard> findPost() {
        return noticeBoardRepository.findAllByOrderByBoardDateDesc();
    }
}