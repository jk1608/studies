package com.jk.studies.restful;

import org.springframework.stereotype.Service;

@Service
public class WelcomeService {

    public String getWelcomeMessage(String name) {
        StringBuilder sb = new StringBuilder("Hello ");
        sb.append(name);
        return sb.toString();
    }
}
