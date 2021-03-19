package com.SpringMVC.Services;

import com.SpringMVC.Api.Repository;
import com.SpringMVC.Api.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

@Component
public class Validatorlmp implements Validator {
/*
    Links validator
 */

    @Autowired
    public Validatorlmp(Repository repository) {
        this.repository = repository;
    }

    Repository repository;

    public Long validate(String url,HttpServletResponse httpServletResponse){

        Long dateFromStorage=repository.getUrl(url);
        if(dateFromStorage!=null){//if not null
            return dateFromStorage;//then return cached date
        }

        if(httpServletResponse.getStatus()>199 || httpServletResponse.getStatus()<300){ // if valid status
            repository.addToStorage(url,System.currentTimeMillis()); // add to storage cached date
        }
        return System.currentTimeMillis(); // else if invalid req return current
    }

}
