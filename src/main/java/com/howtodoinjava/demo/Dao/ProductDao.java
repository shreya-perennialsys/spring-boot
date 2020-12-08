package com.howtodoinjava.demo.Dao;

import com.howtodoinjava.demo.model.User;
import com.howtodoinjava.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductDao {

//    @Autowired
//    ProductRepo productRepo;

    @Autowired
    UserRepository userRepository;

//    //public void addProduct(Product product){
//        productRepo.save(product);
//    }

    public User addUser(User user){
        Optional<User> userEntity=userRepository.findById(user.getUid());
        if(userEntity.isPresent())
        {
            User update=userEntity.get();
            update.setCity(user.getCity());
            update.setName(user.getName());
            update.setMobileno(user.getMobileno());
            update.setAccountno(user.getAccountno());
            update.setAdharacard(user.getAdharacard());
            update.setPassword(user.getPassword());
            update.setMail(user.getMail());
            userRepository.save(update);
            return update;
        }
        else {
            userRepository.save(user);
            return user;
       }

    }
    public User validateUser(String email,String password){
        List<User> userList=userRepository.findAll();
        User userentity=new User();
        int flag=0;
        for(User user:userList){
            if(user.getMail().equalsIgnoreCase(email)&&user.getPassword().equals(password)){
               flag=1;
               userentity=user;
               break;
            }

        }
        if(flag==1){
            return userentity;
        }
        else {
            return null;
        }
    }

    public User updateUser(Integer uid){
        User user= userRepository.getOne(uid);
        return user;

    }

    public void deleteUser(Integer id) {
        User user= userRepository.getOne(id);
        userRepository.delete(user);
    }
}
