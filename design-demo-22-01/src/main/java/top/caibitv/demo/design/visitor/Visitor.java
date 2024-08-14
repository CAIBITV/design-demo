package top.caibitv.demo.design.visitor;

import top.caibitv.demo.design.user.impl.Student;
import top.caibitv.demo.design.user.impl.Teacher;

public interface Visitor {

    // 访问学生信息
    void visit(Student student);

    // 访问老师信息
    void visit(Teacher teacher);

}
