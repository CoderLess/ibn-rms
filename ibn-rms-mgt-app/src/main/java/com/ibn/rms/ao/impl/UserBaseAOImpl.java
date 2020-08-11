package com.ibn.rms.ao.impl;

import com.ibn.page.Pagination;
import com.ibn.rms.ao.UserBaseAO;
import com.ibn.rms.domain.UserBaseDTO;
import com.ibn.rms.exception.IbnException;
import com.ibn.page.PageInfo;
import com.ibn.rms.service.UserBaseService;
import com.ibn.rms.vo.UserBaseVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @version 1.0
 * @description:
 * @projectName：ibn-rms
 * @see: com.ibn.rms.ao.impl
 * @author： RenBin
 * @createTime：2020/8/11 11:02
 */
@Service("userBaseAO")
public class UserBaseAOImpl implements UserBaseAO {
    @Autowired
    private UserBaseService userBaseService;

    @Override
    public long save(UserBaseVO userBaseVO) throws IbnException {
        UserBaseDTO userBaseDTO = new UserBaseDTO();
        BeanUtils.copyProperties(userBaseVO, userBaseDTO);
        return userBaseService.save(userBaseDTO);
    }

    @Override
    public long saveBatch(List<UserBaseVO> userBaseVOList) throws IbnException {
        List<UserBaseDTO> userBaseDTOList = userBaseVOList.stream().map(userBaseVO -> {
            UserBaseDTO userBaseDTO = new UserBaseDTO();
            BeanUtils.copyProperties(userBaseVO, userBaseDTO);
            return userBaseDTO;
        }).collect(Collectors.toList());
        return userBaseService.saveBatch(userBaseDTOList);
    }

    @Override
    public int remove(Long id) throws IbnException {
        return userBaseService.remove(id);
    }

    @Override
    public int removeBatch(Set<Long> idSet) throws IbnException {
        return userBaseService.removeBatch(idSet);
    }

    @Override
    public int modify(UserBaseVO userBaseVO) throws IbnException {
        UserBaseDTO userBaseDTO = new UserBaseDTO();
        BeanUtils.copyProperties(userBaseVO, userBaseDTO);
        return userBaseService.modify(userBaseDTO);
    }

    @Override
    public UserBaseVO query(Long id) throws IbnException {
        UserBaseDTO userBaseDTO = userBaseService.query(id);
        if (null == userBaseDTO) {
            return null;
        }
        UserBaseVO userBaseVO = new UserBaseVO();
        BeanUtils.copyProperties(userBaseDTO, userBaseVO);
        return userBaseVO;
    }

    @Override
    public List<UserBaseVO> queryList(UserBaseVO userBaseVO) throws IbnException {
        UserBaseDTO userBaseDTO = new UserBaseDTO();
        BeanUtils.copyProperties(userBaseVO, userBaseDTO);
        List<UserBaseDTO> userBaseDTOList = userBaseService.queryList(userBaseDTO);
        List<UserBaseVO> userBaseVOList = userBaseDTOList.stream().map(curUserBaseDTO -> {
            UserBaseVO curUserBaseVO = new UserBaseVO();
            BeanUtils.copyProperties(curUserBaseDTO, curUserBaseVO);
            return curUserBaseVO;
        }).collect(Collectors.toList());
        return userBaseVOList;
    }

    @Override
    public Pagination<UserBaseVO> queryPage(UserBaseVO userBaseVO, PageInfo pageInfo) throws IbnException {
        UserBaseDTO userBaseDTO = new UserBaseDTO();
        BeanUtils.copyProperties(userBaseVO, userBaseDTO);
        Pagination<UserBaseDTO> userBaseDTOPagination = userBaseService.queryPage(userBaseDTO,pageInfo);
        if (null != userBaseDTOPagination && CollectionUtils.isEmpty(userBaseDTOPagination.getList())) {
            return new Pagination<>(0,0,0,0);
        }
        Pagination<UserBaseVO> userBaseVOPagination = new Pagination<>(userBaseDTOPagination.getPageNum(),
                userBaseDTOPagination.getPageSize(),userBaseDTOPagination.getTotal(),userBaseDTOPagination.getPages());

        List<UserBaseVO> userBaseVOList = userBaseDTOPagination.getList().stream().map(curUserBaseDTO -> {
            UserBaseVO curUserBaseVO = new UserBaseVO();
            BeanUtils.copyProperties(curUserBaseDTO, curUserBaseVO);
            return curUserBaseVO;
        }).collect(Collectors.toList());
        userBaseVOPagination.setList(userBaseVOList);
        return userBaseVOPagination;
    }
}
