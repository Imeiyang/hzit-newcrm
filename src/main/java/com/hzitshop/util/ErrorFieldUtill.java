package com.hzitshop.util;

import org.springframework.validation.FieldError;

import java.util.List;

/**
 * Created by xianyaoji on 2017/7/15.
 */
public class ErrorFieldUtill {
    public static String  error(List<FieldError>  list){
        StringBuilder sb = new StringBuilder();
       if(list!= null && list.size() >0){
         for(FieldError fe : list){
             sb.append(fe.getDefaultMessage()+",");
         }
       }else{
           sb.append("服务器内部错误!");
       }

       return sb.toString().replaceFirst(",$","");
    }
}
