package com.nhnacademy.jdbc.board.boardlist.service;

import com.nhnacademy.jdbc.board.boardcontent.domain.BoardContent;
import com.nhnacademy.jdbc.board.boardlist.domain.BoardList;
import java.util.List;
import java.util.Optional;

public interface BoardListService {

    // 전체 조회
    List<BoardList> getBoardLists();

    // 글 1개 조회 String id parameter 부분 기능을 명확히 하자
    Optional<BoardList> getBoardList(int contentSerialNumber);

    //TODO : 추가할 기능이 있으면 해보도록 하자!!
}
