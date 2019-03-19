package com.gaochen.wx.demo.controller;

import com.gaochen.wx.demo.config.ProjectUrlConfig;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URLEncoder;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/22
 */
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    @Autowired
    private WxMpService wxMpService;

    @Autowired
    private WxMpService wxOpenService;

    @Autowired
    private ProjectUrlConfig projectUrlConfig;

    @GetMapping("/qrAuthorize")
    public String qrAuthorize(@RequestParam("returnUrl") String returnUrl){
        String redirectUrl = wxOpenService.buildQrConnectUrl(returnUrl,WxConsts.OAuth2Scope.SNSAPI_BASE, "STATE");
        return "redirect:"+redirectUrl;
    }
    @GetMapping("/qrUserInfo")
    public String qrUserInfo(@RequestParam("code") String code,
                             @RequestParam("state") String returnUrl){
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = new WxMpOAuth2AccessToken();
        try{
            wxMpOAuth2AccessToken = wxOpenService.oauth2getAccessToken(code);
        }catch (WxErrorException e){
            log.error("【微信网页】{}",e);
        }
        log.info("wxMpOAuth2AccessToken={}",wxMpOAuth2AccessToken);
        String openId = wxMpOAuth2AccessToken.getOpenId();
        return "redirect:"+returnUrl+"?openid="+openId;
    }
}
