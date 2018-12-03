package com.imooc.house.mysocketv1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @description: 客户端
 * @date: 2018-12-03 17:50
 * @author: 十一
 */
public class Client {

    public static void main(String[] args) throws IOException {
        // 访问一个服务，需要指定ip和端口
        Socket socket = new Socket("localhost",9999);
        // 读取服务端发来的数据
        InputStream inputStream = socket.getInputStream();
        // 用一个容器来存储读到的数据,Hello Client!只有13个字节，所以这个字节数组长度13刚好够用，实际上不能写死
        byte[] bytes = new byte[27];
        inputStream.read(bytes);
        // 将容器中的字节数据转换成String类型打印出来
        System.out.println(new String(bytes,"utf-8"));
        // 通过OutputStream向服务端发送数据
        OutputStream outputStream = socket.getOutputStream();
        // 通过字节来传输数据，字节是通用的
        outputStream.write(bytes);
        // 关闭
        socket.close();
        outputStream.close();
        inputStream.close();
    }
}
