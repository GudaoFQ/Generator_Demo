package com.gudao.generator.dao;

import com.gudao.generator.model.Members;
import java.util.List;

public interface MembersMapper {
    int deleteByPrimaryKey(String id);

    int insert(Members record);

    Members selectByPrimaryKey(String id);

    List<Members> selectAll();

    int updateByPrimaryKey(Members record);
}