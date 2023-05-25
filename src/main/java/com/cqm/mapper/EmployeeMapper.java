package com.cqm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cqm.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {

}
