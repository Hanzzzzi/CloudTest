package org.omaha.cloud.controller;

import org.omaha.cloud.dao.UserRepository;
import org.omaha.cloud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Qualifier("eurekaRegistration")
    @Autowired
    private Registration registration; // 服务注册

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private UserRepository userRepository;

    /**
     * 注：@GetMapping("/{id}")是spring 4.3的新注解等价于：
     * @RequestMapping(value = "/id", method = RequestMethod.GE
    T)
     * 类似的注解还有@PostMapping等等
     * @param id
     * @return user信息
     */
    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        User findOne = userRepository.findById(id).get();
        return findOne;
    }

    /*** 本地服务实例的信息
     * @return
     */
    @GetMapping("/instance-info")
    public ServiceInstance showInfo() {
        List<ServiceInstance> list = discoveryClient.getInstances(registration.getServiceId());
        if (list != null && list.size() > 0) {
            for(ServiceInstance itm : list){
                if(itm.getPort() == 8000)
                    return itm;
            }
        }
        return null;
    }

}
