package com.jinfg.service.impl;

import com.jinfg.dao.CourseMapper;
import com.jinfg.domain.Course;
import com.jinfg.domain.CourseVO;
import com.jinfg.domain.Teacher;
import com.jinfg.service.CourseService;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

/**
 * @author jinfg
 * @date 2021/5/31 17:33
 */

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<Course> findCourseByCondition(CourseVO courseVO) {
        List<Course> list = courseMapper.findCourseByCondition(courseVO);
        return list;
    }

    /*
        添加课程及讲师信息
     */

    //@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    @Override
    public void saveCourseOrTeacher(CourseVO courseVO) throws InvocationTargetException, IllegalAccessException  {
        //封装课程信息
        Course course = new Course();

        BeanUtils.copyProperties(course,courseVO);

        // 补全课程信息
        Date date = new Date();
        course.setCreateTime(date);
        course.setUpdateTime(date);

        //保存课程
        courseMapper.saveCourse(course);
        // 获取新插入数据的id值
        int id = course.getId();
        // 封装讲师信息
        Teacher teacher = new Teacher();
        BeanUtils.copyProperties(teacher,courseVO);

        // 补全讲师信息
        teacher.setCreateTime(date);
        teacher.setUpdateTime(date);
        teacher.setIsDel(0);
        teacher.setCourseId(id);

        //保存讲师信息
        courseMapper.saveTeacher(teacher);

    }

    @Override
    public CourseVO findCourseById(int id) {
        return courseMapper.findCourseById(id);
    }

    @Override
    public void updateCourseOrTeacher(CourseVO courseVO) throws InvocationTargetException, IllegalAccessException {
        //封装课程信息
        Course course = new Course();
        BeanUtils.copyProperties(course,courseVO);

        //补全信息
        Date date = new Date();
        course.setUpdateTime(date);

        // 更新课程信息
        courseMapper.updateCourse(course);


        // 封装讲师信息
        Teacher teacher = new Teacher();
        BeanUtils.copyProperties(teacher,courseVO);

        // 补全信息
        teacher.setCourseId(course.getId());
        teacher.setUpdateTime(date);

        // 更新讲师信息
        courseMapper.updateTeacher(teacher);
    }

    /*
        课程状态变更
     */
    @Override
    public void updateCourseStatus(int id, int status) {
        try {
            //1.封装数据
            Course course = new Course();
            course.setId(id);
            course.setStatus(status);
            course.setUpdateTime(new Date());

            //2.调用mapper
            courseMapper.updateCourseStatus(course);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
