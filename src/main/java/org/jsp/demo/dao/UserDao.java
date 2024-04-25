package org.jsp.demo.dao;

import org.jsp.demo.model.User;
import org.jsp.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDao
{
    @Autowired
    private UserRepository repository;

    public User save(User user){
        return repository.save(user);
    }

    public Optional<User> findById(int id){
        return repository.findById(id);
    }

    public User update(User user){
        Optional<User> u=findById(user.getId());
        if(u.isPresent()){
            User u1=u.get();
            u1.setName(user.getName());
            u1.setEmail(user.getEmail());
            u1.setPassword(user.getPassword());
            u1.setPhone(user.getPhone());
            return repository.save(u1);
        }
        return null;
    }
    public void delete(int id){
        if(findById(id).isPresent()){
            repository.delete(findById(id).get());
        }
    }
    public List<User> findAll(){
        return repository.findAll();
    }
}
