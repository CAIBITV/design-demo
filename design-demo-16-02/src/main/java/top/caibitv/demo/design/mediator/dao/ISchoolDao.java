package top.caibitv.demo.design.mediator.dao;

import top.caibitv.demo.design.mediator.po.School;

public interface ISchoolDao {

    School querySchoolInfoById(Long treeId);

}
