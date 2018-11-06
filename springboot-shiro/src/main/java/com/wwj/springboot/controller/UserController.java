package com.wwj.springboot.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

/**
 * @author weiwenjun
 * @since 2018/10/31
 */
@RestController
@RequestMapping("/users")
@Api(value = "用户管理", tags = {"用户管理"})
public class UserController {

    @GetMapping
    @ApiOperation("获取列表")
    @RequiresPermissions("user:list")
    public void list(@RequestParam(name = "userName", required = false) String userName,
                           @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
                           @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
        System.out.println();
    }


    @GetMapping(path = "/{userId}")
    @ApiOperation("获取详情")
    @RequiresPermissions("user:get")
    public void getUserById(@PathVariable("userId") String userId) {
        System.out.println();
    }

    @PostMapping
    @ApiOperation("新增一个用户")
    @RequiresPermissions("user:save")
    public void save() {
        System.out.println();
    }

    @PutMapping("/{userId}")
    @ApiOperation("修改保存")
    @RequiresPermissions("user:update")
    public void editSave(@PathVariable String userId) {
        System.out.println();
    }

}
