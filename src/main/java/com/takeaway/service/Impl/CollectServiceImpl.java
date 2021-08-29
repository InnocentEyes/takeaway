package com.takeaway.service.Impl;

import com.github.pagehelper.PageHelper;
import com.takeaway.mapper.CollectDao;
import com.takeaway.mapper.GoodsDao;
import com.takeaway.mapper.MemberMapper;
import com.takeaway.pojo.Collect;
import com.takeaway.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED,rollbackFor = {
        NullPointerException.class
})
public class CollectServiceImpl implements CollectService {

    @Autowired//这里可以使用@Resource
    private MemberMapper memberMapper;

    @Autowired//这里可以使用@Resource
    private GoodsDao goodsDao;

    @Autowired//这里可以使用@Resource
    private CollectDao collectDao;

    @Override
    public boolean addCollect(Collect collect) {
        boolean flag = false;
        if (memberMapper != null && goodsDao != null && collectDao != null){
            if (memberMapper.findById(collect.getMemberid()).getId() == collect.getMemberid()){
                if (goodsDao.findGoodsByNo(collect.getGoodsNo()).getName() == collect.getGoodsNo()){
                    flag = collectDao.addCollect(collect);
                }
            }
        }
        return flag;
    }

    @Override
    public boolean deleteCollect(Integer member_id, Integer collect_id) {
        boolean flag = false;
        if (collectDao != null){
            if (collectDao.findAllCollect(member_id).get(0).getMemberid() == member_id){
                flag = collectDao.deleteCollect(collect_id);
            }
        }
        return flag;
    }

    @Override
    public List<Collect> findCollectByMemberId(Integer member_id, Integer page, Integer size) {
        List<Collect> collects = null;
        if (collectDao != null){
            if (collectDao.findAllCollect(member_id).get(0).getMemberid() == member_id){
                //这里不用findCollectCountByMemberId是为了效率
                Integer amount = collectDao.findCollectCount(member_id) / size + 1 ;
                if (page <= amount){
                    PageHelper.startPage(page,size);
                    collects = collectDao.findAllCollect(member_id);
                }
            }
        }
        return collects;
    }

    @Override
    public Integer findCollectCountByMemberId(Integer member_id) {
        Integer size = 0;
        if (collectDao != null){
            if (collectDao.findAllCollect(member_id).get(0).getMemberid() == member_id){
                size = collectDao.findCollectCount(member_id);
            }
        }
        return size;
    }
}
