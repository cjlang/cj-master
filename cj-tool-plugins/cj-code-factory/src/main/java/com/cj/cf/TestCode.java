package com.cj.cf;

import java.io.IOException;

public class TestCode {
    public static void main(String[] args) throws IOException {
            String[] tables={"cj_user_role","cj_user","cj_log","cj_perm","cj_dict","cj_dict_item","cj_menu","cj_role","cj_role_menu","cj_user_config","cj_global_config"};
            //String[] tables={"cj_global_config"};
            System.out.println("tables.lemngth="+tables.length);
            CodeFactory cf=new CodeFactory(tables);
            cf.setAuthor("lang.chaojin");
            cf.setFilePath("/Users/cjlang/Documents/IDEA/cj-master/cj-core");
            cf.setPackagePath("/com/cj/core/auto");
            cf.setDbInfo("jdbc:mysql://localhost:3306/cj-db?useUnicode=true&useSSL=false&characterEncoding=utf8","com.mysql.cj.jdbc.Driver","root","root");
            cf.deleteFolder("/Users/cjlang/Documents/IDEA/cj-master/cj-core/com/cj/core/auto");
            cf.Create();
    }
}
