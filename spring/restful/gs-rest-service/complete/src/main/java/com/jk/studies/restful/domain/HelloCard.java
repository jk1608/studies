package com.jk.studies.restful.domain;

public class HelloCard {

    private final long id;
    private final String content;

    public HelloCard(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
