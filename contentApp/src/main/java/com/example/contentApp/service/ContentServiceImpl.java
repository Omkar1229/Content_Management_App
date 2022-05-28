package com.example.contentApp.service;

import com.example.contentApp.exception.ContentAlreadyExistsException;
import com.example.contentApp.model.Content;
import com.example.contentApp.repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentServiceImpl implements ContentService{

    private ContentRepository contentRepository;

    @Autowired
    public ContentServiceImpl(ContentRepository contentRepository){
        this.contentRepository=contentRepository;
    }

    @Override
    public List<Content> getAllContents() {
        return contentRepository.findAll();
    }

    @Override
    public Content addContent(Content content) throws ContentAlreadyExistsException {
        if(contentRepository.findById(content.getContentId()).isEmpty())
        {
            return contentRepository.save(content);
        }
        else{
            throw new ContentAlreadyExistsException();
        }
    }
}
