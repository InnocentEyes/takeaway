package com.takeaway.service.Impl;

import com.takeaway.mapper.MemberLayerDao;
import com.takeaway.pojo.MemberLayer;
import com.takeaway.service.MemberLayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED,rollbackFor = {
        NullPointerException.class
})
public class MemberLayerServiceImpl implements MemberLayerService {

    @Autowired//这里可以用@Resource代替
    private MemberLayerDao memberLayerDao;

    @Override
    public MemberLayer findMemberLayerByLayerId(Integer layer_id) {
        MemberLayer memberLayer = null;
        if (memberLayerDao != null){
            memberLayer = memberLayerDao.findMemberLayerById(layer_id);
        }
        return memberLayer;
    }
}
