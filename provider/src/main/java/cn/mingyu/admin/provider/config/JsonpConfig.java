package cn.mingyu.admin.provider.config;

import cn.mingyu.admin.provider.controller.admin.user.UserController;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.regex.Pattern;

/**
 * @author yimingyu
 * @date 2021/10/11
 */
@ControllerAdvice(basePackageClasses = {UserController.class})
public class JsonpConfig implements ResponseBodyAdvice<Object> {

    // 指定匹配规则
    private static final String JSONP_REGEX = "[a-zA-Z0-9_\\.]*";

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        HttpServletRequest servletRequest = ((ServletServerHttpRequest) request).getServletRequest();
        HttpServletResponse servletResponse = ((ServletServerHttpResponse) response).getServletResponse();
        String callback = servletRequest.getParameter("callback");
        if (!StringUtils.isEmpty(callback) && isJsonp(callback)){
            JSONPObject jsonp = new JSONPObject(callback);
            String text = JSONObject.toJSONString(body, new SerializerFeature[0]);
            String jsonpText = new StringBuilder(jsonp.getFunction()).append("(").append(text).append(")").toString();
            byte [] bytes = jsonpText.getBytes(Charset.forName("utf-8"));
            OutputStream outputStream = null;
            try {
                outputStream = servletResponse.getOutputStream();
                outputStream.write(bytes);
                outputStream.flush();
                outputStream.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return body;
    }

    public boolean isJsonp(String str){
        return Pattern.compile(JSONP_REGEX).matcher(str).matches();
    }
}
