package de.cbos.dao.module;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import de.cbos.model.content.GuestbookEntry;
import de.cbos.model.module.Guestbook;
import de.cbos.model.module.Module;
import de.cbos.model.module.ModuleVisitor;
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
			}

			public void visit(Textcontainer textcontainer) {
				Textcontainer textcontainerToUpdate = (Textcontainer) getModule(textcontainer
						.getModuleId());
				textcontainerToUpdate.setHeadline(textcontainer.getHeadline());
				textcontainerToUpdate.setModuleName(textcontainer
						.getModuleName());
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

}