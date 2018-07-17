package com.zxl.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

@Controller
@RequestMapping("/userController")
public class UserController {

    @RequestMapping("/downFile")
    public ResponseEntity<byte[]> downFile() {
        ResponseEntity<byte[]> response= null;
        try {
            InputStream in=new FileInputStream(new File("D:\\aa1.xlsx"));//将该文件加入到输入流之中
            byte[] body=null;
            body=new byte[in.available()];// 返回下一次对此输入流调用的方法可以不受阻塞地从此输入流读取（或跳过）的估计剩余字节数
            in.read(body);//读入到输入流里面

            String fileName=new String("aaa".getBytes("gbk"),"iso8859-1");//防止中文乱码
            HttpHeaders headers=new HttpHeaders();//设置响应头
            headers.add("Content-Disposition", "attachment;filename="+fileName);
            HttpStatus statusCode = HttpStatus.OK;//设置响应吗
            response=new ResponseEntity<byte[]>(body, headers, statusCode);

        }catch (Exception e) {

        }
        return response;

    }
}
