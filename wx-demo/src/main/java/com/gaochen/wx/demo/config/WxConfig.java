package com.gaochen.wx.demo.config;

import me.chanjar.weixin.mp.api.WxMpConfigStorage;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/22
 */
@Configuration
public class WxConfig {
    @Bean
    public WxMpService wxOpenService(){
        WxMpService wxOpenService=new WxMpServiceImpl();
        wxOpenService.setWxMpConfigStorage(wxOpenConfigStorage());
        return wxOpenService;
    }
    @Bean
    public WxMpConfigStorage wxOpenConfigStorage(){
        WxMpInMemoryConfigStorage wxMpInMemoryConfigStorage=new WxMpInMemoryConfigStorage();
        wxMpInMemoryConfigStorage.setAppId("wx0c25e6264fd898c0");
        wxMpInMemoryConfigStorage.setSecret("ead58f5b3916c39debc65fe967bd31ec");
        return wxMpInMemoryConfigStorage;
    }
}
