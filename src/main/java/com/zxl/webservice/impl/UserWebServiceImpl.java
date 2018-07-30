package com.zxl.webservice.impl;

import com.zxl.webservice.IUserWebService;

import javax.jws.WebService;

@WebService(targetNamespace="http://impl.webservice.zxl.com/")
public class UserWebServiceImpl implements IUserWebService {

    @Override
    public String getUserNameById(String id) {
        return "张三";
    }
}
