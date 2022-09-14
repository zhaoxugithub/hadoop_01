package com.test;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Copyright (C), 2017-2021, 赵旭
 * Author: serendipity
 * Date: 2021/8/19 下午5:06
 * FileName: CrawlUtils
 * Description: com.test
 * RandomAccess 接口表示具有随机访问的能力
 */
public class CrawlUtils {


    public static String getAppName(String id) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://zhushou.360.cn/detail/index/soft_id/" + id);
        CloseableHttpResponse response = client.execute(httpGet);
        System.out.println(EntityUtils.toString(response.getEntity()).split("<title>")[1]);
        return null;
    }

    public static int getCommentCount(int appId) throws IOException, JSONException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet getJson = new HttpGet("http://comment.mobilem.360.cn/comment/getComments?baike=" + appId + "&level=0&start=0&count=1&fm=home_jingjia_3&m=c1804fc5ca4ded8293acd1151efaf3db&m2=61f3c1e4d105b55aff323b20a8136c4e&v=3.2.50&re=1&nt=1&ch=493041&os=21&model=MX4+Pro&sn=4.66476154040931&cu=m76&ca1=armeabi-v7a&ca2=armeabi&ppi=1536x2560&cpc=1&startCount=4");
        CloseableHttpResponse response = client.execute(getJson);
        String json = EntityUtils.toString(response.getEntity());
        JSONObject jsonObject = new JSONObject(json);
        return jsonObject.getJSONObject("data").getInt("total");
    }

    public static void main(String[] args) {
        try {
//          getAppName("1936882");
            int commentCount = getCommentCount(1936882);
            System.out.println(commentCount);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
