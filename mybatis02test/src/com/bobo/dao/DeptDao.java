package com.bobo.dao;

import com.bobo.entity.Dept;

import java.io.IOException;

/**
 * 部门操作接口
 * @author tangkb
 * @create 2019-07-07 10:25
 */
public interface DeptDao {
    /**
     * 通过部门编号查询部门信息
     * @param deptno
     * @return Dept部门信息
     */
    Dept selectDeptByDeptno(Integer deptno) throws IOException;
}
