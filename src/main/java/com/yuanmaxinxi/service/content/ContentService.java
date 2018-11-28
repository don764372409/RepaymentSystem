package com.yuanmaxinxi.service.content;
import com.yuanmaxinxi.domain.content.Content;
import com.yuanmaxinxi.util.StringUtil;
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
	public void insert(Content obj){
		if (!StringUtil.isNotNullAndEmpty(obj.getContent())) {
			throw new RuntimeException("短信模板内容不能为空.");
		}
		try {
			contentDAO.updateDefaultUserTo0();
		} catch (Exception e) {
			throw new RuntimeException("修改失败,请稍后重试.");
		}
		int i = contentDAO.insert(obj);
		if (i!=1) {
			throw new RuntimeException("短信模板添加失败,请稍后重试.");
		}
	}


	@Transactional
	public void update(Content obj){
		if (obj.getId()==null||obj.getId()<=0) {
			throw new RuntimeException("非法访问.");
		}
		if (!StringUtil.isNotNullAndEmpty(obj.getContent())) {
			throw new RuntimeException("短信模板内容不能为空.");
		}
		try {
			contentDAO.updateDefaultUserTo0();
		} catch (Exception e) {
			throw new RuntimeException("修改失败,请稍后重试.");
		}
		int i = contentDAO.update(obj);
		if (i!=1) {
			throw new RuntimeException("短信模板添加失败,请稍后重试.");
		}
	}


	@Transactional
	public void delete(Long id){
		Content content = selectOneById(id);
		if (content.getDefaultUse()==1) {
			throw new RuntimeException("当前模板是默认模板,不能删除.");
		}
		if (id==null||id<=0) {
			throw new RuntimeException("非法访问.");
		}
		int i = contentDAO.delete(id);
		if (i!=1) {
			throw new RuntimeException("短信模板添加失败,请稍后重试.");
		}
	}


	public Content selectOneById(Long id){
		return contentDAO.selectOneById(id);
	}


	public List<Content> selectAll(){
		return contentDAO.selectAll();
	}


	public Content selectDefaultContent() {
		return contentDAO.selectDefaultContent();
	}

}