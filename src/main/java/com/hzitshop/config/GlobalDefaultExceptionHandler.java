package com.hzitshop.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by xianyaoji on 2016/12/15.
 */

@ControllerAdvice
public class GlobalDefaultExceptionHandler {
        private Logger logger = LoggerFactory.getLogger(GlobalDefaultExceptionHandler.class);
        @ExceptionHandler(value = Exception.class)
        public void defaultErrorHandler(HttpServletRequest req, Exception e)  {
                //System.out.println("全局异常处理!!");
                //打印异常信息：
                //e.printStackTrace();
                //System.out.println("GlobalDefaultExceptionHandler.defaultErrorHandler()");
            System.out.println("异常");
            e.printStackTrace();

        }

}
