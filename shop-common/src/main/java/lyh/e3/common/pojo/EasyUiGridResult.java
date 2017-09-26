package lyh.e3.common.pojo;

import java.io.Serializable;
import java.util.List;

/**
* @ClassName: EasyUiGridResult
* @Description: 封装返回EasyUI dataGrid 数据
* @author student.lyh
* @date 2017年9月25日 下午3:00:04
*/
public class EasyUiGridResult implements Serializable{
    private long total;
    private List rows;
    public long getTotal() {
        return total;
    }
    public void setTotal(long total) {
        this.total = total;
    }
    public List getRows() {
        return rows;
    }
    public void setRows(List rows) {
        this.rows = rows;
    }
  
    
}
