package com.course.utils;

import com.course.model.InterfaceName;

import java.util.ResourceBundle;

public class ConfigFile {
    private static ResourceBundle bundle = ResourceBundle.getBundle("application");
    public static String getUrl(InterfaceName name){
        String baseURL = bundle.getString("test.url");
        String url = "";
        if(name == InterfaceName.LOGIN){
            url = bundle.getString("login.uri");
        }else if(name == InterfaceName.ADDUSERINFO){
            url = bundle.getString("addUser.uri");
        }else if(name == InterfaceName.GETUSERINFO){
            url = bundle.getString("getUserInfo.uri");
        }else if(name == InterfaceName.GETUSERLIST){
            url = bundle.getString("getUserList.uri");
        }else if(name == InterfaceName.UPDATEUSERINFO){
            url = bundle.getString("updateUserInfo.uri");
        }
        String retString = baseURL + url;
        return retString;
    }

}
