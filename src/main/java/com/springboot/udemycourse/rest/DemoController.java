package com.springboot.udemycourse.rest;

import com.springboot.udemycourse.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach coach;
    private Coach otherCoach;

   @Autowired
   public DemoController(
           @Qualifier("cricketCoach") Coach coach,
           @Qualifier("cricketCoach") Coach otherCoach) {
       System.out.println("In constructor: " + getClass().getSimpleName());
       this.coach = coach;
       this.otherCoach = otherCoach;
   }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return coach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String check() {
       return "Comparing beans: coach == otherCoach, " + (coach == otherCoach);
    }
}
