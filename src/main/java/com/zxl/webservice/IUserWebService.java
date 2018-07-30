package com.zxl.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * 发布用户接口
 */
@WebService(targetNamespace="http://impl.webservice.zxl.com/")
public interface IUserWebService {
    /**
     * 通过主键查询用户名
     * @param id
     * @return
     */
    @WebMethod
    String getUserNameById(@WebParam(name = "id") String id);
}
