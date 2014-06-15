package de.cbos.service.module;

import java.util.List;

import de.cbos.model.content.GuestbookEntry;
import de.cbos.model.content.Link;
import de.cbos.model.content.Paragraph;
import de.cbos.model.module.Guestbook;
import de.cbos.model.module.Module;
import de.cbos.model.module.Navigation;
import de.cbos.model.module.Textcontainer;

public interface ModuleService {
	
	public void addModule(Module module);
	public List<Module> getModuleList();
	public void deleteModule(Module module);
	public void updateModule(Module module);
	public Module getModule(int id);
	public void addGuestbookEntry(GuestbookEntry guestbookEntry, Guestbook guestbook);
	public void addParagraph(Paragraph paragraph, Textcontainer textcontainer);
	public void addLink(Link link, Navigation navigation);
}
