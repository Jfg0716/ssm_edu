package com.jinfg.dao;

import com.jinfg.domain.Course;
import com.jinfg.domain.CourseLesson;
import com.jinfg.domain.CourseSection;

import java.util.List;

/**
 * @author jinfg
 * @date 2021/6/2 16:51
 */
public interface CourseContentMapper {
    /*
        根据课程id查询关联的章节信息及章节信息关联的课时信息
     */

    public List<CourseSection> findSectionAndLessonByCourseId(int courseId);

    /*** 回显章节对应的课程信息 * */
    public Course findCourseByCourseId(int id);

    /*** 保存章节 * */
    public void saveSection(CourseSection section);

    /*
        更新章节信息
     */
    void updateSection(CourseSection courseSection);

    /*
        修改章节状态
     */
    public void updateSectionStatus(CourseSection courseSection);

    /*** 保存课时 * */
    public void saveLesson(CourseLesson lesson);

    void updateLesson(CourseLesson lesson);
}
