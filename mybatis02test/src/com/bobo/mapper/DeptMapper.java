package com.bobo.mapper;

import com.bobo.entity.Dept;

/**
 * 部门操作接口mapper代理方式
 * @author tangkb
 * @create 2019-07-07 11:12
 */
public interface DeptMapper {
    /**
     * 通过部门编号查询部门信息接口
     * @param deptno 部门编号
     * @return 部门信息Dept对象
     */
    Dept selectDeptByDeptno(int deptno);
}
