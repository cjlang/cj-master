package com.cj.core;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.cj.common.vo.J;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class BaseController {
    public <T> J<T> success(T data) {
        return J.ok(data);
    }

    public <T> J<T> success() {
        return J.ok();
    }

    public <T> J<T> error() {
        return J.error();
    }

    public List<String> convert(String idStr) throws Exception {
        //判断id是否为空
        if (Strings.isBlank(idStr)) {
            throw new Exception();
        }
        // 将ids 拆分为数组,分隔符为"-"
        String[] idStrArr = StringUtils.split(idStr, "-");
        return Arrays.stream(idStrArr).map(id -> (id)).collect(Collectors.toList());
    }
}
