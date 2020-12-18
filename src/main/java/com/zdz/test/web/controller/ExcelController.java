package com.zdz.test.web.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.fastjson.JSON;
import com.zdz.test.test.excel.AccountSummaryData;
import com.zdz.test.test.excel.ExcelTest;
import com.zdz.test.test.excel.PayFeeData;
import com.zdz.test.test.tmp.A;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Date: 2020/12/18
 */
@RestController
@ResponseBody
@Slf4j
public class ExcelController {
    @RequestMapping("/excel")
    public static void  hello(HttpServletResponse response) throws Exception {
//        String spotAccountData="";
//        String contract="";
//        String futures="";
//        String wallet="";
//        String walletFee="";
//        String spotFee="";

        String spotAccountData="";
        String contract="";
        String futures="";
        String wallet="";
        String walletFee="";
        String spotFee="";

        //        ExcelTest.download(response,spotAccountData,contract,futures,wallet,walletFee,spotFee);
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("数据", "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");


        ExcelWriter excelWriter = null;
        try {
            excelWriter = EasyExcel.write(response.getOutputStream()).build();
            log.info("AccountTaskController download excelWriter build");
            //现货
            WriteSheet writeSheet0 = EasyExcel.writerSheet(0, "现货持仓数据").head(AccountSummaryData.class)
                    .build();
            List<AccountSummaryData> spotAccountDataList = JSON.parseArray(spotAccountData,AccountSummaryData.class);
            for (AccountSummaryData accountSummaryData:spotAccountDataList) {
                System.out.println("====="+accountSummaryData);
            }
            List<AccountSummaryData> spot = new ArrayList<>(spotAccountDataList);
            excelWriter.write(spot, writeSheet0);
            log.info("AccountTaskController download spotAccountDataList:{}",spotAccountDataList);
            //合约
            WriteSheet writeSheet1 = EasyExcel.writerSheet(1, "合约持仓数据").head(AccountSummaryData.class)
                    .build();
            List<AccountSummaryData> contractList =  JSON.parseArray(contract,AccountSummaryData.class);
            excelWriter.write(contractList, writeSheet1);
            log.info("AccountTaskController download contractList:{}",contractList);
            //期权
            WriteSheet writeSheet2 = EasyExcel.writerSheet(2, "期货持仓数据").head(AccountSummaryData.class)
                    .build();
            List<AccountSummaryData> futuresList =  JSON.parseArray(futures,AccountSummaryData.class);
            excelWriter.write(futuresList, writeSheet2);
            log.info("AccountTaskController download futuresList:{}",futuresList);
            //钱包
            WriteSheet writeSheet3 = EasyExcel.writerSheet(3, "钱包持仓数据").head(AccountSummaryData.class)
                    .build();
            List<AccountSummaryData> walletList =  JSON.parseArray(wallet,AccountSummaryData.class);
            excelWriter.write(walletList, writeSheet3);
            log.info("AccountTaskController download walletList:{}",walletList);
            //钱包提币手续费
            WriteSheet writeSheet4 = EasyExcel.writerSheet(4, "钱包提币手续费").head(PayFeeData.class)
                    .build();
            List<PayFeeData> walletFeeList =  JSON.parseArray(walletFee,PayFeeData.class);
            excelWriter.write(walletFeeList, writeSheet4);
            log.info("AccountTaskController download walletFeeList:{}",walletFeeList);
            //现货划转手续费
            WriteSheet writeSheet5 = EasyExcel.writerSheet(5, "现货划转手续费").head(PayFeeData.class)
                    .build();
            List<PayFeeData> spotFeeList =  JSON.parseArray(spotFee,PayFeeData.class);
            excelWriter.write(spotFeeList, writeSheet5);
            log.info("AccountTaskController download spotFeeList:{}",spotFeeList);

        } finally {
            if (excelWriter != null) {
                excelWriter.finish();
            }
        }
//        return "hello------";
    }

}
