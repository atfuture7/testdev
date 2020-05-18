package exp.springb.startapp;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

public class BookmkRepositoryImpl implements BookmkRepositoryCustom {

	@Autowired	
	private BookmkRepository repository;
	@Autowired	
	private PageRepository pgRepository;
	
	// append Page
	@Override
	public Bookmk appendPage(String id, String pid) {
		// mark out first for easy debugging 
		return null;
		/*
		Optional<Bookmk> op = repository.findById(id);
		if (!op.isPresent()) return null;
		Bookmk oBookmk = op.get();

		op = pgRepository.findById(pid);
		if (!op.isPresent()) return null;
		Page oPage = op.get();
		
		List<Page> lst = oBookmk.getLstPage();
		if (lst == null) {
			lst  = new ArrayList<Page>();
		}
		lst.add(oPage);		
		oBookmk.setLstPage(lst);
		repository.save(oBookmk);
		return oBookmk;
		*/
	}
	
	//remove page by id
	public Bookmk removePage(String id, String pid) {
		// mark out first for easy debugging 
		return null;
		/*
		Optional<Bookmk> op = repository.findById(id);
		if (!op.isPresent()) return null;
		Bookmk oBookmk = op.get();
		List<Page> lst = oBookmk.getLstPage();
		
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
		return oBookmk;
		*/
	}
	
	
	//remove page by index
	public Bookmk removePage(String id, int idx) {
		// mark out first for easy debugging 
		return null;
		/*
		Optional<Bookmk> op = repository.findById(id);
		if (!op.isPresent()) return null;
		Bookmk oBookmk = op.get();
		List<Page> lst = oBookmk.getLstPage();
		
		if ((lst != null) && (idx >= 0) 
			&& !lst.isEmpty()
			&& (lst.size() >= (idx-1))) {
			lst.remove(idx);		
			oBookmk.setLstPage(lst);
			repository.save(oBookmk);
		}
		return oBookmk;
		*/
	}
	
}
