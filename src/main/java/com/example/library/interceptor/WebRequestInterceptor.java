package com.example.library.interceptor;

import org.springframework.web.servlet.config.annotation.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


/**
 * 拦截器(可做跨域，token验证等)
 */

@Configuration
public class WebRequestInterceptor implements WebMvcConfigurer {
    /**
     * 自定义拦截器()
     * @param registry
     */
    public void addInterceptors(InterceptorRegistry registry) {
        // RequestInterceptor为具体拦截逻辑的执行类 实现了HandlerInterceptor接口
        // addPathPatterns("/test/**")  意义是访问路径下/test 下所有的访问路径都需要被RequestInterceptor拦截
        // excludePathPatterns 这个访问路径/test/exception则不在被RequestInterceptor拦截的范围
        // /user/** user下所有路径都包含在内 例：/user/api 、/user/api/zz
        // /user/* 只有user下一层路径包含在内 例：/user/api(包含) 、/user/api/zz(不包含)
        // /test/queryUser接口则是token验证后，把token为xx的玩家信息放入Request中，方便接口拿取
        registry.addInterceptor(new RequestInterceptor())
                .addPathPatterns("/user/**")
                .addPathPatterns("/book/**")
                .addPathPatterns("/manager/**")
                .excludePathPatterns("/user/login")
                .excludePathPatterns("/user/managerRegister")
                .excludePathPatterns("/user/register")
                .excludePathPatterns("/book/searchBook");
    }

    @Bean
    public CorsFilter corsFilter() {
        // 创建跨域配置对象
        CorsConfiguration config = new CorsConfiguration();
        // 允许的域名，可以设置具体的域名，例如：http://example.com
        config.addAllowedOrigin("*");
        // 允许的请求方法，例如：GET、POST
        config.addAllowedMethod("*");
        // 允许的请求头
        config.addAllowedHeader("*");
        // 是否允许发送 Cookie
        config.setAllowCredentials(true);

        // 创建基于路径的跨域配置源
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        // 对所有路径应用跨域配置
        source.registerCorsConfiguration("/**", config);

        // 创建跨域过滤器并返回
        return new CorsFilter(source);
    }
}

