package com.client.proxy;

import com.client.bean.nDream.PhotoBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name="zuul-server")
@RibbonClient(name = "microservice-tests")

public interface MndreamProxy {


    @PostMapping(value = "microservice-tests/photo")
   ResponseEntity<PhotoBean> savePhoto(@RequestBody PhotoBean photo);

    @GetMapping(value = "microservice-tests/listPhotos")
    List<PhotoBean> listPhotos();


}
