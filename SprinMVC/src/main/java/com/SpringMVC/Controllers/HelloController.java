package com.SpringMVC.Controllers;

import com.SpringMVC.Api.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class HelloController {

    @Autowired
    public HelloController(Validator validator) {
        this.validator = validator;
    }

    Validator validator;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/getURL")
    public void getUrl(HttpServletResponse httpServletResponse,@RequestParam String url) throws IOException {
        httpServletResponse.addDateHeader("dateCache",validator.validate(url, httpServletResponse) );
        httpServletResponse.sendRedirect(url);
    }

}