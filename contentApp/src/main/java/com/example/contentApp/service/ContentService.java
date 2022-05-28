package com.example.contentApp.service;

import com.example.contentApp.exception.ContentAlreadyExistsException;
import com.example.contentApp.model.Content;

import java.util.List;

public interface ContentService {
    public abstract List<Content> getAllContents();
    public abstract Content addContent(Content content) throws ContentAlreadyExistsException;
}
