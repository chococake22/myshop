package kr.com.myshop.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kr.com.myshop.domain.Board;
import kr.com.myshop.domain.Page;
import kr.com.myshop.service.BoardServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
@Slf4j
public class BoardController {

    private final BoardServiceImpl boardService;

    @GetMapping("/list")
    public String getBoardList(@RequestParam(required = false, value = "nowPage") Integer nowPage, Model model, HttpServletRequest request, Board dto) throws JsonProcessingException {


        JSONObject json = new JSONObject();

        int totalCount = boardService.COUNT_BOARDS(dto);

        Page pagination = new Page(nowPage, totalCount);

        json.put("board", dto);
        json.put("pagination", pagination);


        System.out.println(json);

        List<Board> boards = boardService.SELECT_BOARD_LIST(json);



        System.out.println("현재 페이지 : " + nowPage);
        System.out.println("offset : " + pagination.getOffset());


        model.addAttribute("param", json);
        model.addAttribute("pagination", pagination);
        model.addAttribute("boards", boards);
        model.addAttribute("totalCount", totalCount);

        return "/board/list";
    }

    @GetMapping("/detail")
    public String getBoardDetail(@RequestParam Long boardIdx, Model model, HttpServletRequest request, Board dto) {
        Board board = boardService.SELECT_BOARD_DETAIL(boardIdx);
        model.addAttribute("board", board);

        return "/board/detail";
    }

    @GetMapping("/save")
    public String saveBoard() {
        return "/board/registration";
    }

    @PostMapping("/save")
    public String saveBoard(Board dto) {

        int boardIdx = boardService.INSERT_BOARD(dto);

        log.info("번호 : {}", dto.getBoardIdx());

        return "redirect:/board/list";
    }
}
