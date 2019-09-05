package com.zdz.test.web.tool.retrofit2;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import org.apache.logging.log4j.util.Strings;
import retrofit2.Converter;
import retrofit2.Retrofit;

import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.annotation.Annotation;
import java.util.Objects;
import java.util.function.Function;
@Slf4j
public class RankConverterFactory extends Converter.Factory {

    static final String DATA = "data";
    static final String ENCRYPT_KEY = "encryptkey";
    static final String MERCHANT_ACCOUNT = "merchantno";
    static final String SIGN = "sign";


    //工厂方法，用于创建实例
    public static RankConverterFactory create() {
        return new RankConverterFactory();
    }

    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type,
                                                          Annotation[] parameterAnnotations,
                                                          Annotation[] methodAnnotations, Retrofit retrofit) {
        return value -> RequestMapper.INSTANCE.apply(value).toRequestBody();
    }
    @ToString
    @Getter
    @Value(staticConstructor = "of")
    static class HttpRequest {
        @NonNull
        @JSONField(name = MERCHANT_ACCOUNT)
        private final String merchantAccount;
        @NonNull
        private final String data;

        @NonNull
        @JSONField(name = ENCRYPT_KEY)
        private String encryptKey;

        RequestBody toRequestBody() {
            FormBody.Builder builder = new FormBody.Builder();
            builder.add(ENCRYPT_KEY, encryptKey);
            builder.add(DATA, data);
            builder.add(MERCHANT_ACCOUNT, merchantAccount);
            return builder.build();
        }
    }
    private enum RequestMapper implements Function<Object, HttpRequest> {
        INSTANCE;

        @Override
        public HttpRequest apply(Object o) {
            Object request = o;
            JSONObject wrapper = JSON.parseObject(JSON.toJSONString(request));
            if (request instanceof Blog) {
                Blog spr = (Blog) request;
                wrapper = JSON.parseObject(JSON.toJSONString(spr));
            }
            //生成签名
            String sign = "sign";
            wrapper.put(SIGN, sign);
            //生成加密的aes key
            String aesKey = "aesKey";
            String encryptKey="encryptKey";//加密aesKey
            //加密请求参数
            String json = wrapper.toJSONString();
            String data = aesKey+"=="+json;
            log.info("发送的原始内容:[{}]", json);
            return HttpRequest.of("", data, encryptKey);
        }

    }


    //response返回到本地后会被调用，这里先判断是否要拦截处理，不拦截则返回null
//判断是否处理的依据就是type参数，type就是上面接口出现的List了
    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        System.out.println("00---"+type);
//            return new RankBodyConverter<>();

            return value -> {
                try {
                    String json = value.string();
                    System.out.println("==2=json-==-"+json);
                    return HttpResponse.of(json);
//                    return json;
                } finally {
                    value.close();
                }
            };

        //如果返回null则不处理，交给别的Converter处理

    }

    // 一个Converter类，T就是上面接口中的List了
//    private static class RankBodyConverter<T> implements Converter<ResponseBody, T> {
//        RankBodyConverter() {
//        }
//        //在这个方法中处理response
//        @Override
//        public T convert(ResponseBody value) throws IOException {
//            String body = value.string();
//            System.out.println("===-==-"+body);
//            return (T)HttpResponse.of(body);
//
//        }
//    }

    @Getter
    @Setter
    @ToString
    @Value(staticConstructor = "of")
    public static class HttpResponse {

        String responseJson;

        public  <T> T transform(Class<T> clazz) {
            log.info("返回结果内容responseJson:[{}]", responseJson);
            JSONObject original = JSON.parseObject(responseJson);
            log.info("返回结果内容:[{}]", original);
            if (original.containsKey("errorcode")) {
                return original.toJavaObject(clazz);
            }
            try {
                //处理成功的请求,分别取出merchantaccount，data，encryptkey
                String encryptKey = original.getString(ENCRYPT_KEY);
                String response = original.getString(DATA);//base64
                String aesKey = "key";
                String json = "json";
                log.info("验证签名结果：{}");
                return JSON.parseObject(responseJson, clazz);
            } catch (Exception e) {
                log.warn("true exception:{}");
                throw new RuntimeException("parse yeepay response error " + responseJson);
            }
        }
    }
}