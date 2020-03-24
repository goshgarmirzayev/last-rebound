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
        String randomName = "";
        try {
            randomName = UUID.randomUUID().toString() + ".jpg";
            path = System.getProperty("user.dir") + "/src/main/resources/static/img/post/";
            Path uploadedFile = Paths.get(path, randomName);
            Files.write(uploadedFile, arr[0].getBytes());

        } catch (Exception e) {
            e.printStackTrace();

        }
        return "/img/post/" + randomName;
    }
}
