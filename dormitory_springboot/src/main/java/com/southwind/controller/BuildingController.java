package com.southwind.controller;


import com.southwind.entity.Building;
import com.southwind.entity.Student;
import com.southwind.form.SearchForm;
import com.southwind.form.StudentForm;
import com.southwind.mapper.BuildingMapper;
import com.southwind.service.BuildingService;
import com.southwind.util.ResultVOUtil;
import com.southwind.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author admin
 * @since 2023-02-03
 */
@RestController
@RequestMapping("/building")
public class BuildingController {
    @Autowired
    private BuildingService buildingService;

    @PostMapping("/save")
    public ResultVO save(@RequestBody Building building) {
        boolean save = this.buildingService.save(building);
        if (!save) return ResultVOUtil.fail();
        return ResultVOUtil.success();
    }

    @GetMapping("/list/{page}/{size}")
    public ResultVO list(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        return ResultVOUtil.success(this.buildingService.list(page, size));
    }
    @GetMapping("/list")
    public ResultVO list() {
        return ResultVOUtil.success(this.buildingService.list());
    }

    @GetMapping("/search")
    public ResultVO search(SearchForm searchForm) {
        return ResultVOUtil.success(this.buildingService.search(searchForm));
    }

    @GetMapping("findById/{id}")
    public ResultVO findById(@PathVariable("id") Integer id) {
        return ResultVOUtil.success(this.buildingService.getById(id));
    }
    @PutMapping("/update")
    public ResultVO update(@RequestBody Building building){
        Boolean update =this.buildingService.updateById(building);
        if(!update) return ResultVOUtil.fail();
        return ResultVOUtil.success();
    }

    @DeleteMapping("/deleteById/{id}")
    public ResultVO deleteById(@PathVariable("id") Integer id){
        Boolean delete = this.buildingService.deleteById(id);
        if(!delete) return ResultVOUtil.fail();
        return ResultVOUtil.success();
    }


}

