package com.wwj.springboot.controller;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.BuildResponseItem;
import com.github.dockerjava.core.command.BuildImageResultCallback;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.io.File;

/**
 * @author weiwenjun
 * @since 2019/1/21
 */
@RequestMapping("")
@Controller
public class DemoController {

    @Resource
    private DockerClient dockerClient;

    public void a(){
        File baseDir = new File("~/kpelykh/docker/netcat");

        BuildImageResultCallback callback = new BuildImageResultCallback() {
            @Override
            public void onNext(BuildResponseItem item) {
                System.out.println("" + item);
                super.onNext(item);
            }
        };


        String s = dockerClient.buildImageCmd(baseDir).exec(callback).awaitImageId();
    }
}
