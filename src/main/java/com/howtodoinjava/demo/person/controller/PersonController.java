package com.howtodoinjava.demo.person.controller;

import com.howtodoinjava.demo.exception.RecordNotFoundException;
import com.howtodoinjava.demo.person.dao.PersonDao;
import com.howtodoinjava.demo.person.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController

public class PersonController {

    @Autowired
    PersonDao personDao;

    /**
     *
     * @param
     */
    @GetMapping("/")
    public ModelAndView showLogin(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("login-person");
        return modelAndView;
    }

    @RequestMapping(value = "/view",method = RequestMethod.POST)
    public ResponseEntity<Person> showRecord(@RequestBody Person person){

        ModelAndView modelAndView=new ModelAndView();
        personDao.addPerson(person);
//        modelAndView.setViewName("login-person");
//        if(password.equals(confirmPassword)) {
//            personDao.addPerson(person);
//            modelAndView.setViewName("login-person");
//        }
//        else {
//            model.addAttribute("error","password and confirm password should be march");
//            modelAndView.setViewName("register-person");
//        }
        return new ResponseEntity<Person>(HttpStatus.OK);
//        return modelAndView;
    }

    @GetMapping("/registerperson")
    public ModelAndView registerGetRecord(HttpServletRequest request){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("register-person");
        return modelAndView;
    }

    @GetMapping("/loginperson")
    public ModelAndView loginRecord(HttpServletRequest request){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("login-person");
        return modelAndView;
    }
    @PostMapping("/validateperson")
    public ModelAndView validateRecord(HttpServletRequest request, Model model, HttpSession session){
        String email=request.getParameter("email");
        String password=request.getParameter("password");
        ModelAndView modelAndView=new ModelAndView();
        Person person=personDao.validateRecord(email,password);
        if(person!=null){
            modelAndView.setViewName("welcomeperson");
            model.addAttribute("person",person);
            session.setAttribute("person",person);
        }
        else
        {
            modelAndView.setViewName("login-person");
        }

        return modelAndView;
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteRecord( @PathVariable Long id) throws RecordNotFoundException {
        personDao.getRecord(id);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("register-person");
        return new ResponseEntity<String>("Entry deleted",new HttpHeaders(),HttpStatus.OK);
    }

    @GetMapping("/update/{pid}")
    public ModelAndView updateRecord( @PathVariable Long pid,Model model) throws RecordNotFoundException {
        Person person=personDao.getUpdatedRecord(pid);
        ModelAndView modelAndView=new ModelAndView();
        model.addAttribute("person",person);
        modelAndView.setViewName("update-person");
        return modelAndView;
    }

    @PutMapping("/updateRecord")
    public ResponseEntity<Person> updateRecordHandler(@RequestBody Person person,Model model){
        Person person1= personDao.updateCourse(person);
//        ModelAndView modelAndView=new ModelAndView();
        model.addAttribute("person",person1);
//        modelAndView.setViewName("welcomeperson");
        return new ResponseEntity<Person>(person1,new HttpHeaders(),HttpStatus.OK);
    }
}
