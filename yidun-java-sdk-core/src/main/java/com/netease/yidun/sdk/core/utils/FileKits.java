/*
 * @(#) FileKits.java 2022-06-23
 *
 * Copyright 2022 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.core.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.invoke.MethodHandles;
import java.nio.file.Files;
import java.util.List;

/**
 * @author ruicha
 * @version 2022-06-23
 */
public class FileKits {
    private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public static void clear(File file) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(file.toPath())){
            writer.write("");
            writer.flush();
        }
    }

    public static boolean rename(File file, String targetName) {
        try {
            // rename ***/oldNameFile -> ***/newNameFile
            Files.move(file.toPath(), file.toPath().resolveSibling(targetName));
            return true;
        } catch (IOException e) {
            log.error("error when rename {} to {}, cause:{}", file.getAbsolutePath(), targetName, e.getMessage(), e);
            return false;
        }
    }

    public static String readFirstLine(File file) throws IOException {
        try (FileReader reader = new FileReader(file);
             BufferedReader bf = new BufferedReader(reader)){
            return bf.readLine();
        }
    }

    public static boolean delete(File file, boolean clearWhenDeleteFail) {
        try {
            Files.deleteIfExists(file.toPath());
        }  catch (IOException e) {
            log.error("error when delete File[{}], cause:{}", file.getAbsolutePath(), e.getMessage(), e);
            // try clear
            if (clearWhenDeleteFail) {
                try {
                    clear(file);
                } catch (IOException ex) {
                    log.error("error when clear File[{}], cause:{}", file.getAbsolutePath(), e.getMessage(), e);
                    // 处理不了了
                }
            }
            return false;
        }
        return true;
    }

    public static void removeLinesFromHead(File file, int lines) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        // 刚开始就是头
        long writePos = raf.getFilePointer();

        // 指针调整到第N行
        for (int i = 0; i < lines; i++) {
            raf.readLine();
        }
        long readPos = raf.getFilePointer();

        // 4096当做缓冲区
        byte[] buf = new byte[4096];
        int n;
        while (-1 != (n = raf.read(buf))) {
            raf.seek(writePos);
            raf.write(buf, 0, n);
            readPos += n;
            writePos += n;
            raf.seek(readPos);
        }

        raf.setLength(writePos);
        raf.close();
    }

    public static void append(String[] datas, File file, long maxBytes) throws IOException {
        if (datas == null || datas.length == 0) {
            return;
        }
        if (!file.exists()) {
            file.createNewFile();
        }
        long fileSize = file.length();
        if (fileSize >= maxBytes) {
            throw new IOException("File size exceeded, limit: " + maxBytes);
        }
        long targetFileSize = fileSize;
        try (FileWriter fileWriter = new FileWriter(file, true);
              BufferedWriter bw = new BufferedWriter(fileWriter)){
            try {
                for (String data : datas) {
                    if (targetFileSize + data.length() > maxBytes) {
                        throw new IOException("File size exceeded, limit: " + maxBytes);
                    } else {
                        bw.append(data);
                        // 这里其实要计算 line separator 的大小，但是由于误差很小可接受，为了计算方便不计入在内
                        bw.newLine();
                        targetFileSize += data.length();
                    }
                }
            } finally {
                bw.flush();
            }
        }
    }

    public static void append(String[] datas, File file) throws IOException {
        if (datas == null || datas.length == 0) {
            return;
        }
        if (!file.exists()) {
            file.createNewFile();
        }
        try ( FileWriter fileWriter = new FileWriter(file, true);
              BufferedWriter bw = new BufferedWriter(fileWriter)){
            for (String data : datas) {
                bw.append(data);
                bw.newLine();
            }
            bw.flush();
        }
    }

    public static void append(List<String> datas, File file) throws IOException {
        if (datas == null || datas.isEmpty()) {
            return;
        }
        if (!file.exists()) {
            file.createNewFile();
        }
        try ( FileWriter fileWriter = new FileWriter(file, true);
              BufferedWriter bw = new BufferedWriter(fileWriter)){
            for (String data : datas) {
                bw.append(data);
                bw.newLine();
            }
            bw.flush();
        }
    }
}
