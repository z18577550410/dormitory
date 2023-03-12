package com.southwind.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.southwind.entity.SystemAdmin;
import com.southwind.form.RuleForm;
import com.southwind.mapper.SystemAdminMapper;
import com.southwind.service.SystemAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.southwind.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SystemAdminServiceImpl extends ServiceImpl<SystemAdminMapper, SystemAdmin> implements SystemAdminService {

    @Autowired
    private SystemAdminMapper systemAdminMapper;

    @Override
    public ResultVO login(RuleForm ruleForm) {
        //1判断用户名是否存在
        QueryWrapper<SystemAdmin> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("username",ruleForm.getUsername());
        SystemAdmin systemAdmin= this.systemAdminMapper.selectOne(queryWrapper);
        ResultVO resultVO =new ResultVO();
        if(systemAdmin==null){
            resultVO.setCode(-1);

        }else {
            //2判断密码是否错误
            if(!systemAdmin.getPassword().equals(ruleForm.getPassword())){
                resultVO.setCode(-2);
            }else {
                resultVO.setCode(0);
                resultVO.setData(systemAdmin);
            }
        }

        return resultVO;
    }
}
