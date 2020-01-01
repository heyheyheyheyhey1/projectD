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
    private  static final String  UPLOAD_FILE_ROOT_PATH="/target/classes/webapp/statics/uploadfiles/";
    private  static final String  UPLOAD_FILE_REAL_PATH="/target/classes/META-INF/resources/statics/uploadfiles/";
    private static final String DOWNLOAD_FILE_PREFIX="/statics/uploadfiles/";
    public static String saveUploadfile(MultipartFile file) throws IOException {
        String suffix=file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        String name=UUID.randomUUID().toString();
        File tmpFile=new File(new File("").getAbsolutePath()+UPLOAD_FILE_ROOT_PATH+name+suffix);
        File realFile=new File(new File("").getAbsolutePath()+UPLOAD_FILE_REAL_PATH+name+suffix);
        tmpFile.createNewFile();
        realFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(tmpFile);
        fos.write(file.getBytes());
        fos = new FileOutputStream(realFile);
        fos.write(file.getBytes());
        fos.close();
        System.out.println("写入绝对路径 "+ tmpFile.getAbsolutePath());
        return DOWNLOAD_FILE_PREFIX+tmpFile.getName();
    }
    public  static  boolean isImage(MultipartFile f) throws IOException {
        try{
            Image image = ImageIO.read(f.getInputStream());
            return image != null;
        }catch (Exception e){
            System.out.println("不是图片");
            return false;
        }
    }
}
