package com.zdz.test.web.tool.test.interceptor;

//import com.newcoin.base.context.GatewayContext;
//import com.newcoin.common.web.model.vo.ResultVo;
//import com.newcoin.common.web.utils.JacksonUtil;
//import com.newcoin.future.server.controller.FutureQueryController;
//import com.newcoin.future.server.controller.TransferController;
//import com.newcoin.future.service.annotation.OfflineFollowRatio;
//import com.newcoin.future.service.model.entity.OfflineLeadParameter;
//import com.newcoin.future.service.service.share.OfflineLeadAccountService;
import com.zdz.test.web.controller.OfflineFollowResponseBodyController;
import com.zdz.test.web.tool.test.JacksonUtil;
import com.zdz.test.web.tool.test.annotation.OfflineFollowRatio;
import com.zdz.test.web.tool.test.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 线下喊单-返回参数放大处理
 *
 * @author lh
 */
@ControllerAdvice(assignableTypes = {OfflineFollowResponseBodyController.class})
@Slf4j
public class OfflineFollowResponseBody implements ResponseBodyAdvice {

//  @Autowired
//  private OfflineLeadAccountService offlineLeadAccountService;

//  @Value("${future.offline-follow.proportion:100}")
//  private Integer offline_proportion;

  @Override
  public boolean supports(MethodParameter returnType, Class converterType) {
    return true;
  }

  /**
   * 获取放到后新数据
   *
   * @param v 需要放大的值
   * @return BigDecimal
   */
  private BigDecimal getNewData(Object v, BigDecimal multiple) {
    BigDecimal oldData = new BigDecimal(v.toString());
    BigDecimal newData = null;
    if (oldData.compareTo(BigDecimal.ZERO) != 0) {
      newData = oldData.multiply(multiple);
    }
    return newData;
  }

  /**
   * object 结构处理
   *
   * @param fieldNames 字段名称集合
   * @param dataBase   数据
   * @return Map<String, String>
   */
  private Map<String, String> getObjectValue(String[] fieldNames, String dataBase,
                                             BigDecimal multiple) {
    Map<String, String> dataMap = JacksonUtil
            .jsonToMap(dataBase, HashMap.class, String.class, String.class);
    for (String fieldName : fieldNames) {
      if (null == dataMap.get(fieldName)) {
        continue;
      }
      BigDecimal oldData = new BigDecimal(dataMap.get(fieldName));
      if (oldData.compareTo(BigDecimal.ZERO) != 0) {
        BigDecimal newData = oldData.multiply(multiple);
        dataMap.put(fieldName, newData.stripTrailingZeros().toPlainString());
      }
    }
    return dataMap;
  }

  /**
   * List<HashMap> 结构处理
   *
   * @param fieldNames 字段名称集合
   * @param value      需要更改数据
   * @return List<HashMap>
   */
  private List<HashMap> getHashMapsValue(String[] fieldNames, String value,
                                         BigDecimal multiple) {
    List<HashMap> dataList = JacksonUtil
            .jsonToList(value, List.class, HashMap.class);
    for (String fieldName : fieldNames) {
      dataList.forEach(data -> {
        if (null == data.get(fieldName)) {
          return;
        }
        BigDecimal oldData = new BigDecimal(data.get(fieldName).toString());
        if (oldData.compareTo(BigDecimal.ZERO) != 0) {
          BigDecimal newData = oldData.multiply(multiple);
          data.put(fieldName, newData.stripTrailingZeros().toPlainString());
        }
      });
    }
    return dataList;
  }


