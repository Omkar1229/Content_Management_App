package com.example.contentApp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Document
public class Content {

    @Id
    private int contentId;

    private String contentTitle,contentType,contentDate,contentBody;

    public Content() {
    }

    public Content(int contentId, String contentTitle, String contentType, String contentDate, String contentBody) {
        this.contentId = contentId;
        this.contentTitle = contentTitle;
        this.contentType = contentType;
        this.contentDate = contentDate;
        this.contentBody = contentBody;
    }

    public int getContentId() {
        return contentId;
    }

    public void setContentId(int contentId) {
        this.contentId = contentId;
    }

    public String getContentTitle() {
        return contentTitle;
    }

    public void setContentTitle(String contentTitle) {
        this.contentTitle = contentTitle;
    }

    public String getContentBody() {
        return contentBody;
    }

    public void setContentBody(String contentBody) {
        this.contentBody = contentBody;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getContentDate() {
        return contentDate;
    }

    public void setContentDate(String contentDate) {
        this.contentDate = contentDate;
    }

    @Override
    public String toString() {
        return "Content{" +
                "contentId=" + contentId +
                ", contentTitle='" + contentTitle + '\'' +
                ", contentType='" + contentType + '\'' +
                ", contentDate='" + contentDate + '\'' +
                ", contentBody='" + contentBody + '\'' +
                '}';
    }
}
