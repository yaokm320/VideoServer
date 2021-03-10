package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import sun.misc.Unsafe;
import tk.mybatis.spring.annotation.MapperScan;

import java.lang.reflect.Field;


@SpringBootApplication
@MapperScan("com.example.mapper")
@EnableCaching        // 开启缓存
public class WXVideoServerApplication {

    public static void main(String[] args) {
        //禁用警告
        disableWarning();
        SpringApplication.run(WXVideoServerApplication.class, args);
    }

    public static void disableWarning() {
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            Unsafe u = (Unsafe) theUnsafe.get(null);

            Class cls = Class.forName("jdk.internal.module.IllegalAccessLogger");
            Field logger = cls.getDeclaredField("logger");
            u.putObjectVolatile(cls, u.staticFieldOffset(logger), null);
        } catch (Exception e) {
            // ignore
        }
    }
}
