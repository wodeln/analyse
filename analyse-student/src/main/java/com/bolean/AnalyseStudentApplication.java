package com.bolean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.beetl.core.GroupTemplate;
import org.beetl.core.resource.ClasspathResourceLoader;
import org.beetl.ext.spring.BeetlGroupUtilConfiguration;
import org.beetl.ext.spring.BeetlSpringViewResolver;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ServletComponentScan
@EnableSwagger2
@MapperScan("com.bolean.dao")
public class AnalyseStudentApplication {
    private static final Logger log = LogManager.getLogger(AnalyseStudentApplication.class);
    private static final Log log1 = LogFactory.getLog(AnalyseStudentApplication.class);

    public static void main(String[] args) {

        SpringApplication.run(AnalyseStudentApplication.class, args);

        log.trace("这是 org.apache.logging.log4j LogManager trace log");
        log.warn("这是 org.apache.logging.log4j LogManager warn log");
        log.debug("这是 org.apache.logging.log4j LogManager debug log");
        log.error("折是 org.apache.logging.log4j LogManager error log");
        System.out.println("-----------------------------------------------------------华丽丽的分割线----------------------------------------------------------------");
        log1.trace("这是 org.apache.commons.logging LogFactory trace log");
        log1.warn("这是 org.apache.commons.logging LogFactory warn log");
        log1.debug("这是 org.apache.commons.logging LogFactory debug log");
        log1.error("这是 org.apache.commons.logging LogFactory error log");
    }

    @Value("templates") String templatesPath;
    @Bean(name = "beetlConfig")
    public BeetlGroupUtilConfiguration getBeetlGroupUtilConfiguration() {
        BeetlGroupUtilConfiguration beetlGroupUtilConfiguration = new BeetlGroupUtilConfiguration();
        //获取Spring Boot 的ClassLoader
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        if(loader==null){
            loader = AnalyseStudentApplication.class.getClassLoader();
        }
//        beetlGroupUtilConfiguration.setConfigProperties(extProperties);//额外的配置，可以覆盖默认配置，一般不需要
        ClasspathResourceLoader cploder = new ClasspathResourceLoader(loader,
                templatesPath);
        beetlGroupUtilConfiguration.setResourceLoader(cploder);
        beetlGroupUtilConfiguration.init();
        //如果使用了优化编译器，涉及到字节码操作，需要添加ClassLoader
        beetlGroupUtilConfiguration.getGroupTemplate().setClassLoader(loader);
        return beetlGroupUtilConfiguration;

    }

    @Bean(name = "beetlViewResolver")
    public BeetlSpringViewResolver getBeetlSpringViewResolver(@Qualifier("beetlConfig") BeetlGroupUtilConfiguration beetlGroupUtilConfiguration) {
        BeetlSpringViewResolver beetlSpringViewResolver = new BeetlSpringViewResolver();
        beetlSpringViewResolver.setContentType("text/html;charset=UTF-8");
        beetlSpringViewResolver.setOrder(0);
        beetlSpringViewResolver.setConfig(beetlGroupUtilConfiguration);
        return beetlSpringViewResolver;
    }
}
