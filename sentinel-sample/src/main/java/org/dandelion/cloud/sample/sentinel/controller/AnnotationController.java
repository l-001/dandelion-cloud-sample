package org.dandelion.cloud.sample.sentinel.controller;

import org.dandelion.cloud.sample.sentinel.service.AnnotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO 注解方式进行限流
 *
 * @author L
 * @version 1.0
 * @date 2022-10-20 17:54
 */
@RestController
public class AnnotationController {

    @Autowired
    private AnnotationService annotationService;

    @GetMapping("annotation")
    public String annotation() {
        return annotationService.annotation();
    }

}
