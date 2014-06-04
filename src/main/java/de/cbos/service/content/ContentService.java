package de.cbos.service.content;

import java.util.List;

import de.cbos.model.content.Content;

public interface ContentService {
	
	public void addContent(Content content);
	public List<Content> getContentList();
	public Content getContent(int id);
	public void deleteContent(Content content);
	public void updateContent(Content content);
	
}