package com.nhnacademy.jdbc.board.boardlist.domain;

import java.time.LocalDateTime;

public class BoardList {
    private final String title;
    private final LocalDateTime writeTime;
    private final LocalDateTime modifyTime;
    private int contentCount;

    public String getTitle() {
        return title;
    }

    public LocalDateTime getWriteTime() {
        return writeTime;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public int getContentCount() {
        return contentCount;
    }

    public BoardList(String title, LocalDateTime writeTime, LocalDateTime modifyTime) {
        this.title = title;
        this.writeTime = writeTime;
        this.modifyTime = modifyTime;
    }

    public BoardList(String title, LocalDateTime writeTime, LocalDateTime modifyTime,
                     int contentCount) {
        this.title = title;
        this.writeTime = writeTime;
        this.modifyTime = modifyTime;
        this.contentCount = contentCount;
    }
}
