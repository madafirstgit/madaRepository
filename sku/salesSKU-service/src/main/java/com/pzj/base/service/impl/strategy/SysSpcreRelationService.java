package com.pzj.base.service.impl.strategy;

import com.pzj.base.entity.SysSpcreRelationKey;
import com.pzj.base.strategy.SysSpcreRelationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016-8-27.
 */
@Service
@Lazy
public class SysSpcreRelationService {
    @Autowired
    SysSpcreRelationMapper mapper;

    public List<SysSpcreRelationKey> queryByParam(SysSpcreRelationKey param){
        List<SysSpcreRelationKey> result = mapper.selectByParam(param, null);
        return result;
    }

    public List<SysSpcreRelationKey> queryByChannelAndInfoId(Long productInfoId, Long channelId){
        List<SysSpcreRelationKey> result = mapper.selectByChannelAndInfoId(productInfoId, channelId);
        return result;
    }
}
