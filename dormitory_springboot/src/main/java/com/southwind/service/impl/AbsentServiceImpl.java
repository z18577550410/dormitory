package com.southwind.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.southwind.entity.*;
import com.southwind.form.SearchForm;
import com.southwind.mapper.*;
import com.southwind.service.AbsentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.southwind.vo.AbsentVO;
import com.southwind.vo.PageVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author admin
 * @since 2023-02-03
 */
@Service
public class AbsentServiceImpl extends ServiceImpl<AbsentMapper, Absent> implements AbsentService {
    @Autowired
    private AbsentMapper absentMapper;
    @Autowired
    private BuildingMapper buildingMapper;
    @Autowired
    private DormitoryMapper dormitoryMapper;
    @Autowired
    private DormitoryAdminMapper dormitoryAdminMapper;
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public PageVO list(Integer page, Integer size) {
        Page<Absent> absentPage = new Page<>(page, size);
        Page<Absent> resultPage = this.absentMapper.selectPage(absentPage, null);
        List<AbsentVO> absentVOList=new ArrayList<>();
        for (Absent absent : resultPage.getRecords()) {
            AbsentVO absentVO = new AbsentVO();
            BeanUtils.copyProperties(absent, absentVO);
            //根据id获取对应数据进行赋值
            Building building = this.buildingMapper.selectById(absent.getBuildingId());
            absentVO.setBuildingName(building.getName());
            Dormitory dormitory = this.dormitoryMapper.selectById(absent.getDormitoryId());
            absentVO.setDormitoryName(dormitory.getName());
            Student student = this.studentMapper.selectById(absent.getStudentId());
            absentVO.setStudentName(student.getName());
            DormitoryAdmin dormitoryAdmin = this.dormitoryAdminMapper.selectById(absent.getDormitoryAdminId());
            absentVO.setDormitoryAdminName(dormitoryAdmin.getName());
            //
            absentVOList.add(absentVO);
        }
        PageVO pageVO = new PageVO<>();
        pageVO.setData(absentVOList);
        pageVO.setTotal(resultPage.getTotal());
        return pageVO;
    }

    @Override
    public PageVO search(SearchForm searchForm) {
        Page<Absent> absentPage = new Page<>(searchForm.getPage(),searchForm.getSize());
        Page<Absent> resultPage = null;
        if (searchForm.getValue().equals("")) {
            resultPage = this.absentMapper.selectPage(absentPage, null);
        } else {
            QueryWrapper<Absent> queryWrapper = new QueryWrapper<>();
            if (searchForm.getKey().equals("buildingName")) {
                QueryWrapper<Building> buildingQueryWrapper=new QueryWrapper<>();
                buildingQueryWrapper.like("name",searchForm.getValue());
                List<Building> buildingList = this.buildingMapper.selectList(buildingQueryWrapper);
                List<Integer> idList=new ArrayList<>();
                for (Building building:buildingList){
                    idList.add(building.getId());
                }
                queryWrapper.in("building_id",idList);
            }
            if (searchForm.getKey().equals("dormitoryName")) {
                QueryWrapper<Dormitory> dormitoryQueryWrapper=new QueryWrapper<>();
                dormitoryQueryWrapper.like("name",searchForm.getValue());
                List<Dormitory> dormitoryList = this.dormitoryMapper.selectList(dormitoryQueryWrapper);
                List<Integer> idList=new ArrayList<>();
                for (Dormitory dormitory:dormitoryList){
                    idList.add(dormitory.getId());
                }
                queryWrapper.in("dormitory_id",idList);
            }
            resultPage = this.absentMapper.selectPage(absentPage, queryWrapper);
        }
        //VO转换
        List<AbsentVO> absentVOList=new ArrayList<>();
        for (Absent absent : resultPage.getRecords()) {
            AbsentVO absentVO = new AbsentVO();
            BeanUtils.copyProperties(absent, absentVO);
            //根据id获取对应数据进行赋值
            Building building = this.buildingMapper.selectById(absent.getBuildingId());
            absentVO.setBuildingName(building.getName());
            Dormitory dormitory = this.dormitoryMapper.selectById(absent.getDormitoryId());
            absentVO.setDormitoryName(dormitory.getName());
            Student student = this.studentMapper.selectById(absent.getStudentId());
            absentVO.setStudentName(student.getName());
            DormitoryAdmin dormitoryAdmin = this.dormitoryAdminMapper.selectById(absent.getDormitoryAdminId());
            absentVO.setDormitoryAdminName(dormitoryAdmin.getName());
            //
            absentVOList.add(absentVO);
        }
        //
        PageVO pageVO = new PageVO<>();
        pageVO.setData(absentVOList);
        pageVO.setTotal(resultPage.getTotal());
        return pageVO;
    }
}
