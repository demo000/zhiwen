package com.dem.weixin.service.impl;

import com.dem.weixin.domain.TbClass;
import com.dem.weixin.mapper.TbClassMapper;
import com.dem.weixin.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DEM
 */
@Service
public class ClassServiceImpl implements ClassService {

    @Autowired
    private TbClassMapper tbClassMapper;
    @Override
    public int deleteByPrimaryKey(Long id) {
        return tbClassMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TbClass record) {
        return tbClassMapper.insert(record);
    }

    @Override
    public TbClass selectByPrimaryKey(Long id) {
        return tbClassMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<TbClass> selectAll() {
        return null;
    }

    @Override
    public int updateByPrimaryKey(TbClass record) {
        return 0;
    }
}
