package com.cqm.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cqm.common.R;
import com.cqm.entity.Employee;
import com.cqm.service.EmployeeService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/login")
    public R<Employee> login(HttpServletRequest request, @RequestBody Employee employee) {

        //将提交的密码MD5加密
        String password = employee.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());

        //根据提交的用户名查找数据库
        LambdaQueryWrapper<Employee> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Employee::getUsername,employee.getUsername());

        Employee emp = employeeService.getOne(queryWrapper);
        //如果查询为空登录失败
        if(emp==null){
            return R.error("登录失败");
        }

        //密码比对如果错误返回登录失败
        if(!emp.getPassword().equals(password)){
            return R.error("登录失败");
        }

        //查看员工状态是否是禁用状态
        if(emp.getStatus()==0){
            return R.error("账号已经禁用");
        }

        //登录成功，将ID存入session
        request.getSession().setAttribute("employee",emp.getId());
        return R.success(emp);

    }


}
