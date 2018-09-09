package com.jk.studies.restful.controller;

import com.jk.studies.restful.WelcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @Autowired
    private WelcomeService welcomeService;

    @RequestMapping("/welcome")
    @ResponseBody
    public String welcome(@RequestParam(value="name", defaultValue="World") String name) {
        return welcomeService.getWelcomeMessage(name);
    }

}
