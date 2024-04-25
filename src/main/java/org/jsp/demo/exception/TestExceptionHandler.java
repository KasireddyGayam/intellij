package org.jsp.demo.exception;

import org.jsp.demo.model.User;
import org.jsp.demo.util.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class TestExceptionHandler extends ResponseEntityExceptionHandler
{
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ResponseStructure<String>> handleException(UserNotFoundException e){
        ResponseStructure<String>structure=new ResponseStructure<>();
        structure.setMessage(e.getMessage());
        structure.setStatus(HttpStatus.NOT_FOUND.value());
        structure.setData("Invalid user id");
        return new ResponseEntity<>(structure,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(InvalidCredentialException.class)
    public ResponseEntity<ResponseStructure<String>> handleException(InvalidCredentialException e)
    {
        ResponseStructure<String> structure=new ResponseStructure<>();
        structure.setMessage(e.getMessage());
        structure.setStatus(HttpStatus.UNAUTHORIZED.value());
        structure.setData("Invalid credential");
        return new ResponseEntity<>(structure,HttpStatus.UNAUTHORIZED);
    }
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ResponseStructure<String>> handleException(ProductNotFoundException e)
    {
        ResponseStructure<String> structure=new ResponseStructure<>();
        structure.setMessage(e.getMessage());
        structure.setStatus(HttpStatus.NOT_FOUND.value());
        structure.setData("Product not found");
        return new ResponseEntity<>(structure,HttpStatus.NOT_FOUND);
    }
}
