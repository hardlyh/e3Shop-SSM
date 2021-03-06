package lyh.e3.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import lyh.e3.common.pojo.QiniuUpload;
import lyh.e3.utils.JsonUtils;

/**
 * @ClassName: PictureController
 * @Description: 图上上传控制类
 * @author student.lyh
 * @date 2017年9月26日 下午4:52:05
 */
@Controller
public class PictureController {

    @Value("${qiniuUrl}")
    private String qiniuUrl;

    /**
     * @throws IOException
     * @Description: 上传图片 @return Map 返回类型 @throws
     */
    @RequestMapping(value="/pic/upload",produces=MediaType.TEXT_PLAIN_VALUE+";charset=utf-8")
    @ResponseBody
    public String uploadFile(MultipartFile uploadFile, @RequestParam String dir) throws IOException {
        InputStream in = uploadFile.getInputStream();
        Map<String,Object> result = new HashMap<>();
        String originalFilename = uploadFile.getOriginalFilename();  // 得到文件全名
        try {
            String key = QiniuUpload.upload(in, originalFilename);
            String url = qiniuUrl + "/" + key;
            result.put("error", 0);
            result.put("url", url);
            return JsonUtils.objectToJson(result);
        } catch (Exception e) {
            result.put("error", 1);
            result.put("message", "图片上传失败");
            e.printStackTrace();
            return JsonUtils.objectToJson(result);
        }
    }

}
