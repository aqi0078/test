package com.zdz.test.web.controller;

import com.zdz.test.web.tool.retrofit.AARequestService;
import com.zdz.test.web.tool.retrofit.AARetrofitRequest;
import com.zdz.test.web.tool.retrofit.AARetrofitResponse;
import com.zdz.test.web.tool.retrofit.RetrofitFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RetrofitController {
    @RequestMapping("/retrofit")
    public String retrofit(){
        AARequestService aaService=RetrofitFactory.AA.retrofit.create(AARequestService.class);
        AARetrofitRequest aaRetrofitRequest=new AARetrofitRequest();
        aaRetrofitRequest.setName("AA");
        aaService.getBlogs(aaRetrofitRequest)
                .map(response->response.transform(AARetrofitResponse.class))
                .subscribe(aaResponse->{
                    System.out.println(aaResponse.getErrorCode());
                    System.out.println(aaResponse.getErrorMsg());
                },error->{
                    System.out.println("error");
                    System.out.println("");
                });

        return "hello------";
    }
}
