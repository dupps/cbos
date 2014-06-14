package de.cbos.service.content;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import de.cbos.dao.content.ContentDAO;
import de.cbos.model.content.Content;
import de.cbos.model.content.Link;

public class ContentServiceImpl implements ContentService {

	@Autowired
	private ContentDAO contentDAO;

	public void addContent(Content content) {
		contentDAO.addContent(content);
	}

	public List<Content> getContentList() {
		return contentDAO.getContentList();
	}
	
	public List<Link> getAllLinks() {
		return contentDAO.getAllLinks();
	}

	public Content getContent(int id) {
		return contentDAO.getContent(id);
	}

	public void deleteContent(Content content) {
		contentDAO.deleteContent(content);
	}

	public void updateContent(Content content) {
		contentDAO.updateContent(content);
	}
}