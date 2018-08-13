package com.zxl.tools.exception;

import com.alibaba.fastjson.JSON;
import com.zxl.vo.ResultVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description 统一异常处理类
 * @Author ZXL
 * @Date 2018/8/13
 **/
public class ExceptionResolverUtils implements HandlerExceptionResolver{
    private static Logger logger = LoggerFactory.getLogger(ExceptionResolverUtils.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ResultVo result = new ResultVo();
        if (e instanceof MyException) {
            resolverMyException(e, result);
        } else {
            resolverOtherException(e, result);
        }
        result.setCode(0);
        result.setSuccess(false);
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        httpServletResponse.setHeader("Cache-Control", "no-cache, must-revalidate");
        try {
            httpServletResponse.getWriter().write(JSON.toJSONString(result));
        } catch (IOException e1) {
            logger.error(e1.getMessage());
        }
        logger.error("报错：{}",result.getMsg());
        return new ModelAndView();
    }

    private void resolverMyException(Exception e, ResultVo result) {
        MyException myException = (MyException) e;
        addResult(result, myException.getMsg());
    }

    private void resolverOtherException(Exception e, ResultVo result) {
        addResult(result, e.getMessage());
    }

    private void addResult(ResultVo result, String msg) {
        result.setMsg(msg);
    }
}
