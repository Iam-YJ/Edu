package com.nhnacademy.jdbc.board.boardcontent.domain;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
public class BoardContent {
    private int contentSerialNumber;
    private final String title;
    private final int classNumber;
    private final String content;
    private final String file;
    private final Timestamp writeTime;
    private final int likeCount;
    private final int rollBackFlag;
    private final int replyLimit;
    private final String id;

    public BoardContent(int contentSerialNumber, String title, int classNumber, String content, String file, Timestamp writeTime, int likeCount, int rollBackFlag, int replyLimit, String id) {
        this.contentSerialNumber = contentSerialNumber;
        this.title = title;
        this.classNumber = classNumber;
        this.content = content;
        this.file = file;
        this.writeTime = writeTime;
        this.likeCount = likeCount;
        this.rollBackFlag = rollBackFlag;
        this.replyLimit = replyLimit;
        this.id = id;
    }
}
