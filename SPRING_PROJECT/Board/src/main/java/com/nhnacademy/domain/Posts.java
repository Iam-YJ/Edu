package com.nhnacademy.domain;

import java.time.LocalDateTime;

public class Posts implements Post{
    private long contentId; // 게시물 아이디
    private String title; // 제목
    private String content; // 본문
    private String id; // 작성자 아이디
    private LocalDateTime localDateTime; // 작성 시간
    private int views; // 조회수

    public Posts(long contentId, String title, String content, String id,
                 LocalDateTime localDateTime, int views) {
        this.contentId = contentId;
        this.title = title;
        this.content = content;
        this.id = id;
        this.localDateTime = localDateTime;
        this.views = views;
    }

    @Override
    public long getId() {
        return this.contentId;
    }

    @Override
    public void setId(long id) {
        this.contentId = id;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getContent() {
        return this.content;
    }

    @Override
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String getWriterUserId() {
        return this.id;
    }

    @Override
    public void setWriterUserId(String writerUserId) {
        this.id = writerUserId;
    }

    @Override
    public LocalDateTime getWriteTime() {
        return LocalDateTime.now();
    }

    @Override
    public void setWriteTime(LocalDateTime writeTime) {
        this.localDateTime = writeTime;
    }

    @Override
    public int getViewCount() {
        return this.views;
    }

    @Override
    public void increaseViewCount() {
        this.views++;
    }
}
