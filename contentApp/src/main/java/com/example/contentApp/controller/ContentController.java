package com.example.contentApp.controller;

import com.example.contentApp.exception.ContentAlreadyExistsException;
import com.example.contentApp.model.Content;
import com.example.contentApp.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/contapp/v1")
public class ContentController {

    private ContentService contentService;

    @Autowired
    public ContentController(ContentService contentService){
        this.contentService=contentService;
    }

    @GetMapping("/content")
    public ResponseEntity<?> getAllContents(){
        return new ResponseEntity<>(contentService.getAllContents(), HttpStatus.OK);
    }

    @PostMapping("/content")
    public ResponseEntity<?> addContent(@RequestBody Content content) throws ContentAlreadyExistsException {
        try{
            return new ResponseEntity<>(contentService.addContent(content),HttpStatus.OK);
        }
        catch(ContentAlreadyExistsException c){
            throw new ContentAlreadyExistsException();
        }
    }


}
