package com.jhx.projectd.utils;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.jsp.JspEngineInfo;
import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

public class UploadFileUtils {
    private static String  UPLOAD_FILE_ROOT_PATH="\\target\\classes\\webapp\\statics\\uploadfile\\";
    public static String saveUploadfile(MultipartFile file) throws IOException {
        String suffix=file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        System.out.println(UPLOAD_FILE_ROOT_PATH);
        File tmpFile=new File(new File("").getAbsolutePath()+UPLOAD_FILE_ROOT_PATH+UUID.randomUUID().toString()+suffix);
        if (!tmpFile.exists()){
            tmpFile.createNewFile();
        }
        file.transferTo(tmpFile);
        return "/statics/uploadfile/"+tmpFile.getName();
    }
    public  static  boolean isImage(MultipartFile f) throws IOException {
        try{
            Image image = ImageIO.read(f.getInputStream());
            return image == null;
        }catch (Exception e){
            System.out.println("不是图片");
            return false;
        }
    }
}
