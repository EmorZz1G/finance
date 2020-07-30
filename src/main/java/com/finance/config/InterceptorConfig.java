package com.finance.config;


import com.finance.config.intercepter.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Emor
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    /**
     * 要登录才可以访问的请求，不拦截静态资源
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/","/tologinByPhone.html","/tologinByEmail.html","/getPassword","/getPassword/**","/getpasw","/getpasw/**","/togetPasw.html","/login","/register","/login/**","/register/**","/toregister.html")
                .excludePathPatterns("/**/*.js","/**/*.css");
    }

}
