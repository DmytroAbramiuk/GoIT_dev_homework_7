package org.example.http;

import org.example.utils.Constants;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HttpStatusImageDownloader {
    public void downloadStatusImage(int code) throws Exception {
        String url = new HttpStatusChecker().getStatusImage(code);
        try(InputStream in = new URL(url).openStream()){
            String path = Constants.PATH + code + Constants.FORMAT;
            if(!new File(path).exists()){
                Files.copy(in, Paths.get(path));
            } else {
                System.out.println(String.format(Constants.FILE_ALREADY_EXIST_TEXT, code));
            }
        }catch (Exception e){
            throw new FileNotFoundException(String.format(Constants.NOT_FOUND, code));
        }
    }
}
