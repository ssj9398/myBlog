package myblog.pro.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class NoticeBoard {

    @Id @GeneratedValue
    @Column(name = "board_id")
    private Long id;

    private String title;

    private String writer;

    private String content;

    private LocalDateTime boardDate;

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();
}
