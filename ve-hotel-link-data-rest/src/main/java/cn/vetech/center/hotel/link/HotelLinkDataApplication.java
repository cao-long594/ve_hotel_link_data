package cn.vetech.center.hotel.link;

import cn.vetech.charge.cloud.springcloud.config.annotation.EnableVetechSpring;
import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.EnableAsync;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;



/**
 * velink
 *
 * @author houya
 */
@SpringBootApplication
@EnableVetechSpring
@EnableFeignClients(basePackages = {
        "cn.vetech.center.hotel"
})
@ComponentScan(basePackages = {
        "cn.vetech.center.hotel",
        "cn.vetech.charge.ve",
        "cn.vetech.charge.cloud.cache"
})
@EnableAsync
public class HotelLinkDataApplication {
    /**
     *
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(HotelLinkDataApplication.class);

    /**
     * @param args canshu
     */
    public static void main(String[] args) {
        SpringApplication.run(HotelLinkDataApplication.class, args);
    }

    /**
     * 控制台打印服务类名
     *
     * @param ctx 上下文
     * @return 执行命名行
     */
    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        String[] profiles = ctx.getEnvironment().getActiveProfiles();
        String enviroment = ArrayUtils.isEmpty(profiles) ? "default" : ArrayUtils.toString(profiles);
        return args ->             LOGGER.info("独立link启动,启动的环境:{},2022",enviroment);
    }

    /**
     * @return
     */
    @Bean
    @Order(0)
    public Docket createVeHotelLink() {
        return (new Docket(DocumentationType.SWAGGER_2)).select()
                .apis(RequestHandlerSelectors.basePackage("cn.vetech.center")).paths(PathSelectors.any()).build();
    }


}
