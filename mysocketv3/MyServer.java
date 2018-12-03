package com.imooc.house.mysocketv3;

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
        Socket socket = null;
        // 死循环，让服务端一直保持连接
        while (true) {
            // 等待客户端连接，一直在阻塞状态,直到客户端连接，连接成功获得一个socket
            socket = server.accept();
            System.out.println("客户端连接成功 >>>>>>>>>>>>>");

            new Thread(new MyThread(socket)).start();
            // 关闭

        }
    }
}
