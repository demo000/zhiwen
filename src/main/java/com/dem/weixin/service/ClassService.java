package com.dem.weixin.service;

import com.dem.weixin.domain.TbClass;

import java.util.List;

/**
 * Created by DEM
 */
public interface ClassService {

    int deleteByPrimaryKey(Long id);

    int insert(TbClass record);

    TbClass selectByPrimaryKey(Long id);

    List<TbClass> selectAll();

    int updateByPrimaryKey(TbClass record);
}
