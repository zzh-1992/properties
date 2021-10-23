/*
 *Copyright @2021 Grapefruit. All rights reserved.
 */

package com.grapefruit.properties;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

/**
 * 获取properties文件/新增属性配置
 *
 * @author zhihuangzhang
 * @version 1.0
 * @date 2021-10-23 11:37 上午
 */
@Component
public class ToProperties implements EnvironmentAware {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        String path = "/config/grapefruit.properties";
        InputStream inputStream = ToProperties.class.getResourceAsStream(path);

        URL url = ToProperties.class.getResource(path);

        // 加载属性配置文件
        properties.load(inputStream);

        // 添加属性
        properties.setProperty("hhh", "123");

        properties.setProperty("key", "myky");
        String urlPath = url.getPath();

        properties.store(new FileOutputStream(urlPath), null);
    }

    @Override
    public void setEnvironment(Environment environment) {
        // 获取项目根目录
        String property = environment.getProperty("user.dir");
        String[] activeProfiles = environment.getActiveProfiles();
        String[] defaultProfiles = environment.getDefaultProfiles();
        System.out.println(property);
    }
}
