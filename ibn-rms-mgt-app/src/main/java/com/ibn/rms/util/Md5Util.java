package com.ibn.rms.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @version 1.0
 * @description:
 * @projectName：ibn-rms
 * @see: com.ibn.rms.util
 * @author： RenBin
 * @createTime：2020/9/7 16:58
 */
public class Md5Util {

    private static final Logger logger = LoggerFactory.getLogger(Md5Util.class);

    private static final String[] strHex= {"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};
    private static MessageDigest digest = null;

    static{
        try {
            digest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            logger.error("获取md5实例失败", e);
        }
    }
    public static String getMD5(String source){
        try {
            byte[] data = source.getBytes("UTF-8");
            return getMD5(data);
        } catch (UnsupportedEncodingException e) {
            logger.error("获取md5加密失败", e);
        }
        return null;
    }

    public static String getMD5(byte[] data){
        data = Md5Util.digest.digest(data);
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<data.length;i++){
            int d = data[i];
            if(d<0){
                d+=256;
            }
            int d1 = d / 16;
            int d2 = d % 16;
            sb.append(strHex[d1]+strHex[d2]);
        }
        return sb.toString();
    }
}
