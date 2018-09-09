package com.jk.studies.restful.controller;

import com.jk.studies.restful.domain.HelloCard;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HelloCardController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/hello")
    public HelloCard greeting(HttpServletRequest request, HttpServletResponse response, @RequestParam(value="name", defaultValue="World") String name) {
        return new HelloCard(counter.incrementAndGet(),
                            String.format(template, name));
    }
}
