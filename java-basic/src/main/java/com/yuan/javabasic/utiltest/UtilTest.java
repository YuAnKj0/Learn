package com.yuan.javabasic.utiltest;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Objects;

/**
 * @author Ykj
 * @date 2023/1/13/15:36
 * @apiNote
 */
public class UtilTest {
   public static void main(String[] args) {
      try {
         ArgsGetHttp();
      } catch (Exception e) {
         throw new RuntimeException(e);
      }
   }
   
   /**
    * @author Ykj
    * @throws IOException
    * Get请求的无参
    */
   public static void noArgsGetHttp() throws IOException {
      //定义httpclient
      CloseableHttpClient httpClient = HttpClientBuilder.create().build();
      //创建get请求
      HttpGet httpGet = new HttpGet("http://www.baidu.com");
      //定义返回结果
      CloseableHttpResponse execute=null;
      //执行请求
      execute = httpClient.execute(httpGet);
      HttpEntity entity = execute.getEntity();
      //Header encoding = entity.getContentEncoding();
      System.out.println("响应状态为："+execute.getStatusLine());
      if (Objects.nonNull(entity)) {
         System.out.println("响应内容长度为："+entity.getContentLength());
         
         System.out.println("响应内容为："+EntityUtils.toString(entity));
         //System.out.println("encoding="+encoding);
      }
      //释放资源
      if (httpClient!=null){
         httpClient.close();
      }
      if (execute!=null){
         execute.close();
      }
      
   }
   public static void ArgsGetHttp() throws URISyntaxException, IOException {
      CloseableHttpClient httpClient = HttpClientBuilder.create().build();
      //创建参数列表
      ArrayList<NameValuePair> valueParamsList  = new ArrayList<>();
      valueParamsList.add(new BasicNameValuePair("studentId","1"));
      //创建请求对应的URI
      URI uri = new URIBuilder()
              .setScheme("http")
              .setHost("localhost")
              .setPath("/getStudentInfo")
              .setParameters(valueParamsList).build();
      //根据URI创建get请求
      HttpGet httpGet = new HttpGet(uri);
      CloseableHttpResponse execute=null; 
      execute = httpClient.execute(httpGet);
      // 获取返回值
      HttpEntity entity = execute.getEntity();
      System.out.println("响应状态为:" + execute.getStatusLine());
      if (Objects.nonNull(entity)) {
         System.out.println("响应内容长度为:" + entity.getContentLength());
         System.out.println("响应内容为:" + EntityUtils.toString(entity));
      }
      // 释放资源
      if (httpClient != null) {
         httpClient.close();
      }
      if (execute != null) {
         execute.close();
      }
      
   
   }
   
   
   
}
