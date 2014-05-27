package de.cbos.service.module;

import java.util.List;

import de.cbos.model.module.Module;

public interface ModuleService {
	public void addModule(Module module);
	public List<Module> getModuleList();
	public void deleteModule(Module module);
	public void updateModule(Module module);
	public Module getModule(int id);
}
