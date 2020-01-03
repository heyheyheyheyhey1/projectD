package com.jhx.projectd.utils;

import org.springframework.web.multipart.MultipartFile;
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;
import java.util.List;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class UploadFileUtils {
    private static final String UPLOAD_FILE_ROOT_PATH="/target/classes/webapp/statics/uploadfiles/";
    private static final String UPLOAD_FILE_REAL_PATH="/target/classes/META-INF/resources/statics/uploadfiles/";
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
    public static boolean isAPK(MultipartFile f) throws  IOException{
        File tmpFile=new File("tmp.apk");
        if (!tmpFile.exists()) tmpFile.createNewFile();
        try{
            System.out.println("原始文件大小"+f.getSize());
            FileOutputStream fos  = new FileOutputStream(tmpFile);
            fos.write(f.getBytes());
            System.out.println("boom1 "+ tmpFile.length());
            System.out.println(tmpFile.getAbsolutePath());
            System.out.println("boom2");
            ZipFile zipFile = new ZipFile(tmpFile);
            System.out.println("boom3");
            ZipEntry entry = new ZipEntry("AndroidManifest.xml");
            System.out.println("boom4");
            InputStream is =null;
            is= zipFile.getInputStream(entry);
            if (is == null){
                System.out.println("没有入口");
               return false;
            }
            System.out.println("判断结束 这是一个APK文件");
            return true;
        }catch (Exception e){
            System.out.println("直接异常");
            return false;
        }
    }
}
