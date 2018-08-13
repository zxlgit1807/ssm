package com.zxl.tools;

import com.zxl.tools.exception.MyException;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description 加密工具类
 * @Author ZXL
 * @Date 2018/8/13
 **/
public class CryptoUtils {
    private static Logger logger = LoggerFactory.getLogger(CryptoUtils.class);
    /**
     * MD5加密(通过用户名加盐)
     * @param str
     * @return
     */
    public static String EncoderByMd5(String loginName, String str) {
        String newStr = null;
        if (StringUtils.isNoneBlank(str)) {
            try {
                newStr = new SimpleHash("MD5",str.getBytes(), loginName, 1).toHex();
            } catch (Exception e) {
                logger.error("密码加密失败{}",e);
                throw new MyException("密码加密失败");
            }
        }
        return newStr;
    }
}
