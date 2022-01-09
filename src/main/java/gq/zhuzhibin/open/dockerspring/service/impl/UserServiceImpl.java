package gq.zhuzhibin.open.dockerspring.service.impl;

import gq.zhuzhibin.open.dockerspring.entity.UserEntity;
import gq.zhuzhibin.open.dockerspring.mapper.UserMapper;
import gq.zhuzhibin.open.dockerspring.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public void add() {
        UserEntity entity = new UserEntity();
        entity.setName("朱志斌");
        entity.setAge(18);
        entity.setEmail("zhuzzb@qq.com");
        userMapper.insert(entity);
    }
}
