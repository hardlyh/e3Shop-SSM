package lyh.e3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lyh.e3.common.pojo.EasyUiTreeNode;
import lyh.e3.service.ItemCatService;

/**
* @ClassName: ItemCatController
* @Description: 商品分类管理Controller 
* @author student.lyh
* @date 2017年9月25日 下午3:33:10
*/
@Controller
public class ItemCatController {

    @Autowired
    private ItemCatService itemCatService;
    
    /**
    * @Description: 返回商品分类
    * @return List<EasyUiTreeNode>    返回类型
    * @throws
     */
    @RequestMapping("/item/cat/list")
    @ResponseBody
    public List<EasyUiTreeNode> getItemCatList(@RequestParam(name="id",defaultValue="0")long parentId){
        return itemCatService.getTreeNodeById(parentId);
    }
}
