package com.wwj.springboot.constant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author weiwenjun
 * @since 2019/2/21
 */
@Component
public class Constants {

    public static int queueNum;

    @Value("${queueNum}")
    public void setQueueNum(int queueNum) {
        Constants.queueNum = queueNum;
    }
}
