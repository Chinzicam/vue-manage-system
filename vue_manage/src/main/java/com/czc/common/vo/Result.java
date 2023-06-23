package com.czc.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author czc
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
    private Integer code;
    private String message;
    private T list;
    private int pageTotal;

    public static<T>  Result<T> success(){
        return new Result<>(20000,"success",null, 0);
    }

    public static<T>  Result<T> success(T list,int pageTotal){
        return new Result<>(20000,"success",list,pageTotal);
    }

    public static<T>  Result<T> success(T list, String message,int pageTotal){
        return new Result<>(20000,message,list,pageTotal);
    }

    public static<T>  Result<T> success(String message){
        return new Result<>(20000,message,null,0);
    }
    public static<T>  Result<T> success(T list){
        return new Result<>(20000,"message",list,0);
    }

    public static<T>  Result<T> fail(){
        return new Result<>(20001,"fail",null,0);
    }

    public static<T>  Result<T> fail(Integer code){
        return new Result<>(code,"fail",null,0);
    }

    public static<T>  Result<T> fail(Integer code, String message){
        return new Result<>(code,message,null,0);
    }

    public static<T>  Result<T> fail( String message){
        return new Result<>(20001,message,null,0);
    }

}

