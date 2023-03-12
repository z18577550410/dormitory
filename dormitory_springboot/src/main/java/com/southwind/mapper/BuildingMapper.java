package com.southwind.mapper;

import com.southwind.entity.Building;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author admin
 * @since 2023-02-03
 */
@Repository
public interface BuildingMapper extends BaseMapper<Building> {

}
