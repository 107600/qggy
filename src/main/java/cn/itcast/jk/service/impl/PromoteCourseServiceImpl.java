package cn.itcast.jk.service.impl;

import cn.itcast.jk.dao2.CoursePromoteMapper;
import cn.itcast.jk.domain.PromoteCourse;
import cn.itcast.jk.domain.Student;
import cn.itcast.jk.service.PromoteCourseService;
import cn.itcast.jk.vo.PromoteCourseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PromoteCourseServiceImpl implements PromoteCourseService {

    //注入发起课程的Mapper
    @Autowired
    private CoursePromoteMapper coursePromoteMapper;

    //查询数据库中的所有记录
    @Override
    public List<PromoteCourse> queryAll() {
        return coursePromoteMapper.queryAll();
    }

    //查询数据库中的单个记录
    @Override
    public PromoteCourse query(Integer id) {
        return coursePromoteMapper.query(id);
    }

    //课程发起，添加
    @Override
    public void addCoursePromote(PromoteCourse promoteCourse) {
        coursePromoteMapper.addCoursePromote(promoteCourse);
    }

    //将课程发起的待审核状态改为未审核通过
    @Override
    public void updatePromoteState(Integer id) {
        coursePromoteMapper.updatePromoteState(id);
    }

    //将课程发起的待审核状态改为审核通过
    @Override
    public void updatePromoteStatePass(Integer id) {
        coursePromoteMapper.updatePromoteStatePass(id);
    }

    //电脑端的查询功能
    @Override
    public List<PromoteCourse> queryByParams(PromoteCourse promoteCourse) {
        return coursePromoteMapper.queryByParams(promoteCourse);
    }

    //手机端展示发起课程的列表，显示状态为待审核的记录
    @Override
    public List<PromoteCourse> queryUnChecked() {
        return coursePromoteMapper.queryUnChecked();
    }

    //老师对某一课程感兴趣，人数加1
    @Override
    public void updateTeaNum(PromoteCourse promoteCourse) {
        coursePromoteMapper.updateTeaNum(promoteCourse);
    }

    //老师对某一课程感兴趣，人数加1
    @Override
    public void updateStuNum(PromoteCourse promoteCourse) {
        coursePromoteMapper.updateStuNum(promoteCourse);
    }

    //将学生或教师所感兴趣的课程添加到数据表
    @Override
    public void addInterestCourse(Map<String,String> map) {
        coursePromoteMapper.addInterestCourse(map);
    }

    //判断数据表中是否有该用户的openid，如果有，则不能重复添加我想参加
    @Override
    public String queryInterestCourse(Map<String, String> map) {
        return coursePromoteMapper.queryInterestCourse(map);
    }

    //查询数据表中关于某一发起课程的信息，对应的实体是promoteCourseVO
    @Override
    public List<PromoteCourseVO> queryPromoteCourseVO(Integer id) {
        return coursePromoteMapper.queryPromoteCourseVO(id);
    }

    //查询用户的详细信息
    @Override
    public Student queryOneStudent(String userOpenid) {
        return coursePromoteMapper.queryOneStudent(userOpenid);
    }

}
