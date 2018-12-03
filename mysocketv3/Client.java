package com.imooc.house.mysocketv3;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @description: 客户端 接收文件
 * @date: 2018-12-03 17:50
 * @author: 十一
 */
public class Client {

    public static void main(String[] args) throws IOException {
        // 访问一个服务，需要指定ip和端口
        Socket socket = new Socket("localhost",9999);
        // 读取服务端发来的数据
        InputStream inputStream = socket.getInputStream();

        // 用容器装字节数据
        byte[] bytes = new byte[1024];
        OutputStream fileOut = new FileOutputStream("/temp/2018最新BAT+java经典必考面试题-3.docx");
        // 循环读文件并写入到磁盘,len = inputStream.read(bytes) 返回每次读到的字节长度
        int len = -1;
        while ((len = inputStream.read(bytes)) != -1) {
            // 通过字节来传输数据，字节在计算机中是通用的
            fileOut.write(bytes,0,len);
        }
        System.out.println("读文件完成：>>>>>>>>>>>>>>");
        // 关闭
        socket.close();
        fileOut.close();
        inputStream.close();
    }
}
