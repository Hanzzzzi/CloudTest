package cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 使⽤@EnableFeignClients开启Feign
 * @author eacdy
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@EnableHystrix
@EnableCircuitBreaker
public class MovieFeignHystrixApplication {
    public static void main(String[] args) {
        SpringApplication.run(MovieFeignHystrixApplication.class, args);
    }
}
