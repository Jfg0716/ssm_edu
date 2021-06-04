package com.jinfg.service;

import com.jinfg.domain.Course;
import com.jinfg.domain.CourseVO;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * @author jinfg
 * @date 2021/5/31 17:32
 */
public interface CourseService {
    /*
        多条件课程列表查询
     */

    public List<Course> findCourseByCondition(CourseVO courseVO);


    /*
        添加课程及讲师信息
     */
    public void saveCourseOrTeacher(CourseVO courseVO) throws InvocationTargetException, IllegalAccessException ;

    /*
       更新课程及讲师信息
     */
//    public void updateCourseOrTeacher(CourseVO courseVO) ;

    /*** 根据id获取课程信息 * */
    public CourseVO findCourseById(int id) ;

    /*** 修改课程信息 * */
    public void updateCourseOrTeacher(CourseVO courseVO) throws InvocationTargetException, IllegalAccessException;

    /*
        课程状态变更
     */
    public void updateCourseStatus(int id,int status);
}
