package com.cj.file.common;

import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public interface IFileService {
    Map<String,Object> upload(MultipartFile file, Map<String,Object> entity, HttpServletResponse response, HttpServletRequest request);
    void download(Map<String, Object> fileInfo, HttpServletResponse response, HttpServletRequest request);
}
