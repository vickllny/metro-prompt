package com.vickllny.metro.prompt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/dialog")
public class DialogController {

    @GetMapping(value = "/importList")
    public String importList(){
        return "/dialog/importList";
    }
}
