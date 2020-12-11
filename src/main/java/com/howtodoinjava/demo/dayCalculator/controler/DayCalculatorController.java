package com.howtodoinjava.demo.dayCalculator.controler;

import com.howtodoinjava.demo.dayCalculator.model.DayModel;
import com.howtodoinjava.demo.dayCalculator.service.DayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class DayCalculatorController {

    @Autowired
    DayService dayService;

    @GetMapping("/show")
    public ModelAndView showPage(){
        ModelAndView modelAndView=new ModelAndView("calculator");
        return modelAndView;
    }

    @PostMapping("/calculate")
    public ModelAndView calculate(@RequestBody DayModel dayModel, Model model, HttpSession session){
        String startDate=dayModel.getStartDate();
        String endDate=dayModel.getEndDate();
        Integer differance=dayService.calculateDays(startDate,endDate);
        model.addAttribute("days",differance);
        session.setAttribute("days",differance);
        ModelAndView modelAndView =new ModelAndView("result");
        return modelAndView;
    }
    @GetMapping ("/result")
    public ModelAndView result(Model model){
        ModelAndView modelAndView =new ModelAndView("result");
        return modelAndView;
    }
}
