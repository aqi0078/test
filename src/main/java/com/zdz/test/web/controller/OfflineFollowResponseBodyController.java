package com.zdz.test.web.controller;

import com.zdz.test.web.tool.test.annotation.OfflineFollowRatio;
import com.zdz.test.web.tool.test.vo.Offline;
import com.zdz.test.web.tool.test.vo.ResponseVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Date: 2021/4/21
 */
@RestController
public class OfflineFollowResponseBodyController {



    @RequestMapping("/helloOffline")
    @OfflineFollowRatio(names = {"amount"})
    public ResponseVo<List<Offline>> hello(){
        List list = new ArrayList();
        Offline offline = new Offline();
        offline.setAmount(BigDecimal.ONE);
        list.add(offline);
        Offline offline1 = new Offline();
        offline1.setAmount(BigDecimal.TEN);
        list.add(offline1);

        return ResponseVo.success(list);
    }
}
