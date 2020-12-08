package com.howtodoinjava.demo.web;

import com.howtodoinjava.demo.Dao.ProductDao;
import com.howtodoinjava.demo.exception.RecordNotFoundException;
import com.howtodoinjava.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductDao productDao;

    @GetMapping("/view")
    public ModelAndView viweProduct(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("Hello");
        return modelAndView;
    }

    @PostMapping("/addproduct")
    public String addProduct(@RequestParam("product_Image") CommonsMultipartFile file){
       System.out.println(file.getOriginalFilename());
        return "";
    }

    @GetMapping("/register")
    public ModelAndView registerUser(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("user-register");
        return modelAndView;
    }

//    @GetMapping("/registeruser")
//    public User addCourses(@RequestBody User user){
//        return this.productDao.addUser(user);
//    }

    @GetMapping("/registeruser")
    public ModelAndView addUsers(@RequestParam(value = "uid", required = true) String uid,@RequestParam(value = "name", required = true) String name, @RequestParam(value = "mail", required = true) String email, @RequestParam(value = "password", required = true) String password,@RequestParam(value = "mobileno", required = true) String mobileno,@RequestParam(value = "city", required = true) String city,@RequestParam(value = "adharacard", required = true) String adharacard,@RequestParam(value = "accountno", required = true) String accountno) throws RecordNotFoundException {
        User user=new User();
        user.setUid(Integer.valueOf(uid));
        user.setMail(email);
        user.setPassword(password);
        user.setAccountno(Long.valueOf(accountno));
        user.setAdharacard(Long.valueOf(adharacard));
        user.setCity(city);
        user.setName(name);
        user.setMobileno(Long.valueOf(mobileno));
        User user1 = productDao.addUser(user);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("Login-User");
        ResponseEntity<User> responseEntity= new ResponseEntity<User>(user1, new HttpHeaders(), HttpStatus.OK) ;
        return modelAndView;
        }

    @GetMapping("/validation")
    public ModelAndView addUsers(HttpServletRequest request, Model model){
        String email=request.getParameter("email");
        String password=request.getParameter("password");
       User user=productDao.validateUser(email,password);
       ModelAndView modelAndView=new ModelAndView();
       if(user!=null){
           model.addAttribute("user",user);
           modelAndView.setViewName("Profile-User");
       }
       else {
           modelAndView.setViewName("Login-User");
       }
       return modelAndView;
    }

    @GetMapping("/login")
    public ModelAndView loginUser(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("Login-User");
        return modelAndView;
    }

    @GetMapping("/update/{uid}")
    public ModelAndView updateUser(Model model, @PathVariable ("uid") String uid){
//        Integer id=Integer.getInteger(uid);
        User user=productDao.updateUser(Integer.valueOf(uid));
        ModelAndView modelAndView=new ModelAndView();
        model.addAttribute("user",user);
        modelAndView.setViewName("Update-User");
        return modelAndView;
    }

    @GetMapping("/delete/{uid}")
    public ModelAndView deleteUser(Model model, @PathVariable ("uid") String uid){
//        Integer id=Integer.getInteger(uid);
        productDao.deleteUser(Integer.valueOf(uid));
        ModelAndView modelAndView=new ModelAndView();
        //model.addAttribute("user",user);
        modelAndView.setViewName("user-register");
        return modelAndView;
    }


}
