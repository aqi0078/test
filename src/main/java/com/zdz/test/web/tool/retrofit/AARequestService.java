package com.zdz.test.web.tool.retrofit;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

public interface AARequestService {


    @POST("/blog2")
    Observable<AARetrofitFactory.HttpResponse> getBlogs(@Body AARetrofitRequest aaRetrofitRequest);
}
