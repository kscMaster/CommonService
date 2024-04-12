package com.nancal.remote.service;

import com.nancal.common.base.Response;
import com.nancal.remote.vo.CurrentUserInfoVo;
import com.nancal.remote.vo.RoleResourceVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Nancal.com Inc.
 * Copyright (c) 2021- All Rights Reserved.
 *
 * @Author yangtz
 * @Date 2021/12/8 16:13
 * @Description
 */
@FeignClient(contextId = "remoteLezaoPfmanageService", name = "mp-oauth-api"
//        , url = "http://120.46.143.248/api/mp-oauth-api"
)
public interface RemoteLezaoPfmanageService {

    /**
     * git
     * 获取当前登录用户信息
     *
     * @return 用户信息
     */
    @GetMapping("/oauth/user-info")
    Response<CurrentUserInfoVo> getUserInfo();

    /**
     * 获取当前用户资源，根据应用编码
     *
     * @param appCode 应用编码
     * @return 资源列表
     */
    @PostMapping("/oauth/my-allow-resources")
    Response<List<RoleResourceVo>> getUserRes(@RequestParam(value = "appCode") String appCode,@RequestParam(value = "resourceType")String resourceType,@RequestParam(value = "policy") String policy);

//    /**
//     * 创建消息无模板
//     *
//     * @param laZaoAppMessageTo
//     * @return
//     */
//    @PostMapping("/lezaoAppMessage/createAppMessageNoTem")
//    JSONObject createAppMessageNoTem(@RequestBody LaZaoAppMessageTo laZaoAppMessageTo);
//
//
//    /**
//     * 根据appId获取当前登录人的应用详情
//     *
//     * @param appId
//     * @return
//     */
//    @PostMapping("/platform/appDetailsByAppCode")
//    JSONObject appDetailsByAppCode(@RequestParam("appId") String appId);
}
