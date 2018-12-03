package com.imooc.house.mysocketv1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @description: 服务端
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
        String msg = "Hello Client! 爸爸，👨";
        // 通过字节来传输数据，字节是通用的
        outputStream.write(msg.getBytes());
        // 获取客户端传输过来的数据
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[27];
        inputStream.read(bytes);
        // 将容器中的字节数据转换成String类型打印出来
        System.out.println(new String(bytes, "utf-8"));
        // 关闭
        server.close();
        socket.close();
        outputStream.close();
        inputStream.close();
    }
}