  private List<HashMap> getHashMapsValue(String fieldName, String value,
                                         BigDecimal multiple) {
    List<HashMap> dataList = JacksonUtil
            .jsonToList(value, List.class, HashMap.class);
    dataList.forEach(data -> {
      if (null == data.get(fieldName)) {
        return;
      }
      BigDecimal oldData = new BigDecimal(data.get(fieldName).toString());
      if (oldData.compareTo(BigDecimal.ZERO) != 0) {
        BigDecimal newData = oldData.multiply(multiple);
        data.put(fieldName, newData.stripTrailingZeros().toPlainString());
      }
    });
    return dataList;
  }
  @Override
  public Object beforeBodyWrite(Object body, MethodParameter returnType,
                                MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request,
                                ServerHttpResponse response) {
    if (null == body) {
      return body;
    }
    //获得指定注解
    OfflineFollowRatio offlineFollowRatio = returnType
        .getMethodAnnotation(OfflineFollowRatio.class);

    if (offlineFollowRatio == null) {
      return body;
    }
//    Integer userId = GatewayContext.getUserId();
//    //线下带单账号集合
//    OfflineLeadParameter offlineLeadParameter = offlineLeadAccountService.offlineLeadCache
//        .getUnchecked(userId);
//    //判断是否存在
//    if (offlineLeadParameter.getId() == 0 && offlineLeadParameter.getUserId() == -1) {
//      return body;
//    }
//    if (offlineLeadParameter.getMultiple().compareTo(BigDecimal.ZERO) <= 0) {
//      return body;
//    }
//    BigDecimal multiple = offlineLeadParameter.getMultiple();
//    //需要放大字段名称
//    String[] fieldNames = offlineFollowRatio.names();
//    //json字符串转换
//    String bodyStr = JacksonUtil.toJson(body);
//    ResultVo resultVo = JacksonUtil.jsonToObj(bodyStr, ResultVo.class);
//    if (resultVo.getData() != null) {
//      String dataBase = JacksonUtil.toJson(resultVo.getData());
//      if (resultVo.getData() instanceof Map) {
//        //map结构处理
//        Map<String, Object> dataMap = JacksonUtil
//            .jsonToMap(dataBase, HashMap.class, String.class, Object.class);
//        for (String fieldName : fieldNames) {
//          dataMap.forEach((k, v) -> {
//            if (k.equals(fieldName)) {
//              BigDecimal newData = this.getNewData(v, multiple);
//              dataMap.put(k, newData == null ? v : newData.stripTrailingZeros().toPlainString());
//            } else {
//              if (v instanceof List) {
//                String valueStr = JacksonUtil.toJson(v);
//                dataMap.put(k, this.getHashMapsValue(fieldName, valueStr, multiple));
//              }
//            }
//          });
//        }
//        resultVo.setData(dataMap);
//      } else if (resultVo.getData() instanceof List) {
//        //List结构处理
//        resultVo.setData(this.getHashMapsValue(fieldNames, dataBase, multiple));
//      } else {
//        //object结构处理
//        resultVo.setData(this.getObjectValue(fieldNames, dataBase, multiple));
//      }
//    }

    BigDecimal multiple = BigDecimal.TEN;
    String[] fieldNames = offlineFollowRatio.names();
    String bodyStr = JacksonUtil.toJson(body);
    ResultVo resultVo = JacksonUtil.jsonToObj(bodyStr, ResultVo.class);
    if (resultVo.getData() != null) {
      String dataBase = JacksonUtil.toJson(resultVo.getData());
      if (resultVo.getData() instanceof Map) {
        //map结构处理
        Map<String, Object> dataMap = JacksonUtil
                .jsonToMap(dataBase, HashMap.class, String.class, Object.class);
        for (String fieldName : fieldNames) {
          dataMap.forEach((k, v) -> {
            if (k.equals(fieldName)) {
              BigDecimal newData = this.getNewData(v, multiple);
              dataMap.put(k, newData == null ? v : newData.stripTrailingZeros().toPlainString());
            } else {
              if (v instanceof List) {
                String valueStr = JacksonUtil.toJson(v);
                dataMap.put(k, this.getHashMapsValue(fieldName, valueStr, multiple));
              }
            }
          });
        }
        resultVo.setData(dataMap);
      } else if (resultVo.getData() instanceof List) {
        //List结构处理
        resultVo.setData(this.getHashMapsValue(fieldNames, dataBase, multiple));
      } else {
        //object结构处理
        resultVo.setData(this.getObjectValue(fieldNames, dataBase, multiple));
      }
    }
    System.out.println("---------"+bodyStr);
    System.out.println("----resultVo-----"+resultVo);
//    ResultVo resultVo = JacksonUtil.jsonToObj(bodyStr, ResultVo.class);
    return resultVo;
  }

}
