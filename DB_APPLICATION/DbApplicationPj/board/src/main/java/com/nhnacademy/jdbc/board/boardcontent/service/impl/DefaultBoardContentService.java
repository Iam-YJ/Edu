package com.nhnacademy.jdbc.board.boardcontent.service.impl;

import com.nhnacademy.jdbc.board.boardcontent.domain.BoardContent;
import com.nhnacademy.jdbc.board.boardcontent.mapper.BoardContentMapper;
import com.nhnacademy.jdbc.board.boardcontent.service.BoardContentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DefaultBoardContentService implements BoardContentService {
    private final BoardContentMapper boardContentMapper;

    public DefaultBoardContentService(BoardContentMapper boardContentMapper) {
        this.boardContentMapper = boardContentMapper;
    }

    @Override
    public List<BoardContent> getBoardContents() {
        return boardContentMapper.getBoardContents();
    }

    @Override
    public List<BoardContent> getBoardContentsByTitle(String title) {
        return boardContentMapper.getBoardContentsByTitle(title);
    }

    @Override
    public int modifyBoardContentByUser(String id, int contentSerialNumber, String title, String content) {
        return boardContentMapper.modifyBoardContentByUser(id, contentSerialNumber, title, content);
    }

    @Override
    public int deleteBoardContentByUser(String id, int contentSerialNumber) {
        return boardContentMapper.deleteBoardContentByUser(id, contentSerialNumber);
    }

    @Override
    public int deleteBoardContentByAdmin(int contentSerialNumber) {
        return boardContentMapper.deleteBoardContentByAdmin(contentSerialNumber);
    }

    @Override
    public int writeBoardContent(BoardContent boardContent) {
        return boardContentMapper.writeBoardContent(boardContent);
    }

    @Override
    public List<BoardContent> getBoardContentsPaging() {
        return boardContentMapper.getBoardContentsPaging();
    }

    @Override
    public int rollBackBoardContentByAdmin(String id, int contentSerialNumber) {
        return boardContentMapper.rollBackBoardContentByAdmin(id, contentSerialNumber);
    }

    @Override
    public int upLike(String id, int contentSerialNumber) {
        return boardContentMapper.upLike(id, contentSerialNumber);
    }

    @Override
    public int downLike(String id, int contentSerialNumber) {
        return boardContentMapper.downLike(id, contentSerialNumber);
    }


}
