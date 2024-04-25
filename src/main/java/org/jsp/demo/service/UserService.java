package org.jsp.demo.service;

import org.jsp.demo.dao.UserDao;
import org.jsp.demo.exception.UserNotFoundException;
import org.jsp.demo.exception.UserNotFoundException;
import org.jsp.demo.model.User;
import org.jsp.demo.util.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
    @Autowired
    private UserDao userDao;
    public ResponseEntity<ResponseStructure<User>> save(User user){
        ResponseStructure<User> structure = new ResponseStructure<>();
        structure.setData(userDao.save(user));
        structure.setMessage("Success");
        structure.setStatus(HttpStatus.CREATED.value());
        return new ResponseEntity<>(structure,HttpStatus.CREATED);
    }

    public ResponseEntity<ResponseStructure<User>> update(User user){
        ResponseStructure<User> structure = new ResponseStructure<>();
        User user1=userDao.update(user);
        if(user1!=null){
            structure.setData(user1);
            structure.setMessage("Updated");
            structure.setStatus(HttpStatus.OK.value());
            return new ResponseEntity<>(structure,HttpStatus.OK);
        }
        throw new UserNotFoundException("Invalid User Id");
    }
}
