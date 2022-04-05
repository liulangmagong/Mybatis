package com.whalefall.mapper;

import com.whalefall.pojo.Student;
import com.whalefall.pojo.Teacher;
import com.whalefall.pojo.TeacherOneToMore;
import com.whalefall.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author wangshiyang
 * @since 2022/4/4
 **/
public class MybatisTest {

    /**
     * 查询老师测试
     */
    @Test
    public void getTeacherTest(){
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()){
            TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
            Teacher teacher = teacherMapper.getTeacher(1);
            System.out.println(teacher);

        }
    }

    /**
     * 查询携带老师信息的学生信息
     */
    @Test
    public void getStudent(){
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()){
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            List<Student> students = studentMapper.getStudent();
            students.forEach(System.out::println);

        }
    }

    /**
     * 查询携带老师信息的学生信息
     */
    @Test
    public void getStudent2(){
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()){
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            List<Student> students = studentMapper.getStudent2();
            students.forEach(System.out::println);

        }
    }

    /*---------------------------------一对多测试----------------------------*/

    @Test
    public void getTeacherTestOntToMore(){
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()){
            TeacherOneToMoreMapper mapper = sqlSession.getMapper(TeacherOneToMoreMapper.class);
            List<TeacherOneToMore> teachers = mapper.getTeacher();
            System.out.println(teachers);

        }
    }


    @Test
    public void getTeacherTestOntToMore2(){
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()){
            TeacherOneToMoreMapper mapper = sqlSession.getMapper(TeacherOneToMoreMapper.class);
            TeacherOneToMore teacher2 = mapper.getTeacher2(1);
            System.out.println(teacher2);

        }
    }

    @Test
    public void getTeacherTestOntToMore3(){
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()){
            TeacherOneToMoreMapper mapper = sqlSession.getMapper(TeacherOneToMoreMapper.class);
            TeacherOneToMore teacher2 = mapper.getTeacher3(1);
            System.out.println(teacher2);

        }
    }
}
