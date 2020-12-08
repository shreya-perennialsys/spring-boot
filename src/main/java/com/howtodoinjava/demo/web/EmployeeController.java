package com.howtodoinjava.demo.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.howtodoinjava.demo.exception.RecordNotFoundException;
import com.howtodoinjava.demo.model.EmployeeEntity;
import com.howtodoinjava.demo.service.EmployeeService;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    EmployeeService service;


    @GetMapping
    public ResponseEntity<List<EmployeeEntity>> getAllEmployees() {
        List<EmployeeEntity> list = service.getAllEmployees();
        return new ResponseEntity<List<EmployeeEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/view")
    public ModelAndView getAllEmployeesView() {
        List<EmployeeEntity> list = service.getAllEmployees();

        ModelAndView modelAndView = new ModelAndView("list-employees");
        modelAndView.addObject("employees", list);
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeEntity> getEmployeeById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        EmployeeEntity entity = service.getEmployeeById(id);
        return new ResponseEntity<EmployeeEntity>(entity, new HttpHeaders(), HttpStatus.OK);
    }

//    @PostMapping("/addUser")
//    public ResponseEntity<EmployeeEntity> createOrUpdateEmployee(@RequestBody EmployeeEntity employee)
//                                                    throws RecordNotFoundException {
//        EmployeeEntity updated = service.createOrUpdateEmployee(employee);
//        return new ResponseEntity<EmployeeEntity>(updated, new HttpHeaders(), HttpStatus.OK);
//
//    }

    @GetMapping("/addUser")
    public ModelAndView addUsers(@RequestParam(value = "id", required = true) String id1, @RequestParam(value = "firstName", required = true) String fName, @RequestParam(value = "lastName", required = true) String lName, @RequestParam(value = "email") String emil1) throws RecordNotFoundException {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setId(Long.valueOf(id1));
        employeeEntity.setFirstName(fName);
        employeeEntity.setLastName(lName);
        employeeEntity.setEmail(emil1);
        EmployeeEntity updated = service.createOrUpdateEmployee(employeeEntity);
        ResponseEntity<EmployeeEntity> responseEntity=new  ResponseEntity<EmployeeEntity>(updated, new HttpHeaders(), HttpStatus.OK);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("addProduct");
        return modelAndView;
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteEmployeeById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        service.deleteEmployeeById(id);
        return HttpStatus.OK;
    }

    @GetMapping("/login")
    public ModelAndView login_user() {
        List<EmployeeEntity> list = service.getAllEmployees();

        ModelAndView modelAndView = new ModelAndView("list-employees");
        return modelAndView;
    }

    @PostMapping("/tologin")
    public ModelAndView xyz(HttpServletRequest request) {
        String fname = request.getParameter("first_name");
        String emaill = request.getParameter("email");
        ModelAndView modelAndView = new ModelAndView();

        EmployeeEntity employeeEntity1 = service.checkLoginDetail(fname, emaill);
        int flag = 0;

        if (employeeEntity1 != null) {
            modelAndView.setViewName("WelcomePage");

        } else {
            modelAndView.setViewName("addProduct");

        }
        return modelAndView;

    }
}
