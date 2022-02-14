package myblog.pro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {
//    @RequestMapping("/")
//    public String home(){
//        return "home";
//    }

    @GetMapping("/")
    public String post(){
        return "board/board";
    }

    @GetMapping("/api/write")
    public String write(){
        return "board/write";
    }

    @GetMapping("/api/edit")
    public String edit(){
        return "board/edit";
    }

    @GetMapping("/api/board/detail")
    public String detail(){
        return "board/boardDetail";
    }
}
