package lyh.e3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName: PageController
 * @Description: 页面跳转
 * @author student.lyh
 * @date 2017年9月24日 上午11:55:35
 */
@Controller
public class PageController {

    /**
    * @Description: 跳转首页 
    * @return String    返回类型
     */
    @RequestMapping("/")
    public String showIndex() {
        return "index";
    }

    /**
    * @Description: 跳转页面
    * @return String    返回类型
     */
    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page) {
        return page;
    }

}
