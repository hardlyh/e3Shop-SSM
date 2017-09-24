import java.util.List;

import org.junit.experimental.theories.suppliers.TestedOn;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import lyh.e3.common.pojo.EasyUiGridResult;
import lyh.e3.mapper.TbItemMapper;
import lyh.e3.pojo.TbItem;
import lyh.e3.pojo.TbItemExample;
import lyh.e3.service.ItemService;

public class PageHandleTest {
    
  
    public void test1() throws Exception{
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
        TbItemMapper item = applicationContext.getBean(TbItemMapper.class);
        PageHelper.startPage(1, 10);  // 设置page rows
        TbItemExample example =new TbItemExample();
        List<TbItem> list = item.selectByExample(example);
        PageInfo<TbItem> info = new PageInfo<>(list);
        System.out.println(list.size());
    }
    


}
