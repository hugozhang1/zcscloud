package com.zcs.service;

import com.zcs.generate.api.WeatherClient;
import com.zcs.generate.resource.index.Index;
import com.zcs.generate.resource.index.model.IndexGETQueryParam;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import static org.junit.Assert.*;

/**
 * Created by hugo on 2017/11/3.
 */
@SpringBootTest
public class WeatherServiceTest {

    @Test
    public void testIndex() throws UnsupportedEncodingException {
       Index index = WeatherClient.create().index;
      String abc=  URLEncoder.encode("苏州","utf-8");
        IndexGETQueryParam queryParameters =new IndexGETQueryParam(abc,"02a43d468c299077ea3286e8da80b1ab");
        System.out.println(abc);
//http://v.juhe.cn/weather/index?format=2&cityname=%E8%8B%8F%E5%B7%9E&key=02a43d468c299077ea3286e8da80b1ab
       String  string= index.get(queryParameters);
       System.out.println(string);
    }
}