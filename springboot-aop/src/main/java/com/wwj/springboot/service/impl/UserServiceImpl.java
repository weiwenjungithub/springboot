package com.wwj.springboot.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wwj.springboot.annotation.OperationLogDetail;
import com.wwj.springboot.enums.OperationType;
import com.wwj.springboot.enums.OperationUnit;
import com.wwj.springboot.service.UserService;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA
 *
 * @author weiwenjun
 * @date 2018/9/13
 */
@Service
public class UserServiceImpl implements UserService {

    @OperationLogDetail(detail = "通过手机号[{{tel}}]获取用户名",level = 3,operationUnit = OperationUnit.USER,operationType = OperationType.SELECT)
    @Override
    public String findUserName(String tel) {
        System.out.println("tel:" + tel);
        return "zhangsan";
    }


}
