package com.ruoyi.system.mapper;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.system.domain.User;
import com.ruoyi.system.domain.UserExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@DataSource(DataSourceType.SLAVE)
public interface UserMapper {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int insert(User row);

    int insertSelective(User row);

    List<User> selectByExampleWithBLOBs(UserExample example);

    List<User> selectByExample();

    int updateByExampleSelective(@Param("row") User row, @Param("example") UserExample example);

    int updateByExampleWithBLOBs(@Param("row") User row, @Param("example") UserExample example);

    int updateByExample(@Param("row") User row, @Param("example") UserExample example);
}