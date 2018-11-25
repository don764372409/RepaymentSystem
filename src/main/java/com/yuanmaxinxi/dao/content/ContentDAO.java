package com.yuanmaxinxi.dao.content;
import com.yuanmaxinxi.domain.content.Content;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;
@Mapper
@Repository
public interface ContentDAO{
	int insert(Content obj);

	int update(Content obj);

	int delete(Long id);

	Content selectOneById(Long id);

	List<Content> selectAll();

}