package com.zty.ddshop.web;

import com.zty.ddshop.common.util.FtpUtils;

public class demo {
    public static void main(String[] args) {
        boolean b = FtpUtils.downloadFile("116.62.171.71", 21, "ftpusr", "ftpusr54321", "/home/ftp", "CRJQWZ010142018032812XX01.txt", "d:/ftp");
        System.out.print(b);
    }
}
