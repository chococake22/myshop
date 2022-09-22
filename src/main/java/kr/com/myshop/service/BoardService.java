package kr.com.myshop.service;


import kr.com.myshop.domain.Board;
import org.json.JSONObject;

import java.util.List;

public interface BoardService {

    // 리스트 조회
    // 검색 기능 포함
    List<Board> SELECT_BOARD_LIST(JSONObject json);

    // 개수
    int COUNT_BOARDS(Board dto);

    // 상세보기
    Board SELECT_BOARD_DETAIL(Long boardIdx);

    // 등록
    // 쿼리 실행 후 해당 게시글 id 받아오기
    int INSERT_BOARD(Board dto);

    // 수정
    Board UPDATE_BOARD(JSONObject json);

    // 블라인드

}
