package com.jinfg.service;

import com.jinfg.dao.CourseContentMapper;
import com.jinfg.domain.Course;
import com.jinfg.domain.CourseLesson;
import com.jinfg.domain.CourseSection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author jinfg
 * @date 2021/6/2 16:56
 */
public interface CourseContentService {


    /*
        根据课程ID查询对应的课程内容（章节+课时）
     */
    public List<CourseSection> findSectionAndLessonByCourseId(int courseId);

    public Course findCourseByCourseId(int id);

    public void saveSection(CourseSection section);

    /*
        更新章节信息
     */
    void updateSection(CourseSection courseSection);

    /*
        修改章节状态
     */
    public void updateSectionStatus(int id,int status);

    public void saveLesson(CourseLesson lesson);
    public void updateLesson(CourseLesson lesson);
}
