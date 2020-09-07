package com.ibn.rms.ao;

import com.ibn.rms.exception.IbnException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @version 1.0
 * @description:
 * @projectName：ibn-rms
 * @see: com.ibn.rms.ao
 * @author： RenBin
 * @createTime：2020/9/7 14:12
 */
public interface FileBaseAO {
    /**
     * @description: 文件上传
     * @author：RenBin
     * @createTime：2020/9/7 14:12
     */
    Long saveFile(MultipartFile multipartFile) throws IbnException;
}
