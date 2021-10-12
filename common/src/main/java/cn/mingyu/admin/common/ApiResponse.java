package cn.mingyu.admin.common;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author yimingyu
 * @date 2021/09/26
 */
@Data
@NoArgsConstructor
public class ApiResponse<T> implements Serializable {

    private static final long serialVersionUID = -4903526894814733093L;

    private boolean success;
    private int code;
    private String errMessage;
    private T data;
    private Paging paging;
    private long timestamp = System.currentTimeMillis();

    public static <T> ApiResponse<T> buildSuccess(){
        ApiResponse<T> apiResponse = new ApiResponse<>();
        apiResponse.setSuccess(true);
        return apiResponse;
    }

    public static <T> ApiResponse<T> buildSuccess(T data){
        ApiResponse<T> apiResponse = new ApiResponse<>();
        apiResponse.setSuccess(true);
        apiResponse.setData(data);
        return apiResponse;
    }

    public static <T> ApiResponse<T> buildFail(){
        ApiResponse<T> apiResponse = new ApiResponse<>();
        apiResponse.setSuccess(false);
        return apiResponse;
    }

    public static <T> ApiResponse<T> buildFail(String errMessage){
        ApiResponse<T> apiResponse = new ApiResponse<>();
        apiResponse.setSuccess(false);
        apiResponse.setCode(0);
        apiResponse.setErrMessage(errMessage);
        return apiResponse;
    }

    public static <T> ApiResponse<T> buildFail(int errorCode, String errMessage){
        ApiResponse<T> apiResponse = new ApiResponse<>();
        apiResponse.setSuccess(false);
        apiResponse.setCode(errorCode);
        apiResponse.setErrMessage(errMessage);
        return apiResponse;
    }

    public static <T> ApiResponse<T> buildSuccess(T data, Paging paging){
        ApiResponse<T> apiResponse = new ApiResponse<>();
        apiResponse.setSuccess(true);
        apiResponse.setData(data);
        apiResponse.setPaging(paging);
        return apiResponse;
    }



}
