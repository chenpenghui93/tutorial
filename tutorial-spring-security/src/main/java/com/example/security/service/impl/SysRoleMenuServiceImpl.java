package com.example.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.security.dao.SysRoleMenuDao;
import com.example.security.entity.SysRoleMenuEntity;
import com.example.security.service.SysRoleMenuService;
import org.springframework.stereotype.Service;

/**
 * @Description 角色与权限业务实现
 * @Author Sans
 * @CreateTime 2019/9/14 15:57
 */
@Service("sysRoleMenuService")
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuDao, SysRoleMenuEntity> implements SysRoleMenuService {

}