package com.zdz.test.web.tool.retrofit;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

public class RetrofitFactory {
    public static class AA{
        public static Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8089/")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(AARetrofitFactory.create())
                .build();
    }

}
