package com.yinlian.core.util;

import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * map与bean转化或List<Map>转List<Bean>
 *
 */
public class BeanUtils {
    /**
     * map转bean
     * @param srcObj map
     * @param clazz 目标转化类
     * @param <T>
     * @return
     */
    public static <T> T objToBean(Object srcObj, Class<T> clazz) {
        String json = JSON.toJSONString(srcObj);
        return JSON.parseObject(json, clazz);
    }

    /**
     * List<Map>转List<Bean>
     * @param srcListObj list<map>
     * @param clazz 目标转化类
     * @param <T>
     * @return
     */
    public static <T> List<T> listToBean(Object srcListObj, Class<T> clazz) {
        String json = JSON.toJSONString(srcListObj);
        return JSON.parseArray(json, clazz);
    }
}
