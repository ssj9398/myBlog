package myblog.pro.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import myblog.pro.dto.NoticeBoardResponseDto;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetPost {
    private boolean success;
    private String msg;
    private List<NoticeBoardResponseDto> data;
}
