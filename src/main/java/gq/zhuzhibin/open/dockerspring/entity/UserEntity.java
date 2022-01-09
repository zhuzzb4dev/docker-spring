package gq.zhuzhibin.open.dockerspring.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("sys_user")
@Data
public class UserEntity {

    @TableId("id")
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
