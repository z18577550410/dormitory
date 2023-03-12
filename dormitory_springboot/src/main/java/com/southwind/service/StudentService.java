package com.southwind.service;

import com.southwind.entity.Student;
import com.baomidou.mybatisplus.extension.service.IService;
import com.southwind.form.SearchForm;
import com.southwind.form.StudentForm;
import com.southwind.vo.PageVO;



/**
 * <p>
 *  服务类
 * </p>
 *
 * @author admin
 * @since 2023-02-03
 */
public interface StudentService extends IService<Student> {
    //宿舍添加学生
    public Boolean saveStudent(Student student);
    //分页查询
    public PageVO list(Integer page, Integer size);
    //
    public PageVO search(SearchForm searchForm);
    //
    public Boolean update(StudentForm studentForm);
    //
    public Boolean deleteById(Integer id);

}
