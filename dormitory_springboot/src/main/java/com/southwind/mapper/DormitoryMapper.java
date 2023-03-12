package com.southwind.mapper;

import com.southwind.entity.Dormitory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author admin
 * @since 2023-02-03
 */
@Repository
public interface DormitoryMapper extends BaseMapper<Dormitory> {
    //加减剩余床位
    public Integer addAvailable(Integer id);

    public Integer subAvailable(Integer id);
    public  Integer findAvailableDormitoryId();


}
