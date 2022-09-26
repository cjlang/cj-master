package com.cj.document;

import cn.smallbun.screw.core.engine.EngineFileType;

public class TestCode {
    public static void main(String[] args) {
        documentGeneration doc=new documentGeneration();
//        doc.setDriverClassName("com.mysql.jdbc.Driver");
//        doc.setDbUrl("jdbc:mysql://10.60.49.24:3306/xfappdata?allowMultiQueries=true&useUnicode=true&characterEncoding=UTF-8&useSSL=false");
//        doc.setUsername("xfappuser");
//        doc.setPassword("KDGCxfapp_123456");
//        doc.setDocType(EngineFileType.MD);
        doc.createDocument();
    }
}
