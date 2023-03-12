package com.southwind.service;

import com.southwind.entity.SystemAdmin;
import com.baomidou.mybatisplus.extension.service.IService;
import com.southwind.form.RuleForm;
import com.southwind.vo.ResultVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author admin
 * @since 2023-02-03
 */
public interface SystemAdminService extends IService<SystemAdmin> {
    public ResultVO login(RuleForm ruleForm);

}
