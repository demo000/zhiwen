package com.dem.weixin.mapper;

import com.dem.weixin.domain.Tearcher;
import java.util.List;

public interface TearcherMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Tearcher record);

    Tearcher selectByPrimaryKey(Long id);

    List<Tearcher> selectAll();

    int updateByPrimaryKey(Tearcher record);
}