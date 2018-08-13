package com.zxl.tools;

import com.zxl.tools.exception.MyException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Encoder;

import java.security.MessageDigest;

/**
 * @Description 加密工具类
 * @Author ZXL
 * @Date 2018/8/13
 **/
public class CryptoUtils {
    private static Logger logger = LoggerFactory.getLogger(CryptoUtils.class);

    /**
     * MD5加密
     * @param str
     * @return
     */
    public static String EncoderByMd5(String str) {
        String newStr = null;
        if (StringUtils.isNoneBlank(str)) {
            try {
                MessageDigest md5 = MessageDigest.getInstance("MD5");
                BASE64Encoder base64en = new BASE64Encoder();
                //加密后的字符串
                newStr=base64en.encode(md5.digest(str.getBytes("utf-8")));
            } catch (Exception e) {
                logger.error("密码加密失败{}",e);
                throw new MyException("密码加密失败");
            }
        }
        return newStr;
    }
}
