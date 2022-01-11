package gq.zhuzhibin.open.dockerspring.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "my-config")
public class MyConfig {

    private String mediaLocation;

    private String mediaUrl;
}
