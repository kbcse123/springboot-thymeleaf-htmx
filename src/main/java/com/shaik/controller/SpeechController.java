package com.shaik.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SpeechController {

    @GetMapping("/speech")
    public String speech() {
        return "speech";
    }
}
