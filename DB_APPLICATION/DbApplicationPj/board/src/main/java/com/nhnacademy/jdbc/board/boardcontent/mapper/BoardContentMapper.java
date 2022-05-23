package com.nhnacademy.jdbc.board.boardcontent.mapper;

import com.nhnacademy.jdbc.board.boardcontent.domain.BoardContent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Mapper
public interface BoardContentMapper {

    // 전체 조회
    List<BoardContent> getBoardContents();

    // 글 제목으로 조회
    List<BoardContent> getBoardContentsByTitle(String title);

    //글 작성자 수정
    int modifyBoardContentByUser(String id, int contentSerialNumber, String title, String content);

    // 글 작성자 삭제
    int deleteBoardContentByUser(@Param("id") String id, @Param("contentSerialNumber") int contentSerialNumber);

    // 글 관리자 삭제
    int deleteBoardContentByAdmin(int contentSerialNumber);

    // 글 작성
    int writeBoardContent(BoardContent boardContent);

    // 조회 20개 paging
    List<BoardContent> getBoardContentsPaging();

    // 복구 관리자
    int rollBackBoardContentByAdmin(String id, int contentSerialNumber);

    // 좋아요 등록
    public int upLike(String id, int contentSerialNumber);

    // 좋아요 취소
    public int downLike(String id, int contentSerialNumber);

    // 댓글
    // fixme
}
