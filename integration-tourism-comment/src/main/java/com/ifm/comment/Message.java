package com.ifm.comment;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

import org.springframework.stereotype.Component;


@Component
public class Message {

    public static void messagePost(String u_phone, String message){
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4Fs3HM3pZ1fuKquwNmCa", "Jc1T6yEFhoz9w2z7HlBX0qGbmYrOk4");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers",u_phone);
        request.putQueryParameter("SignName", "HongYaCave");
        request.putQueryParameter("TemplateCode", "SMS_174808256");
        request.putQueryParameter("TemplateParam", "{\"code\":"+message+"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }

}
