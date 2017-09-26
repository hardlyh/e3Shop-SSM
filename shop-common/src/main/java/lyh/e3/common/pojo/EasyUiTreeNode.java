package lyh.e3.common.pojo;

import java.io.Serializable;

/**
* @ClassName: EasyUiTreeNode
* @Description: 封装返回EasyUI Tree  
* @author student.lyh
* @date 2017年9月25日 下午2:59:30
*/
public class EasyUiTreeNode implements Serializable {

    private long id;    
    private String text;
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
