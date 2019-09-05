package com.zdz.test.web.tool.retrofit2;

import lombok.Data;

@Data
public class Blog {

    public long id;

    public String date;

    public String author;

    public String title;


    public String content;

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}