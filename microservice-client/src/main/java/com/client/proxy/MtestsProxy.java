package com.client.proxy;

import com.client.bean.ProfiluBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name="zuul-server")
@RibbonClient(name = "microservice-tests")
public interface MtestsProxy {

    @GetMapping(value = "/microservice-tests/listQuestion")
    List<ProfiluBean> listDesQuestion();

}
