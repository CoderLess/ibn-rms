package com.ibn.rms.domain;

import com.ibn.domain.BaseDTO;
import lombok.Data;

/**
 * @version 1.0
 * @description: 
 * @projectName：ibn-rms
 * @see: com.ibn.rms.domain
 * @author： RenBin
 * @createTime：2020/8/5 13:45
 */
@Data
public class FileBaseDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;

    /**
     * @description: 主键
     * @author：RenBin
     * @createTime：2020/8/5 13:45
     */
    private Long id;
    /**
     * @description: 原始文件名
     * @author：RenBin
     * @createTime：2020/8/5 13:45
     */
    private String name;
    /**
     * @description: 文件md5值
     * @author：RenBin
     * @createTime：2020/8/5 13:45
     */
    private String md5;
    /**
     * @description: 文件id
     * @author：RenBin
     * @createTime：2020/8/5 13:45
     */
    private Long fileId;
    /**
     * @description: 文件类型
     * @author：RenBin
     * @createTime：2020/8/5 13:45
     */
    private Integer type;
    /**
     * @description: 创建时间
     * @author：RenBin
     * @createTime：2020/8/5 13:45
     */
    private Long createTime;
}