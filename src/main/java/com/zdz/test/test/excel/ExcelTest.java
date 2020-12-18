package com.zdz.test.test.excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.metadata.style.WriteFont;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Date: 2020/12/18
 */
@Slf4j
public class ExcelTest {

    /**
     * 下载资产&手续费报表
     * @param response
     * @throws Exception
     */
    public static void download(HttpServletResponse response, String spotAccountData, String contract,
                         String futures, String wallet, String walletFee, String spotFee) throws Exception {
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
//            //合约
//            WriteSheet writeSheet1 = EasyExcel.writerSheet(1, "合约持仓数据").head(AccountSummaryData.class)
//                    .build();
//            List<AccountSummaryData> contractList =  JSON.parseArray(contract,AccountSummaryData.class);
//            excelWriter.write(contractList, writeSheet1);
//            log.info("AccountTaskController download contractList:{}",contractList);
//            //期权
//            WriteSheet writeSheet2 = EasyExcel.writerSheet(2, "期货持仓数据").head(AccountSummaryData.class)
//                    .build();
//            List<AccountSummaryData> futuresList =  JSON.parseArray(futures,AccountSummaryData.class);
//            excelWriter.write(futuresList, writeSheet2);
//            log.info("AccountTaskController download futuresList:{}",futuresList);
//            //钱包
//            WriteSheet writeSheet3 = EasyExcel.writerSheet(3, "钱包持仓数据").head(AccountSummaryData.class)
//                    .build();
//            List<AccountSummaryData> walletList =  JSON.parseArray(wallet,AccountSummaryData.class);
//            excelWriter.write(walletList, writeSheet3);
//            log.info("AccountTaskController download walletList:{}",walletList);
//            //钱包提币手续费
//            WriteSheet writeSheet4 = EasyExcel.writerSheet(4, "钱包提币手续费").head(PayFeeData.class)
//                    .build();
//            List<PayFeeData> walletFeeList =  JSON.parseArray(walletFee,PayFeeData.class);
//            excelWriter.write(walletFeeList, writeSheet4);
//            log.info("AccountTaskController download walletFeeList:{}",walletFeeList);
//            //现货划转手续费
//            WriteSheet writeSheet5 = EasyExcel.writerSheet(5, "现货划转手续费").head(PayFeeData.class)
//                    .build();
//            List<PayFeeData> spotFeeList =  JSON.parseArray(spotFee,PayFeeData.class);
//            excelWriter.write(spotFeeList, writeSheet5);
//            log.info("AccountTaskController download spotFeeList:{}",spotFeeList);

        } finally {
            if (excelWriter != null) {
                excelWriter.finish();
            }
        }
    }
}
