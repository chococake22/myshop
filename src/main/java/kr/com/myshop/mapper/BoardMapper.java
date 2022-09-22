package kr.com.myshop.mapper;

import kr.com.myshop.domain.Board;
import org.apache.ibatis.annotations.Mapper;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BoardMapper {

    List<Board> SELECT_BOARD_LIST(JSONObject json);

    int COUNT_BOARDS(Board dto);

    Board SELECT_BOARD_DETAIL(Long boardIdx);

    int INSERT_BOARD(Board dto);

    Board UPDATE_BOARD(JSONObject json);

}
