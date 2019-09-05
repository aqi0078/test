package com.zdz.test.web.tool.retrofit2;

import com.alibaba.fastjson.JSON;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.Result;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.http.*;
import rx.Observable;
import rx.Subscriber;

import java.util.List;

public class TestMain {

    public interface BlogService1 {

        @POST("/blog2")
        Observable<RankConverterFactory.HttpResponse> getBlogs(@Body Blog blog);
        /*
          「20160608补充」如果需要Header的值，可以把返回值替换为
            Observable<Response<Result<List<Blog>>>>
            Observable<retrofit2.adapter.rxjava.Result<Result<List<Blog>>>> //都叫Result，真是失策
         */

    }

    public static void main(String[] args) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8080/")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(RankConverterFactory.create())
                .build();

        BlogService1 service = retrofit.create(BlogService1.class);
        Blog blog=new Blog();
        blog.setId(11L);
        service.getBlogs(blog)
                .map(blogResponse -> blogResponse.transform(BlogResponse.class))
                .subscribe(blogResponse -> {
            System.out.println(blogResponse);
                    System.out.println(blogResponse.getMerchantno());
        },error->{
                    System.out.println("===error====");
                });


    }


}
