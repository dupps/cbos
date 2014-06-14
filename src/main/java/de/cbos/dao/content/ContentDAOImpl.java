package de.cbos.dao.content;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import de.cbos.model.content.Content;
import de.cbos.model.content.ContentVisitor;
import de.cbos.model.content.GuestbookEntry;
import de.cbos.model.content.Link;
import de.cbos.model.content.Paragraph;
import de.cbos.model.module.Guestbook;
import de.cbos.service.module.ModuleService;

@Transactional
public class ContentDAOImpl implements ContentDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private ModuleService moduleService;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addContent(Content content) {
			getCurrentSession().save(content);
	}

	@SuppressWarnings("unchecked")
	public List<Content> getContentList() {
		return getCurrentSession().createQuery("FROM Content").list();
	}

	public Content getContent(int contentId) {
		return (Content) getCurrentSession().get(Content.class, contentId);
	}

	public void deleteContent(Content content) {
		getCurrentSession().delete(content);
	}

	public void updateContent(Content content) {
		content.accept(new ContentVisitor() {

			public void visit(GuestbookEntry guestbookEntry) {
				GuestbookEntry guestbookEntryToUpdate = (GuestbookEntry) getContent(guestbookEntry
						.getId());
				guestbookEntryToUpdate.setContentName(guestbookEntry
						.getContentName());
//				guestbookEntryToUpdate.setAutor(guestbookEntry.getAutor());
//				guestbookEntryToUpdate.setEntry(guestbookEntry.getEntry());
				guestbookEntryToUpdate.setGuestbook(guestbookEntry.getGuestbook());
			}

			public void visit(Paragraph paragraph) {
				Paragraph paragraphToUpdate = (Paragraph) getContent(paragraph
						.getId());
				paragraphToUpdate.setContentName(paragraph.getContentName());
			}
			
			public void visit(Link link) {
				Link linkToUpdate = (Link) getContent(link.getId());
				linkToUpdate.setContentName(link.getContentName());
				linkToUpdate.setLink(link.getLink());
				linkToUpdate.setNavigation(link.getNavigation());
				linkToUpdate.setPage(link.getPage());
				getCurrentSession().update(linkToUpdate);
			}
		});
	}

}
