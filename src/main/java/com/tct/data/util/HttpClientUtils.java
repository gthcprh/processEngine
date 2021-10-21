package com.tct.data.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.sun.org.apache.xml.internal.serialize.OutputFormat.Defaults.Encoding;

/**
 * @Author: Hannibal
 * @Date: 2021/10/19 19:27
 * @Version 1.0
 * @description
 */
@Slf4j
public class HttpClientUtils {

    public final static String POST = "post";

    public final static String GET = "get";

    public static Result doPost(String url, String header, String body) {

        return post(url, getHeader(header), body);
    }

    public static Result doGet(String url, String header) {
        return get(url, getHeader(header));
    }

    /**
     * String转map
     *
     * @param header
     * @return
     */
    public static Map getHeader(String header) {
        Map<String, String> headerMap = new HashMap<>(16);
        List<String> list = JSONArray.parseArray(header, String.class);
        if (!CollectionUtils.isEmpty(list)) {
            list.forEach(str -> {
                JSONObject jsonObject = JSONObject.parseObject(str);
                headerMap.put(jsonObject.get("key").toString(), jsonObject.get("value").toString());
            });
        }
        return headerMap;
    }

    /**
     * 模拟Http Get请求(设置header)
     *
     * @param urlStr    请求路径
     * @param headerMap header参数
     * @return json字符
     * @throws Exception
     */
    public static Result get(String urlStr, Map<String, String> headerMap) {
        Result result = new Result();
        CloseableHttpClient httpClient = null;
        // 响应模型
        CloseableHttpResponse response = null;
        try {
            httpClient = HttpClientBuilder.create().build();
            // 创建Get请求
            HttpGet httpGet = new HttpGet(urlStr);
            if (null != headerMap && !headerMap.isEmpty()) {
                for (Map.Entry<String, String> entry : headerMap.entrySet()) {
                    httpGet.addHeader(entry.getKey(), entry.getValue());
                }
            }
            // 由客户端执行(发送)Get请求
            response = httpClient.execute(httpGet);
            // 从响应模型中获取响应实体
            HttpEntity responseEntity = response.getEntity();
            int statusCode = response.getStatusLine().getStatusCode();
            result.setResultCode(statusCode);
            if (!ObjectUtils.isEmpty(responseEntity)) {
                result.setMessage(EntityUtils.toString(responseEntity));
            }
            return result;
        } catch (Exception e) {
            log.error("发送Post请求出现异常，message：", e.getMessage());
            return ResultGenerator.fail(e.getMessage());
        } finally {
            IOUtils.closeQuietly(httpClient, response);
        }
    }

    /**
     * 模拟Http Post请求(设置header和body)
     *
     * @param urlStr    请求路径
     * @param headerMap header参数
     * @param bodyData  body参数
     * @return json字符
     * @throws Exception
     */
    public static Result post(String urlStr, Map<String, String> headerMap, String bodyData) {
        Result result = new Result();
        CloseableHttpClient httpClient = null;
        // 响应模型
        CloseableHttpResponse response = null;
        try {
            // 创建Post请求
            HttpPost httpPost = new HttpPost(urlStr);
            //设置header
            if (null != headerMap && !headerMap.isEmpty()) {
                for (Map.Entry<String, String> entry : headerMap.entrySet()) {
                    httpPost.addHeader(entry.getKey(), entry.getValue());
                }
            }
            //设置请求体
            if (!ObjectUtils.isEmpty(bodyData)) {
                StringEntity se = new StringEntity(bodyData, Encoding);
                se.setContentType("application/json");
                httpPost.setEntity(se);
            }
            httpClient = HttpClientBuilder.create().build();
            // 由客户端执行(发送)Post请求
            response = httpClient.execute(httpPost);
            // 从响应模型中获取响应实体
            HttpEntity responseEntity = response.getEntity();
            int statusCode = response.getStatusLine().getStatusCode();
            result.setResultCode(statusCode);
            if (!ObjectUtils.isEmpty(responseEntity)) {
                result.setMessage(EntityUtils.toString(responseEntity));
            }
            return result;
        } catch (Exception e) {
            log.error("发送Post请求出现异常，message：", e.getMessage());
            return ResultGenerator.fail(e.getMessage());
        } finally {
            IOUtils.closeQuietly(httpClient, response);
        }
    }

}
