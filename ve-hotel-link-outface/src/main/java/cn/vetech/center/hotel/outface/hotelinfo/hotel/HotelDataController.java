package cn.vetech.center.hotel.outface.hotelinfo.hotel;

import cn.vetech.center.hotel.link.api.enums.FyEnum;
import cn.vetech.center.hotel.link.component.HotelLinkFile;
import cn.vetech.center.hotel.link.enums.HotelStaticFileTypeEnum;
import cn.vetech.charge.cloud.safe.wenjian.WenJian;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author chengwanshan
 * @since 2025/12/17 11:23
 */
@Api(tags = {"酒店接口"})
@RestController
@RequestMapping("/hotel")
public class HotelDataController {
    /**
     * 日志工具
     */
    private final Logger logger = LoggerFactory.getLogger(HotelDataController.class);
    /**
     * 酒店link文件
     */
    @Autowired
    private HotelLinkFile hotelLinkFile;
    /**
     * 查询临时目录文件
     *
     * @return ReceiveResponse
     */
    @ApiOperation(value = "查询临时目录文件")
    @PostMapping(value = "/queryHotelDataFile")
    public Map<String, String> queryHotelDataFile(@RequestParam("fybh") String fybh,
                                                  @RequestParam(value = "hotelStaticFileType", required = false) String hotelStaticFileType) {
        Map<String, String> resMap = new HashMap<>();
        Optional<FyEnum> optionalFyEnum = FyEnum.instanceOptByFybh(fybh);
        if (!optionalFyEnum.isPresent()) {
            resMap.put("desc", "fybh没有找到");
            return resMap;
        }
        FyEnum fyEnum = optionalFyEnum.get();
        StopWatch stopWatch = StopWatch.createStarted();
        String dirPath = hotelLinkFile.createSupplierFileTempDirPath(fyEnum);
        try {
            queryAllFile(dirPath);
        } catch (Exception e) {
            logger.error("【{}】查询【{}】文件目录异常：", fyEnum.getFymc(), dirPath, e);
            resMap.put("desc", "【" + fyEnum.getFymc() + "】查询【" + dirPath + "】文件目录异常");
            return resMap;
        } finally {
            logger.info("【{}】查询【{}】文件目录结束，耗时【{}】ms", fyEnum.getFymc(), dirPath, stopWatch.getTime());
        }
        resMap.put("desc", "查询文件成功");
        return resMap;
    }
/**
     * 删除临时目录文件
     *
     * @return ReceiveResponse
     */
    @ApiOperation(value = "删除临时目录文件")
    @PostMapping(value = "/deleteHotelDataFile")
    public Map<String, String> deleteHotelDataFile(@RequestParam("fybh") String fybh,
                                                   @RequestParam(value = "hotelStaticFileType", required = false) String hotelStaticFileType) {
        Map<String, String> resMap = new HashMap<>();
        Optional<FyEnum> optionalFyEnum = FyEnum.instanceOptByFybh(fybh);
        if (!optionalFyEnum.isPresent()) {
            resMap.put("desc", "fybh没有找到");
            return resMap;
        }
        FyEnum fyEnum = optionalFyEnum.get();

        boolean deleteFlag = false;
        StopWatch stopWatch = StopWatch.createStarted();
        if (StringUtils.isBlank(hotelStaticFileType)) {
            String dirPath = hotelLinkFile.createSupplierFileTempDirPath(fyEnum);
            try {
                // 删除数据
                deleteFlag = hotelLinkFile.removeFile(dirPath);
                if (!deleteFlag) {
                    logger.warn("【{}】删除【{}】文件目录失败", fyEnum.getFymc(), dirPath);
                    resMap.put("desc", "【" + fyEnum.getFymc() + "】删除【" + dirPath + "】文件目录失败");
                    return resMap;
                }
            } catch (Exception e) {
                logger.error("【{}】删除【{}】文件目录异常：", fyEnum.getFymc(), dirPath, e);
                resMap.put("desc", "【" + fyEnum.getFymc() + "】删除【" + dirPath + "】文件目录异常");
                return resMap;
            } finally {
                logger.info("【{}】删除【{}】文件目录结束，耗时【{}】ms，删除成功：【{}】", fyEnum.getFymc(), dirPath, stopWatch.getTime(), deleteFlag);
            }
            resMap.put("desc", "删除文件成功");
            return resMap;
        }
         Optional<HotelStaticFileTypeEnum> optionalHotelStaticFileTypeEnum = HotelStaticFileTypeEnum.instanceOptByCode(hotelStaticFileType);
        if (!optionalHotelStaticFileTypeEnum.isPresent()) {
            resMap.put("desc", "hotelStaticFileType没有找到");
            return resMap;
        }
        HotelStaticFileTypeEnum hotelStaticFileTypeEnum = optionalHotelStaticFileTypeEnum.get();
        try {
            // 删除数据
            deleteFlag = hotelLinkFile.clearSupplierStaticFileDir(fyEnum, hotelStaticFileTypeEnum);
            if (!deleteFlag) {
                logger.warn("【{}】删除【{}】文件目录失败", fyEnum.getFymc(), hotelStaticFileTypeEnum.getName());
                resMap.put("desc", "【" + fyEnum.getFymc() + "】删除【" + hotelStaticFileTypeEnum.getName() + "】文件目录失败");
                return resMap;
            }
        } catch (Exception e) {
            logger.error("【{}】删除【{}】文件目录异常：", fyEnum.getFymc(), hotelStaticFileTypeEnum.getName(), e);
            resMap.put("desc", "【" + fyEnum.getFymc() + "】删除【" + hotelStaticFileTypeEnum.getName() + "】文件目录异常");
            return resMap;
        } finally {
            logger.info("【{}】删除【{}】文件目录结束，耗时【{}】ms，删除成功：【{}】", fyEnum.getFymc(), hotelStaticFileTypeEnum.getName(), stopWatch.getTime(), deleteFlag);
        }
        resMap.put("desc", "删除文件成功");
        return resMap;
    }

    /**
     * 查询文件/目录
     *
     * @param path 需要查询的目录或者文件路径
     */
    public void queryAllFile(String path) {
        WenJian file = new WenJian(path);
        if (!file.exists()) {
            logger.info("文件【{}】不存在", path);
            return;
        }
        if (file.isDirectory()) {
            String[] childFileArray = file.list();
            if (ArrayUtils.isEmpty(childFileArray)) {
                // 若目录为空
                return;
            }
            // 递归删除目录中的子目录下
            for (String childFile : childFileArray) {
                String childPath = path + File.separatorChar + childFile;
                queryAllFile(childPath);
            }
        } else {
            logger.info("文件【{}】,大小【{}】", path, file.length());
        }
    }

}