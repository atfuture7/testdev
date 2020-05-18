package exp.springb.startapp;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

public class TypeRepositoryImpl implements PageRepositoryCustom {

	@Autowired	
	private TypeRepository repository;
	@Autowired	
	private PageRepository pgRepository;
	
	// append Page
	@Override
	pubblic Type appendPage(String id, String pid) {
		// mark out first for easy debugging 
		return null;
		/*
		Optional<Type> op = repository.findById(id);
		if (!op.isPresent()) return null;
		Type oType = op.get();

		op = pgRepository.findById(pid);
		if (!op.isPresent()) return null;
		Page oPage = op.get();
		
		List<Page> lst = oType.getLstPage();
		if (lst == null) {
			lst  = new ArrayList<Page>();
		}
		lst.add(oPage);		
		oType.setLstPage(lst);
		repository.save(oType);
		return oType;
		*/
	}
	
	//remove page by id
	public Type removePage(String id, String pid) {
		// mark out first for easy debugging 
		return null;
		/*
		Optional<Type> op = repository.findById(id);
		if (!op.isPresent()) return null;
		Type oType = op.get();
		List<Page> lst = oType.getLstPage();
		
		if ((lst != null) && (idx >= 0) 
			&& !lst.isEmpty()
			&& (lst.size() >= (idx-1))) {
			
			String itrId = "";
			for (Page oPage : lst) {
				itrId = oPage.getId();
				if (id.equals(pid)) {
					lst.remove(oPage);		
					break;
				}
			}
		}
		return oType;
		*/
	}
	
	
	//remove page by index
	public Type removePage(String id, int idx) {
		// mark out first for easy debugging 
		return null;
		/*
		Optional<Type> op = repository.findById(id);
		if (!op.isPresent()) return null;
		Type oType = op.get();
		List<Page> lst = oType.getLstPage();
		
		if ((lst != null) && (idx >= 0) 
			&& !lst.isEmpty()
			&& (lst.size() >= (idx-1))) {
			lst.remove(idx);		
			oType.setLstPage(lst);
			repository.save(oType);
		}
		return oType;
		*/
	}
	
}
