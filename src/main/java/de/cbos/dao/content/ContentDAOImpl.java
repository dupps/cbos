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
import de.cbos.model.user.User;
import de.cbos.service.content.ContentService;
import de.cbos.service.module.ModuleService;
import de.cbos.service.user.UserService;

@Transactional
public class ContentDAOImpl implements ContentDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private ContentService contentService;
	
	@Autowired
	private UserService userService;
	
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
	
	@SuppressWarnings("unchecked")
	public List<Link> getAllLinks() {
		return (List<Link>) getCurrentSession().createQuery("FROM Content WHERE contentType='link'").list();
	}

	public Content getContent(int contentId) {
		return (Content) getCurrentSession().get(Content.class, contentId);
	}

	public void deleteContent(Content content) {
		content.accept(new ContentVisitor() {
			
			public void visit(Link link) {
				getCurrentSession().delete(link);
			}
			
			public void visit(GuestbookEntry guestbookEntry) {
//				System.out.println(guestbookEntry.getAuthor().getUserName());
//				User user = userService.getUser(guestbookEntry.getAuthor().getUserName());
//				for (int i=0; i<user.getGuestbookEntries().size();i++) {
//					if(user.getGuestbookEntries().get(i).getId()==guestbookEntry.getId()) {
//						user.getGuestbookEntries().remove(guestbookEntry);
//						userService.updateUser(user);
//						System.out.println("gotcha");
//					} else {
//						System.out.println("nie");
//					}
//				}
//				userService.updateUser(user);
				getCurrentSession().delete(guestbookEntry);
			}
			
			public void visit(Paragraph paragraph) {
				getCurrentSession().delete(paragraph);
			}
		});
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
				linkToUpdate.setPage(link.getPage());
				getCurrentSession().update(linkToUpdate);
			}
		});
	}

}
