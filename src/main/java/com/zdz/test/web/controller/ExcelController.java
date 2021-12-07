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


        String spotAccountData="[{\"date\":\"20201227\",\"currency\":\"BTC\",\"userBalance\":0,\"sysBalance\":0.400000000000000000},{\"date\":\"20201227\",\"currency\":\"CBT\",\"userBalance\":3244.495972800000000000,\"sysBalance\":0E-18},{\"date\":\"20201227\",\"currency\":\"CMC\",\"userBalance\":34478.388873770000000000,\"sysBalance\":68523.020000000000000000},{\"date\":\"20201227\",\"currency\":\"ETH\",\"userBalance\":0.000998000000000000,\"sysBalance\":197.078649800000000000},{\"date\":\"20201227\",\"currency\":\"SBT\",\"userBalance\":20997095.327744310000000000,\"sysBalance\":0},{\"date\":\"20201227\",\"currency\":\"TRX\",\"userBalance\":368.672880000000000000,\"sysBalance\":73500.000000000000000000},{\"date\":\"20201227\",\"currency\":\"USDT\",\"userBalance\":759378.430340445840000000,\"sysBalance\":116883.908099246000000000}]";
        String contract="[{\"date\":\"20201227\",\"currency\":\"BLP\",\"userBalance\":158391.419758546000000000,\"sysBalance\":424949.382671302000000000},{\"date\":\"20201227\",\"currency\":\"BTF\",\"userBalance\":141427.346107715784238200,\"sysBalance\":940045.661066506215762100},{\"date\":\"20201227\",\"currency\":\"BTFBLP\",\"userBalance\":10107.039061949992635300,\"sysBalance\":120892.960938050007393500},{\"date\":\"20201227\",\"currency\":\"CMC\",\"userBalance\":6174.425698081887508000,\"sysBalance\":103381.544346398112492000},{\"date\":\"20201227\",\"currency\":\"DUSD\",\"userBalance\":56.300574912369000000,\"sysBalance\":50171.462146087631000000},{\"date\":\"20201227\",\"currency\":\"ETH\",\"userBalance\":0.085320300000000000,\"sysBalance\":20.659599700000000000},{\"date\":\"20201227\",\"currency\":\"LINK\",\"userBalance\":0E-18,\"sysBalance\":6000.000000000000000000},{\"date\":\"20201227\",\"currency\":\"PWM\",\"userBalance\":3.040212680000000000,\"sysBalance\":3010.033787320000000000},{\"date\":\"20201227\",\"currency\":\"SBT\",\"userBalance\":49786349.567322273513260600,\"sysBalance\":104870126.943833986484761200},{\"date\":\"20201227\",\"currency\":\"TRX\",\"userBalance\":0.500000000000000000,\"sysBalance\":200678.500000000000000000},{\"date\":\"20201227\",\"currency\":\"USDT\",\"userBalance\":20535.744938716142950000,\"sysBalance\":491340.117129361857050000},{\"date\":\"20201227\",\"currency\":\"WPT\",\"userBalance\":277826.933960630000000000,\"sysBalance\":578675.019639370000000000},{\"date\":\"20201227\",\"currency\":\"WT\",\"userBalance\":5186.010650941000000000,\"sysBalance\":112575.030749059000000000}]";
        String futures="[{\"date\":\"20201227\",\"currency\":\"\",\"userBalance\":103.423898000000000000,\"sysBalance\":0E-18}]";
        String wallet="[{\"date\":\"20201227\",\"currency\":\"BLP\",\"userBalance\":178443.738207000000000000,\"sysBalance\":-461963.581139000000000000},{\"date\":\"20201227\",\"currency\":\"BTC\",\"userBalance\":0E-18,\"sysBalance\":0.400000000000000000},{\"date\":\"20201227\",\"currency\":\"BTF\",\"userBalance\":53401.913237129000000000,\"sysBalance\":-28339.360255000000000000},{\"date\":\"20201227\",\"currency\":\"BTFBLP\",\"userBalance\":0,\"sysBalance\":0E-18},{\"date\":\"20201227\",\"currency\":\"CBT\",\"userBalance\":723.007069000000000000,\"sysBalance\":2302.992931000000000000},{\"date\":\"20201227\",\"currency\":\"CMC\",\"userBalance\":40530.903823990000000000,\"sysBalance\":-84130.921046230000000000},{\"date\":\"20201227\",\"currency\":\"DUSD\",\"userBalance\":64.957933390000000000,\"sysBalance\":-178.839293890000000000},{\"date\":\"20201227\",\"currency\":\"ETH\",\"userBalance\":51.000002200000000000,\"sysBalance\":192.126902838000000000},{\"date\":\"20201227\",\"currency\":\"LINK\",\"userBalance\":7.40000000000E-7,\"sysBalance\":-7.40000000000E-7},{\"date\":\"20201227\",\"currency\":\"LTC\",\"userBalance\":31.000000000000000000,\"sysBalance\":200.000019200000000000},{\"date\":\"20201227\",\"currency\":\"PWM\",\"userBalance\":3.785000000000000000,\"sysBalance\":-10.322000000000000000},{\"date\":\"20201227\",\"currency\":\"SBT\",\"userBalance\":692407001.430736000001000000,\"sysBalance\":305258272.313685870000000000},{\"date\":\"20201227\",\"currency\":\"TRX\",\"userBalance\":231.500000000000000000,\"sysBalance\":72934.000000000000000000},{\"date\":\"20201227\",\"currency\":\"TUSDT\",\"userBalance\":412.170000000000000000,\"sysBalance\":999773.830000000000000000},{\"date\":\"20201227\",\"currency\":\"USDT\",\"userBalance\":153804.151926201000000000,\"sysBalance\":1661872.109119760000000000},{\"date\":\"20201227\",\"currency\":\"WPT\",\"userBalance\":4573.969693000000000000,\"sysBalance\":-332824.946493000000000000},{\"date\":\"20201227\",\"currency\":\"WT\",\"userBalance\":3906.492000000000000000,\"sysBalance\":-12787.012700000000000000}]";
        String walletFee="[{\"date\":\"20201227\",\"currency\":\"BTF\",\"balance\":42.000000000000000000},{\"date\":\"20201227\",\"currency\":\"TUSDT\",\"balance\":0E-18}]";
        String spotFee="[{\"date\":\"20201227\",\"currency\":\"CBT\",\"balance\":0.000005200000000000},{\"date\":\"20201227\",\"currency\":\"USDT\",\"balance\":0.079836054800000000}]";


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
            WriteSheet writeSheet5 = EasyExcel.writerSheet(5, "现货交易手续费").head(PayFeeData.class)
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
