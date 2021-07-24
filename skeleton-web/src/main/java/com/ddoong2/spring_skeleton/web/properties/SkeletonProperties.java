package com.ddoong2.spring_skeleton.web.properties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@AllArgsConstructor
@Getter
@ConstructorBinding
@ConfigurationProperties(prefix = "skeleton")
public class SkeletonProperties {
    private String name;
}
