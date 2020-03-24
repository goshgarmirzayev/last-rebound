package com.goshgarmirzayev.lastrebound.service.impl;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class ImageService {
    public String createImage(MultipartFile[] arr) {
        System.out.println(arr);
        String path = null;
        try {
            path = "\\src\\main\\resources\\static\\img\\post\\" + UUID.randomUUID().toString() + ".jpg";
            System.out.println(path);

//            Path path1 = Paths.get(path).getFileSystem().getRootDirectories();
//            byte[] strToBytes = arr[0].getBytes();
//            Files.write(path1, strToBytes);

        } catch (Exception e) {
            e.printStackTrace();
            ;
        }
        return path;
    }
}
