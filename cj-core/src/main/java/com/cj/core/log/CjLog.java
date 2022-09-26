package com.cj.core.log;

import com.cj.config.CjLogConfig;
import com.cj.core.auto.bllservice.CjLogBllService_;
import com.cj.core.auto.dto.CjLogDTO;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * 日志管理
 */
@Service
public class CjLog {

    @Autowired
    CjLogBllService_ cjLogBllService_;
    /**
     * 只打印，不存数据库
     * @param info
     */
    public void log(String info) {
        Calendar calendar= Calendar.getInstance();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss:SSS");
        CjLogConfig.log(dateFormat.format(calendar.getTime())+"---业务模块日志信息："+info);
    }

    /**
     * 只存数据库
     * @param bllModule
     * @param classinfo
     * @param info
     * @throws Exception
     */
    public void saveDb(String bllModule,String classinfo,String info) throws Exception {
        Calendar calendar= Calendar.getInstance();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss:SSS");
        CjLogDTO cjLogDTO=new CjLogDTO();
        cjLogDTO.setBllModule(bllModule);
        cjLogDTO.setCalssInfo(classinfo);
        cjLogDTO.setSessionId(SecurityUtils.getSubject().getSession().getId()+"");
        Thread thread=Thread.currentThread();
        cjLogDTO.setThreadId(thread.getId()+"");
        cjLogDTO.setLogTime(dateFormat.format(calendar.getTime()));
        cjLogDTO.setContent(info);
        cjLogBllService_.add(cjLogDTO);
    }

    /**
     * 既打印，又存数据库
     * @param bllModule
     * @param classinfo
     * @param info
     * @throws Exception
     */
    public void logSaveDb(String bllModule,String classinfo,String info) throws Exception {
        log(info);
        saveDb(bllModule,classinfo,info);
    }


}
