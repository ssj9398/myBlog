package myblog.pro.repository;

import myblog.pro.domain.NoticeBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface NoticeBoardRepository extends JpaRepository<NoticeBoard, Long> {
    List<NoticeBoard> findAllByOrderByBoardDateDesc();

    @Query("select distinct n from NoticeBoard n left join fetch n.comments where n.id=:board_id")
    List<NoticeBoard> findByPost(@Param("board_id") Long board_id);
}
