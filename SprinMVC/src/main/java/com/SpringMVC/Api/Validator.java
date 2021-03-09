package com.SpringMVC.Api;

import javax.servlet.http.HttpServletResponse;

public interface Validator {
    Long validate(String url,HttpServletResponse httpServletResponse);
}
