package myblog.pro.repository;

import myblog.pro.domain.NoticeBoard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoticeBoardRepository extends JpaRepository<NoticeBoard, Long> {
    List<NoticeBoard> findAllByOrderByBoardDateDesc();
}
