package top.caibitv.demo.design.visitor.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.caibitv.demo.design.user.impl.Student;
import top.caibitv.demo.design.user.impl.Teacher;
import top.caibitv.demo.design.visitor.Visitor;

// 校长
public class Principal implements Visitor {

    private Logger logger = LoggerFactory.getLogger(Principal.class);

    public void visit(Student student) {
        logger.info("学生信息 姓名：{} 班级：{}", student.name, student.clazz);
    }

    public void visit(Teacher teacher) {
        logger.info("老师信息 姓名：{} 班级：{} 升学率：{}", teacher.name, teacher.clazz, teacher.entranceRatio());
    }

}
