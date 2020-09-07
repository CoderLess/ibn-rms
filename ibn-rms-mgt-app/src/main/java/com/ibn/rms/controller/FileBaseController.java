package com.ibn.rms.controller;

import com.ibn.common.ResultInfo;
import com.ibn.rms.ao.FileBaseAO;
import com.ibn.rms.exception.IbnException;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @version 1.0
 * @description:
 * @projectName：ibn-rms
 * @see: com.ibn.rms.controller
 * @author： RenBin
 * @createTime：2020/9/7 13:32
 */
@RestController
@Api(tags = "上传上传下载表操作接口")
@RequestMapping("fileData")
public class FileBaseController extends BaseController {
    @Autowired
    private FileBaseAO fileBaseAO;
    @PostMapping("upload")
    public ResultInfo<Object> uploadFile(@RequestParam(value = "file") MultipartFile multipartFile) {
        try {
            fileBaseAO.saveFile(multipartFile);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultInfo<>().error(e.getMessage());
        }

        return new ResultInfo<>().success("ok");
    }
}
