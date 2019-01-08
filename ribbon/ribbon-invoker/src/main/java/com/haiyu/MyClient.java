package com.haiyu;

import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author 林尤庆
 * @date 2018年4月10日 下午7:34:28
 * @version 1.0
 */
@RibbonClient(name = "ribbon-provider",configuration = MyConfig.class)
public class MyClient {

}
