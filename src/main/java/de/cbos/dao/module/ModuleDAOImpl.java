package de.cbos.dao.module;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import de.cbos.model.content.GuestbookEntry;
import de.cbos.model.content.Link;
import de.cbos.model.content.Paragraph;
import de.cbos.model.module.Guestbook;
import de.cbos.model.module.Module;
import de.cbos.model.module.ModuleVisitor;
import de.cbos.model.module.Navigation;
import de.cbos.model.module.Textcontainer;
import de.cbos.service.content.ContentService;

@Transactional
public class ModuleDAOImpl implements ModuleDAO {

	@Autowired
	private ContentService contentService;
	
	/**
	 * Hibernate's sessionsFactory to write objects created during this session
	 * in the database or load objects from there to the session
	 **/
	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addModule(Module module) {
		module.setLeftPosition(0);
		module.setTopPosition(0);
		getCurrentSession().save(module);
	}

	public Module getModule(int moduleId) {
		Module module = (Module) getCurrentSession()
				.get(Module.class, moduleId);
		return module;
	}

	public void deleteModule(Module module) {
		getCurrentSession().delete(module);
	}

	public void updateModule(Module module) {
		module.accept(new ModuleVisitor() {

			public void visit(Guestbook guestbook) {
				Guestbook guestbookToUpdate = (Guestbook) getModule(guestbook
						.getModuleId());
				guestbookToUpdate.setModuleName(guestbook.getModuleName());
				guestbookToUpdate.setGuestbookEntries(guestbook.getGuestbookEntries());
				guestbookToUpdate.setLeftPosition(guestbook.getLeftPosition());
				guestbookToUpdate.setTopPosition(guestbook.getTopPosition());
				getCurrentSession().update(guestbookToUpdate);
			}

			public void visit(Textcontainer textcontainer) {
				Textcontainer textcontainerToUpdate = (Textcontainer) getModule(textcontainer
						.getModuleId());
				textcontainerToUpdate.setModuleName(textcontainer
						.getModuleName());
				textcontainerToUpdate.setLeftPosition(textcontainer.getLeftPosition());
				textcontainerToUpdate.setTopPosition(textcontainer.getTopPosition());
				getCurrentSession().update(textcontainerToUpdate);
			}
			
			public void visit(Navigation navigation) {
				Navigation navigationToUpdate = (Navigation) getModule(navigation.getModuleId());
				navigationToUpdate.setLeftPosition(navigation.getLeftPosition());
				navigationToUpdate.setTopPosition(navigation.getTopPosition());
				navigationToUpdate.setModuleName(navigation.getModuleName());
				navigationToUpdate.setPage(navigation.getPage());
				getCurrentSession().update(navigationToUpdate);
			}
		});
	}

	@SuppressWarnings("unchecked")
	public List<Module> getModuleList() {
		return getCurrentSession().createQuery("FROM Module").list();
	}
	
	public void addGuestbookEntry(GuestbookEntry guestbookEntry, Guestbook guestbook) {
		guestbookEntry.setGuestbook(guestbook);
		contentService.addContent(guestbookEntry);
		List<GuestbookEntry> entries = guestbook.getGuestbookEntries();
		entries.add(guestbookEntry);
		guestbook.setGuestbookEntries(entries);
		updateModule(guestbook);
	}
	
	public void addParagraph(Paragraph paragraph, Textcontainer textcontainer) {
		paragraph.setTextcontainer(textcontainer);
		contentService.addContent(paragraph);
		List<Paragraph> paragraphs = textcontainer.getParagraphs();
		paragraphs.add(paragraph);
		textcontainer.setParagraphs(paragraphs);
		updateModule(textcontainer);
	}
	
	public void addLink(Link link, Navigation navigation) {
		updateModule(navigation);
	}

}