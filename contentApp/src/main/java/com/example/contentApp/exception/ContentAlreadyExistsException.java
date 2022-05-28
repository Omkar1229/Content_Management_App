package com.example.contentApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.CONFLICT,reason="Content already exists")
public class ContentAlreadyExistsException extends Exception{
}
