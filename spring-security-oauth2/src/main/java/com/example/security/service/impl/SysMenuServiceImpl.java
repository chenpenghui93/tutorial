package com.example.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.example.security.entity.SysMenuEntity;
import com.example.security.dao.SysMenuDao;
import com.example.security.service.SysMenuService;
import org.springframework.stereotype.Service;

/**
 * @Description 权限业务实现
 * @Author Sans
 * @CreateTime 2019/9/14 15:57
 */
@Service("sysMenuService")
public class SysMenuServiceImpl extends ServiceImpl<SysMenuDao, SysMenuEntity> implements SysMenuService {

}