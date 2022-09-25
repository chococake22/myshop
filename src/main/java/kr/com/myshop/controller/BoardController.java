package kr.com.myshop.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import kr.com.myshop.domain.Board;
import kr.com.myshop.domain.Page;
import kr.com.myshop.domain.Search;
import kr.com.myshop.service.BoardServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONObject;

import org.springframework.boot.json.JsonParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
@Slf4j
public class BoardController {

    private final BoardServiceImpl boardService;

    @GetMapping("/list")
    public String getBoardList(@RequestParam(required = false, value = "nowPage") Integer nowPage,
                               Model model,
                               HttpServletRequest request,
                               Board dto,
                               Search search
                               ) throws JsonProcessingException {

        if (nowPage == null) {
            nowPage = 1;
        }

        // 검색에 따른 데이터 개수
        int totalCount = boardService.COUNT_BOARDS(dto);

        // 페이지용 객체
        Page pagination = new Page(nowPage, totalCount);
        dto.setOffset(pagination.getOffset());

        // 검색 결과 데이터
        List<Board> boards = boardService.SELECT_BOARD_LIST(dto);

        System.out.println("현재 페이지 : " + pagination.getNowPage());
        System.out.println("offset : " + pagination.getOffset());


        System.out.println("시작 인덱스 : " + boards.get(0).getBoardIdx());

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
