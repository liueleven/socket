package com.imooc.house.mysocketv3;

import java.io.*;
import java.net.Socket;

/**
 * @description: 用线程来处理
 * @date: 2018-12-03 20:10
 * @author: 十一
 */
public class MyThread implements Runnable {

    private Socket socket;

    public MyThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // 通过OutputStream发送数据
            OutputStream outputStream = socket.getOutputStream();

            File file = new File("/temp/2018最新BAT+java经典必考面试题.docx");
            System.out.println("发送文件：" + file.getName());
            // 将文件读取到内存中
            InputStream fileInput = new FileInputStream(file);
            // 用容器装字节数据
            byte[] bytes = new byte[1024];
            // 从循环读文件并发送，len = inputStream.read(bytes) 返回每次读到的字节长度
            int len = -1;
            while ((len = fileInput.read(bytes)) != -1) {
                // 通过字节来传输数据，字节在计算机中是通用的
                outputStream.write(bytes, 0, len);
            }
            outputStream.close();

            fileInput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
