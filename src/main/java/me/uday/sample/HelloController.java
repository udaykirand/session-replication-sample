package me.uday.sample;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@RestController
public class HelloController {

    @RequestMapping(value = "/")
    public String index(@RequestParam String req, HttpSession httpSession) {
        httpSession.setAttribute("req", req);
        return "index"+httpSession.getAttribute("req");
    }

    @RequestMapping(value = "/get")
    public String get(HttpSession httpSession) {
        return "index"+httpSession.getAttribute("req");
    }

}
