package com.ibn.rms.ao.impl;

import com.ibn.rms.ao.FileBaseAO;
import com.ibn.rms.domain.FileBaseDTO;
import com.ibn.rms.domain.FileDataDTO;
import com.ibn.rms.enumer.ExceptionEnum;
import com.ibn.rms.exception.IbnException;
import com.ibn.rms.service.FileBaseService;
import com.ibn.rms.service.FileDataService;
import com.ibn.rms.util.Md5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @version 1.0
 * @description:
 * @projectName：ibn-rms
 * @see: com.ibn.rms.ao.impl
 * @author： RenBin
 * @createTime：2020/9/7 14:13
 */
@Service("fileBaseAO")
public class FileBaseAOImpl implements FileBaseAO {
    @Autowired
    private FileBaseService fileBaseService;
    @Autowired
    private FileDataService fileDataService;

    private static final Logger logger = LoggerFactory.getLogger(FileBaseAOImpl.class);

    @Override
    public Long saveFile(MultipartFile multipartFile) throws IbnException {
        byte[] bytes;
        try {
            bytes = multipartFile.getBytes();
        } catch (IOException e) {
            logger.error("获取文件字节信息失败");
            throw new IbnException(ExceptionEnum.ERROR_PARAM);
        }
        FileDataDTO fileDataDTO = new FileDataDTO();
        fileDataDTO.setData(bytes);
        Long id = fileDataService.save(fileDataDTO);
        FileBaseDTO fileBaseDTO = new FileBaseDTO();
        fileBaseDTO.setName(multipartFile.getOriginalFilename());
        fileBaseDTO.setMd5(Md5Util.getMD5(bytes));
        fileBaseDTO.setFileId(id);
        fileBaseDTO.setCreateTime(System.currentTimeMillis());
        fileBaseService.save(fileBaseDTO);
        return fileBaseDTO.getId();
    }
}
