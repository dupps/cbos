package de.cbos.dao.content;

import java.util.List;

import de.cbos.model.content.Content;
import de.cbos.model.content.Link;

public interface ContentDAO {

	public void addContent(Content content);
	public List<Content> getContentList();
	public List<Link> getAllLinks();
	public Content getContent(int id);
	public void deleteContent(Content content);
	public void updateContent(Content content);
}
