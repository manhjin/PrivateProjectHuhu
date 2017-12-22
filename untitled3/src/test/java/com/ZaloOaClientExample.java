package test.java.com;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.vng.zalo.sdk.APIConfig;
import com.vng.zalo.sdk.APIException;
import com.vng.zalo.sdk.SendMessageReponse;
import com.vng.zalo.sdk.UploadResponse;
import com.vng.zalo.sdk.ZaloUser;
import com.vng.zalo.sdk.oa.ZaloOaClient;
import com.vng.zalo.sdk.oa.ZaloOaInfo;
import com.vng.zalo.sdk.oa.message.MsgAction;
import com.vng.zalo.sdk.oa.message.MsgGif;
import com.vng.zalo.sdk.oa.message.MsgImage;
import com.vng.zalo.sdk.oa.message.MsgLink;
import com.vng.zalo.sdk.oa.message.MsgStatus;
import com.vng.zalo.sdk.oa.message.OpenCallAction;
import com.vng.zalo.sdk.oa.message.OpenInAppAction;

import java.io.BufferedReader;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author nghiadc
 */
public class ZaloOaClientExample {
    public static void main(String[] args) {
        ZaloUser user = new ZaloUser();
        Gson gson = new Gson();
        //Offical Account
        /*
        *Hàm khai báo Offical Account
        * OAID: id của offical Account
        * secrect: mã bí mật của OA API
        * */

        String oaid = "3093468968868500357";
        // zalo for developer
        String secrect = "45d724RKDL25pKu1LJ1R";
        ZaloOaInfo info = new ZaloOaInfo(Long.parseLong(oaid), secrect); // zalo for developer
        System.out.println(info);
        ZaloOaClient oaClient = new ZaloOaClient(info);

//        String templateId = "2c5599bda5f84ca615e9";
        JsonObject data = new JsonObject();
        data.addProperty("content", "Chào bạn, Chúc bạn một ngày vui vẻ!");


        System.out.println("input số lượng khách hàng");
        Scanner sc = new Scanner(System.in);
        int cusnum = Integer.parseInt(sc.nextLine());
        for (int i = 1; i<= cusnum;i++){

            try {
                // số điện thọa người dùng
                //String userid = "01664708402";
                String userid = sc.nextLine();
                JsonObject profile = oaClient.getProfile(Long.parseLong(userid));
                String jsonOject = gson.toJson(user);
                 user= gson.fromJson(jsonOject,ZaloUser.class);
                System.out.println(user.getUserGender());
                System.out.println(profile);
                String uid = "363136499894508119";
                String message = "đây là bản test";
                JsonObject ret = oaClient.sendTextMessage(Long.parseLong(uid), message);
                    System.out.println(ret);
            } catch (APIException e) {
                // error
                System.out.println("API Error code : " + e.getCode());
                System.out.println("API Error message : " + e.getMessage());
            }
        }



    }
}
