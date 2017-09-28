package lyh.e3.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lyh.e3.mapper.TbItemDescMapper;
import lyh.e3.pojo.TbItemDesc;
import lyh.e3.service.ItemDescService;
import lyh.e3.utils.E3Result;


@Service
public class ItemDescServiceImpl implements ItemDescService{
    
    @Autowired
    TbItemDescMapper descMapper;

    /* 
     * 查询对应的商品描述
     */
    public E3Result findItemDesc(String id) {
        System.out.println("service+"+Long.parseLong(id));
       
        try{
            TbItemDesc desc = descMapper.selectByPrimaryKey(Long.parseLong(id));
            System.out.println("desc : "+desc);
            return  E3Result.build(200, desc.getItemDesc());
        }catch (Exception e) {
            e.printStackTrace();
            return E3Result.build(200, "商品描述获取失败! 请重试");
        }
    }

}
