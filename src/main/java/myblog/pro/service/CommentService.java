package myblog.pro.service;

import lombok.RequiredArgsConstructor;
import myblog.pro.domain.Comment;
import myblog.pro.domain.NoticeBoard;
import myblog.pro.dto.CommentRequestDto;
import myblog.pro.dto.CommentResponseDto;
import myblog.pro.repository.CommentRepository;
import myblog.pro.repository.NoticeBoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    private final NoticeBoardRepository noticeBoardRepository;

    @Transactional
    public void addComment(Long post_id, CommentRequestDto commentRequestDto) {
        Optional<NoticeBoard> byId = noticeBoardRepository.findById(post_id);
        Comment comment = Comment.builder()
                .contents(commentRequestDto.getContents())
                .commentDate(LocalDateTime.now())
                .build();
        commentRepository.save(comment);
        byId.get().addComment(comment);
    }

    public List<Comment> findComment(Long post_id) {
        return commentRepository.findByComment(post_id);
    }

    @Transactional
    public void removeComment(Long comment_id) {
        commentRepository.deleteById(comment_id);
    }

    @Transactional
    public void modifyComment(Long comment_id, CommentRequestDto commentRequestDto) {
        Optional<Comment> commmentOne = commentRepository.findById(comment_id);
        commmentOne.get().updateComment(commentRequestDto);
    }
}