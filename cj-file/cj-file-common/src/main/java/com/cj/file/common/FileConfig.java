package com.cj.file.common;

import com.google.common.collect.Sets;
import lombok.Data;

import java.util.Set;

@Data
public class FileConfig {
    private String basePath;
    private String urlPrefix;
    private Set<String> allowedFileExtensionName = Sets.newHashSet(new String[]{"txt", "pdf", "xls", "xlsx", "csv", "doc", "docx", "png", "jpg", "gif", "mp4", "mov", "mp3", "rar", "zip", "ppt"});
}
