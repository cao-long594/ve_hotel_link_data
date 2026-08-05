package cn.vetech.center.hotel.outface.service;

import cn.vetech.charge.cloud.modules.utils.IdGenerator;
import cn.vetech.charge.cloud.modules.utils.io.FileUtil;
import cn.vetech.charge.cloud.modules.utils.time.VeDate;
import cn.vetech.charge.cloud.safe.wenjian.WenJian;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * 工具
 *
 * @author houya
 */
@Service
public class OutFaceUtilService {
    /**
     * 日志工具
     */
    private Logger logger = LoggerFactory.getLogger(OutFaceUtilService.class);

    /**
     * 文件根目录
     */
    @Value("${file_path}")
    private String filePath;
    /**
     *
     */
    @Value("${log_file_path}")
    private String logFilePath;
    /**
     * 酒店link供应商文件目录
     */
    private static final String HOTEL_MAPPING_PATH = File.separatorChar + "hotel/mapping/";


    /**
     * 扩展名
     */
    private static final String supportExtention = "xls,xlsx,txt,csv,json";
    
    /**
     * 保存上传的文件
     *
     * @param multipartFile 上传文件
     * @return 保存的文件路径和文件名
     * @throws Exception 异常
     */
    public String writeFile(MultipartFile multipartFile) throws Exception {
        if (multipartFile == null) {
            return null;
        }
        String originalFilename = multipartFile.getOriginalFilename();
        byte[] fileByte = multipartFile.getBytes();
        if (fileByte == null || fileByte.length <= 0) {
            throw new Exception("文件为空");
        }
        String fileExtension = FileUtil.getFileExtension(originalFilename);
        if (!supportExtention.contains(fileExtension)){
            throw new RuntimeException(String.format("不支持的文件扩展名:%s", fileExtension));
        }

        String dir = filePath + HOTEL_MAPPING_PATH + "/" + VeDate.getUserDate("yyyyMMdd");
        WenJian dirFile = new WenJian(dir);
        if (!dirFile.exists()) {
            dirFile.mkdirs();
        }
        String filename = IdGenerator.getId() + "." + fileExtension;
        String newfile = dir + "/" + filename;
        WenJian file = new WenJian(newfile);
        FileUtils.writeByteArrayToFile(file, fileByte);
        return file.getPath();
    }

    /**
     * 返回mapping系统的token
     * 优先取head中的,如果没有则从请求参数中获取
     *
     * @param request 请求
     * @return head
     */
      public Map<String, String> getMappingHead(HttpServletRequest request) {
        String[] headName = new String[]{"token", "gysbh", "ve-hotel-link"};
        Map<String, String> head = getHead(request, headName);
        if (StringUtils.isBlank(head.get("token"))) {
            head.put("token", request.getParameter("token"));
        }
        if (StringUtils.isBlank(head.get("gysbh"))) {
            head.put("gysbh", request.getParameter("gysbh"));
        }
        return head;
    }


    /**
     * 得到需要的head
     *
     * @param request  请求
     * @param headName 需要的head
     * @return map
     */
    public Map<String, String> getHead(HttpServletRequest request, String[] headName) {
        Map<String, String> headMap = new HashMap<>();
        for (String h : headName) {
            headMap.put(h, request.getHeader(h));
        }
        return headMap;
    }
}
