package kr.com.myshop.service;

import kr.com.myshop.domain.Board;
import kr.com.myshop.mapper.BoardMapper;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;

    @Override
    public List<Board> SELECT_BOARD_LIST(JSONObject json) {
        return boardMapper.SELECT_BOARD_LIST(json);
    }

    @Override
    public int COUNT_BOARDS(Board dto) {
        return boardMapper.COUNT_BOARDS(dto);
    }

    @Override
    public Board SELECT_BOARD_DETAIL(Long boardIdx) {
        return boardMapper.SELECT_BOARD_DETAIL(boardIdx);
    }

    @Override
    public int INSERT_BOARD(Board dto) {
        return boardMapper.INSERT_BOARD(dto);
    }

    @Override
    public Board UPDATE_BOARD(JSONObject json) {
        return boardMapper.UPDATE_BOARD(json);
    }
}
