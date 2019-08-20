package com.zdz.test.web.tool.dingding;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

@Slf4j
public class DingDingRobotServiceImpl implements DingDingRobotService {

    private HttpClient httpclient = HttpClients.createDefault();

    @Override
    public void sendXXDingDing(String hookUrl, MarkdownMessage message) {
        sendTextMsg(hookUrl,message);
    }
    public void sendTextMsg(String hookUrl, MarkdownMessage message) {
        try {
            HttpPost httppost = new HttpPost(hookUrl);
            httppost.addHeader("Content-Type", "application/json; charset=utf-8");
            StringEntity se = new StringEntity(message.toJsonString(), "utf-8");
            httppost.setEntity(se);
            HttpResponse response = httpclient.execute(httppost);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                String result = EntityUtils.toString(response.getEntity(), "utf-8");
            }
        } catch (Exception e) {
            log.error("[DingDingRobot] [sendTextMsg] error:[{}]",e);
        }
    }
}
