package com.yuanmaxinxi.service.content;
import com.yuanmaxinxi.domain.content.Content;
import com.yuanmaxinxi.dao.content.ContentDAO;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class ContentService{
	@Autowired
	private ContentDAO contentDAO;
	@Transactional
	public int insert(Content obj){
		return contentDAO.insert(obj);
	}


	@Transactional
	public int update(Content obj){
		return contentDAO.update(obj);
	}


	@Transactional
	public int delete(Long id){
		return contentDAO.delete(id);
	}


	public Content selectOneById(Long id){
		return contentDAO.selectOneById(id);
	}


	public List<Content> selectAll(){
		return contentDAO.selectAll();
	}

}