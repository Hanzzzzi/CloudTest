package cloud.client;


import cloud.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class HystrixClientFallback implements UserFeignHystrixClient{
    private static final Logger LOGGER = LoggerFactory.getLogger(HystrixClientFallback.class);

    @Override
    public User findByIdFeign(Long id) {
        HystrixClientFallback.LOGGER.info("异常发⽣，进⼊fallback⽅法，接收的参数：id = {}", id);
        User user = new User();
        user.setId(-1L);
        user.setUsername("default username");
        user.setAge(0);
        return user;
    }
}
