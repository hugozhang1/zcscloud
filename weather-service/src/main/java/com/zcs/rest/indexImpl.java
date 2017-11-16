package com.zcs.rest;


import com.zcs.generate.api.WeatherClient;
import com.zcs.generate.resource.index.model.IndexGETQueryParam;
import com.zcs.scalar.Index;
import com.zcs.scalar.QueryResult;
import com.zcs.scalar.QueryResultImpl;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response;

/**
 * Created by hugo on 2017/11/10.
 */
@Component
public class indexImpl implements Index {
    @Override
    public GetIndexResponse getIndex(String cityname, String dtype, Integer format, String key) {
        IndexGETQueryParam param =new IndexGETQueryParam(cityname==null ? "广州":cityname,"02a43d468c299077ea3286e8da80b1ab");
       String s  = WeatherClient.create().index.get(param);
        QueryResultImpl queryResult =new QueryResultImpl();
        System.out.print(s);
        queryResult.setResult(s);
        return GetIndexResponse.respond200WithApplicationJson(queryResult);
    }
}
