package cloud.client;

import cloud.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 使⽤@FeignClient("microservice-provider-user")注解绑定microservice-provider-user服务，还可以使⽤url参数指定⼀个URL。
 * @author eacdy
 */
@FeignClient(name = "microservice-provider-user",fallback = HystrixClientFallback.class)
public interface UserFeignHystrixClient {

    @RequestMapping("/{id}")
    public User findByIdFeign(@RequestParam("id") Long id);

}