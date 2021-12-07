package com.zdz.test.web.tool.test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

/**
 * @description: Jackson 工具类
 * @Version:
 * @author: yang
 * @create: 2018-12-25 21:32
 */
@Slf4j
public class JacksonUtil {

  private JacksonUtil() {
    throw new AssertionError();
  }

  private static ObjectMapper mapper = new ObjectMapper();

  static {
    //反序列化时忽略在 JSON 中存在但 Java 对象不存在的属性,否则会抛出异常
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    //自定义日期格式 yyyy-MM-dd HH:mm:ss
    mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
  }

  /**
   * 将 javaBean 转换为 JSON
   *
   * @param obj
   * @return
   */
  public static String toJson(Object obj) {
    try {
      return mapper.writeValueAsString(obj);
    } catch (Exception e) {
      log.error("Object to json error!", e);
      throw new RuntimeException(e);
    }
  }

  /**
   * 将 JSON 转换为 自定义的复杂类型 示例：List<Map<String,User>> listMap = Jackson.toObj(jsonStr, new
   * TypeReference<List<Map<String,User>>>(){});
   *
   * @param json
   * @param valueTypeRef
   * @return
   */
  public static <T> T toObj(String json, TypeReference<T> valueTypeRef) {
    try {
      return mapper.readValue(json, valueTypeRef);
    } catch (IOException e) {
      log.error("JSON to object error!", e);
      throw new RuntimeException(e);
    }
  }

  /**
   * 将 JSON 转换为 javaBean
   *
   * @param json
   * @param clazz
   * @return
   */
  public static <T> T jsonToObj(String json, Class<T> clazz) {
    try {
      return mapper.readValue(json, clazz);
    } catch (Exception e) {
      log.error("JSON to object error!", e);
      throw new RuntimeException(e);
    }
  }

  /**
   * 将 JSON 转换为 List<T> ,T不能带泛型 示例：List<T> list = JacksonUtil.jsonToList(jsonStr, ArrayList.class,
   * T.class);
   *
   * @param jsonStr         待转化的json串
   * @param collectionClazz 集合类型
   * @param elementClazz    对象类型
   * @return
   * @since 2.5 NOTE: was briefly deprecated for 2.6
   */
  public static <T> List<T> jsonToList(String jsonStr, Class<?> collectionClazz,
      Class<T> elementClazz) {
    JavaType javaType = mapper.getTypeFactory()
        .constructParametricType(collectionClazz, elementClazz);
    try {
      return mapper.readValue(jsonStr, javaType);
    } catch (Exception e) {
      log.error("JSON to List with generic error!", e);
      throw new RuntimeException(e);
    }
  }

  /**
   * 将 JSON 转换为 Map<K,V> ,且K、V不能带泛型 示例：Map<K,V> map = JacksonUtil.jsonToMap(jsonStr, HashMap.class,
   * K.class, V.class);
   *
   * @param jsonStr         待转化的json串
   * @param collectionClazz 集合类型
   * @param kClazz1         K 对象类型
   * @param kClazz2         V 对象类型
   * @return
   * @since 2.5 NOTE: was briefly deprecated for 2.6
   */
  public static <K, V> Map<K, V> jsonToMap(String jsonStr, Class<?> collectionClazz,
      Class<K> kClazz1, Class<V> kClazz2) {
    JavaType javaType = mapper.getTypeFactory()
        .constructParametricType(collectionClazz, kClazz1, kClazz2);
    try {
      return mapper.readValue(jsonStr, javaType);
    } catch (Exception e) {
      log.error("JSON to Map with generic error!", e);
      throw new RuntimeException(e);
    }
  }

  /**
   * 将 Map 转换为 javaBean
   *
   * @param map
   * @param clazz
   * @return
   */
  public static <T> T mapToObj(Map map, Class<T> clazz) {
    return mapper.convertValue(map, clazz);
  }

}

