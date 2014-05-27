package de.cbos.service.content;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import de.cbos.dao.content.ContentDAO;
import de.cbos.model.content.Content;

@Transactional
public class ContentServiceImpl implements ContentService {
	
	@Autowired
	private ContentDAO contentDAO;

	public void addContent(Content content) {
		contentDAO.addContent(content);
		
	}

	public List<Content> getContentList() {
		return contentDAO.getContent();
	}

	public void deleteContent(Content content) {
		contentDAO.deleteContent(content);
	}

	public void updateContent(Content content) {
		contentDAO.updateContent(content);
	}
	
	

}
