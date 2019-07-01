package com.ecms.cums.util;  
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;  
  
  
public class FileUpload{  
  
    //文件上传  
    public static String uploadFile(MultipartFile file, HttpServletRequest request) throws IOException {  
        String fileName = file.getOriginalFilename(); 
        String extName = fileName.substring(fileName.lastIndexOf("."));//.jpg
        String uuid = UUID.randomUUID().toString().replace("-", "");
        //String path="E://wangylGuoAn/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/galy-worker/images";  
        //String path="/opt/tomcat_airplane/webapps/h5/images";
        String path="/opt/tomcat_tour/webapps/h5/images";
        File tempFile = new File(path, new Date().getTime() + String.valueOf(uuid+extName));  
        if (!tempFile.getParentFile().exists()) {  
            tempFile.getParentFile().mkdir();  
        }  
        if (!tempFile.exists()) {  
            tempFile.createNewFile();  
        }  
        file.transferTo(tempFile);  
        return "images/" + tempFile.getName();  
    }  
  
}  