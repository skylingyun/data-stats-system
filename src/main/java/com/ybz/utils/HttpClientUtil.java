package com.ybz.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.alibaba.fastjson.JSONObject;
import com.ybz.utils.ssl.SSLClient;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
/**
 * Created by Administrator on 2017/12/16.
 */
public class HttpClientUtil {
    public String doPost(String url,Map<String,String> map,String charset){
        HttpClient httpClient = null;
        HttpPost httpPost = null;
        String result = null;
        try{
            httpClient = new SSLClient();
            httpPost = new HttpPost(url);
            //设置参数
            List<NameValuePair> list = new ArrayList<NameValuePair>();
            Iterator iterator = map.entrySet().iterator();
            while(iterator.hasNext()){
                Entry<String,String> elem = (Entry<String, String>) iterator.next();
                list.add(new BasicNameValuePair(elem.getKey(),elem.getValue()));
            }
            if(list.size() > 0){
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list,charset);
                httpPost.setEntity(entity);
            }
            HttpResponse response = httpClient.execute(httpPost);
            if(response != null){
                HttpEntity resEntity = response.getEntity();
                if(resEntity != null){
                    result = EntityUtils.toString(resEntity,charset);
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

    /**
     * 发送post请求
     * @param url 请求路径
     * @param param 请求json数据
     * @return
     */
    public static String doPost(String url,JSONObject param){
        HttpPost httpPost = null;
        String result = null;
        try{
            HttpClient client =  new SSLClient();
            httpPost = new HttpPost(url);
            if(param != null){
                StringEntity se = new StringEntity(param.toString(),"utf-8");
//                se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json; charset="));
                httpPost.setEntity(se); //post方法中，加入json数据
                httpPost.setHeader("Content-Type","application/json");
            }

            HttpResponse response = client.execute(httpPost);
            if(response != null){
                HttpEntity resEntity = response.getEntity();
                if(resEntity != null){
                    result = EntityUtils.toString(resEntity,"utf-8");
                }
            }

        }catch(Exception ex){
            ex.printStackTrace();
        }
        System.out.println("返回结果:\n"+result);
        return result;
    }
}
