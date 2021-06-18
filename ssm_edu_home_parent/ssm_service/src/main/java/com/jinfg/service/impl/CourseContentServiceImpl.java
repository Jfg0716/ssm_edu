package com.jinfg.service.impl;

import com.jinfg.dao.CourseContentMapper;
import com.jinfg.domain.Course;
import com.jinfg.domain.CourseLesson;
import com.jinfg.domain.CourseSection;
import com.jinfg.service.CourseContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author jinfg
 * @date 2021/6/2 16:56
 */
@Service
public class CourseContentServiceImpl implements CourseContentService {

    @Autowired
    private CourseContentMapper mapper;

    Date date = null;

    @Override
    public List<CourseSection> findSectionAndLessonByCourseId(int courseId) {
        List<CourseSection> list = mapper.findSectionAndLessonByCourseId(courseId);
        return list;
    }

    @Override
    public Course findCourseByCourseId(int id) {
        Course course = mapper.findCourseByCourseId(id);
        return course;
    }

    @Override
    public void saveSection(CourseSection section) {
        //补全信息
         Date date = new Date();
         section.setCreateTime(date);
         section.setUpdateTime(date);
         mapper.saveSection(section);
    }

    @Override
    public void updateSection(CourseSection courseSection) {
        // 1. 补全信息
        courseSection.setUpdateTime(new Date());
        //2.调courseContentMapper方法
        mapper.updateSection(courseSection);
    }

    @Override
    public void updateSectionStatus(int id, int status) {
        // 封装数据
        CourseSection courseSection = new CourseSection();
        courseSection.setStatus(status);
        courseSection.setUpdateTime(new Date());
        courseSection.setId(id);

        // 调用mapper
        mapper.updateSectionStatus(courseSection);
    }

    @Override
    public void saveLesson(CourseLesson lesson) {
        //补全信息
         date = new Date();
         lesson.setCreateTime(date);
         lesson.setUpdateTime(date);
         mapper.saveLesson(lesson);
    }

    @Override
    public void updateLesson(CourseLesson lesson) {
        date = new Date();
        lesson.setUpdateTime(date);
        mapper.updateLesson(lesson);
    }


}
