package com.cj.file.impl;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.cj.common.exception.CJException;
import com.cj.file.common.FileConfig;
import com.cj.file.common.IFileService;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.apache.velocity.shaded.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class CJFileService implements IFileService {

    @Value("${cj.file.basePath:/home/file}")
    private String basePath;

    @Value("${cj.file.allowedFileExtensionName:txt, pdf, xls, xlsx, csv, doc, docx, png, jpg, gif, mp4, mov, mp3, rar, zip, ppt}")
    private String allowedFileExtensionName;

    @Value("${cj.file.urlPrefix}")
    private String urlPrefix;


    @Override
    public Map<String, Object> upload(MultipartFile file, Map<String, Object> entity, HttpServletResponse response, HttpServletRequest request) {
        String originalFilename = file.getOriginalFilename();
        String extension = FilenameUtils.getExtension(originalFilename);
        Map<String, Object> fileInfo=new HashMap<String,Object>();
        if (!allowedFileExtensionName.contains(extension)) {
            throw new CJException(-1,"不支持的文件类型");
        } else {
            String id = IdWorker.getIdStr();
            String newFileName = id + "." + extension;
            String destPath = basePath + File.separator + newFileName;
            long size = file.getSize();

            try {
                File dest = new File(destPath);
                file.transferTo(dest);
            } catch (Exception var15) {
                throw new CJException(-1,"文件上传失败");
            }
            fileInfo.put("OriginalName",originalFilename);
            fileInfo.put("NewName",newFileName);
            fileInfo.put("Path",originalFilename);
            fileInfo.put("size",size);
            fileInfo.put("extension",extension);
            fileInfo.put("Url",urlPrefix + "/" + newFileName);
        }
        return fileInfo;
    }

    @Override
    public void download(Map<String, Object> fileInfo, HttpServletResponse response, HttpServletRequest request) {
        if (fileInfo.get("fileId") == null) {
            response.setStatus(HttpStatus.NOT_FOUND.value());
        } else {
            response.setContentType("application/x-msdownload");
            response.setContentType("multipart/form-data");
            response.setHeader("Access-Control-Expose-Headers", "filename");

            try {
                response.setHeader("filename", URLEncoder.encode(fileInfo.get("originalName").toString(), "UTF-8"));
                response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(fileInfo.get("originalName").toString(), "UTF-8"));
            } catch (UnsupportedEncodingException var14) {
            }

            String filePath = fileInfo.get("path").toString() + File.separator + fileInfo.get("newName").toString();
            File file = new File(filePath);
            if (!file.exists()) {
                response.setStatus(HttpStatus.NOT_FOUND.value());
            } else {
                try {
                    InputStream is = new FileInputStream(file);
                    IOUtils.copy(is, response.getOutputStream());
                    is.close();
                    response.getOutputStream().close();
                } catch (Exception var12) {
                    response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
                } finally {
                   // this.sysFileService.updateDownloadCount(1, fileId);
                }

            }
        }
    }
}
