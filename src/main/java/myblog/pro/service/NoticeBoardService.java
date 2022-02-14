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

    @Transactional
    public void addPost(NoticeBoardRequestDto noticeBoardRequestDto) {
        NoticeBoard noticeBoard = NoticeBoard.builder()
                .title(noticeBoardRequestDto.getTitle())
                .content(noticeBoardRequestDto.getContent())
                .writer(noticeBoardRequestDto.getWriter())
                .boardDate(LocalDateTime.now())
                .build();
        noticeBoardRepository.save(noticeBoard);
    }

    public List<NoticeBoard> findPostAll() {
        return noticeBoardRepository.findAllByOrderByBoardDateDesc();
    }

    public List<NoticeBoard> findPostOne(Long board_id) {
        List<NoticeBoard> noticeBoards = noticeBoardRepository.findByPost(board_id);
        return noticeBoards;
    }

    @Transactional
    public void removePost(Long board_id) {
        noticeBoardRepository.deleteById(board_id);
    }

    @Transactional
    public NoticeBoard modifyPost(Long board_id, NoticeBoardRequestDto noticeBoardRequestDto) {
        Optional<NoticeBoard> findById = Optional.ofNullable(noticeBoardRepository.findById(board_id).orElseThrow(NullPointerException::new));
        findById.get().updateNoticeBoard(noticeBoardRequestDto);
        return findById.get();
    }
}