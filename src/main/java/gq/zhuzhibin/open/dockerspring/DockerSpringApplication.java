package gq.zhuzhibin.open.dockerspring;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("gq.zhuzhibin.open.dockerspring.mapper")
public class DockerSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(DockerSpringApplication.class, args);
    }

}
