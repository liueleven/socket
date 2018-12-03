package com.imooc.house.mysocketv2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @description: 服务端 发送文件
 * @date: 2018-12-03 17:52
 * @author: 十一
 */
public class MyServer {

    public static void main(String[] args) throws IOException {
        // 开启一个服务，默认是本机ip，但是要指定端口
        ServerSocket server = new ServerSocket(9999);
        // 死循环，让服务端一直保持连接
        // 等待客户端连接，一直在阻塞状态,直到客户端连接，连接成功获得一个socket
        Socket socket = server.accept();
        System.out.println("客户端连接成功");
        // 通过OutputStream发送数据
        OutputStream outputStream = socket.getOutputStream();

        File file = new File("/temp/2018最新BAT+java经典必考面试题.docx");
        System.out.println("发送文件："+file.getName());
        // 将文件读取到内存中
        InputStream fileInput = new FileInputStream(file);
        // 用容器装字节数据
        byte[] bytes = new byte[1024];
        // 从循环读文件并发送，len = inputStream.read(bytes) 返回每次读到的字节长度
        int len = -1;
        while ((len = fileInput.read(bytes)) != -1) {
            // 通过字节来传输数据，字节在计算机中是通用的
            outputStream.write(bytes,0,len);
        }


        // 关闭
        fileInput.close();
        server.close();
        socket.close();
        outputStream.close();
    }
}
