package myblog.pro.repository;

import myblog.pro.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query("select c from Comment c where c.board.id=:post_id order by c.commentDate desc ")
    List<Comment> findByComment(@Param("post_id") Long post_id);
}
