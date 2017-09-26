package lyh.e3.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lyh.e3.common.pojo.EasyUiTreeNode;
import lyh.e3.mapper.TbItemCatMapper;
import lyh.e3.pojo.TbItemCat;
import lyh.e3.pojo.TbItemCatExample;
import lyh.e3.pojo.TbItemCatExample.Criteria;
import lyh.e3.service.ItemCatService;
/**
* @ClassName: ItemCatServiceImpl
* @Description: 商品分类服务
* @author student.lyh
* @date 2017年9月25日 下午3:03:56
*/
@Service
public class ItemCatServiceImpl implements ItemCatService{
    
    @Autowired
    private TbItemCatMapper catMapper;

    
    /* 
     * 根据id返回子树
     */
    public List<EasyUiTreeNode> getTreeNodeById(long id) {
        TbItemCatExample example = new TbItemCatExample();
        Criteria createCriteria = example.createCriteria();
        createCriteria.andParentIdEqualTo(id);
        List<TbItemCat> list = catMapper.selectByExample(example);
        List<EasyUiTreeNode> listNode =new ArrayList<EasyUiTreeNode>();
        for (TbItemCat tbItemCat : list) {
            EasyUiTreeNode treeNode = new EasyUiTreeNode();
            treeNode.setId(tbItemCat.getId());
            treeNode.setText(tbItemCat.getName());
            treeNode.setState(tbItemCat.getIsParent()?"closed":"open");
            listNode.add(treeNode);
        }
        return listNode;
    }
    

}
