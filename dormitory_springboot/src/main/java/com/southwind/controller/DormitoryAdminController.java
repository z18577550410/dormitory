package com.southwind.controller;


import com.southwind.entity.DormitoryAdmin;
import com.southwind.form.RuleForm;
import com.southwind.form.SearchForm;
import com.southwind.service.DormitoryAdminService;
import com.southwind.util.ResultVOUtil;
import com.southwind.vo.PageVO;
import com.southwind.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author admin
 * @since 2023-02-03
 */
@RestController
@RequestMapping("/dormitoryAdmin")
public class DormitoryAdminController {
    @Autowired
    private DormitoryAdminService dormitoryAdminService;
    //登录
    @GetMapping("/login")
    public ResultVO login(RuleForm ruleForm){
        ResultVO resultVO = this.dormitoryAdminService.login(ruleForm);
        return resultVO;
    }
    //添加宿舍管理员
    @PostMapping("/save")
    public ResultVO save(@RequestBody DormitoryAdmin dormitoryAdmin){
        boolean save = this.dormitoryAdminService.save(dormitoryAdmin);
        if(!save) return ResultVOUtil.fail();
        return ResultVOUtil.success(null);
    }
    //查询所有宿管
    @GetMapping("/list/{page}/{size}")
    public ResultVO list(@PathVariable("page") Integer page,@PathVariable("size") Integer size){
        PageVO pageVO=this.dormitoryAdminService.list(page,size);
        return ResultVOUtil.success(pageVO);
    }
    //模糊查询宿管
    @GetMapping("/search")
    public ResultVO search(SearchForm searchForm){
        PageVO pageVO =this.dormitoryAdminService.search(searchForm);
        return ResultVOUtil.success(pageVO);
    }
    //根据id获取信息，进行编辑
    @GetMapping("/findById/{id}")
    public ResultVO findById(@PathVariable("id") Integer id){
        DormitoryAdmin dormitoryAdmin = this.dormitoryAdminService.getById(id);
        return ResultVOUtil.success(dormitoryAdmin);
    }
    //根据id修改宿管信息
    @PutMapping("/update")
    public ResultVO update(@RequestBody DormitoryAdmin dormitoryAdmin){
        boolean update = this.dormitoryAdminService.updateById(dormitoryAdmin);
        if (!update) return ResultVOUtil.fail();
        return ResultVOUtil.success(null);
    }
    //根据id删除宿管
    @DeleteMapping("/deleteById/{id}")
    public ResultVO deleteById(@PathVariable("id") Integer id ){
        boolean remove = this.dormitoryAdminService.removeById(id);
        if(!remove) return  ResultVOUtil.fail();
        return ResultVOUtil.success(null);
    }
    //下拉框查询所有宿管
    @GetMapping("/list")
    public ResultVO list(){
        List<DormitoryAdmin> dormitoryAdminList = this.dormitoryAdminService.list();
        return ResultVOUtil.success(dormitoryAdminList);
    }

}

