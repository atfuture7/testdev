package exp.springb.startapp;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
//import org.springframework.beans.factory.annotation.Autowired;

public class PageRepositoryImpl implements PageRepositoryCustom {
	
	private final PageRepository repository;
	
	public PageRepositoryImpl( PageRepository repository) {
		this.repository = repository;
	}

	@Override
	public Oprional<Page> appendUrl(String id, String sUrl) {
		Oprional<Page> op = repository.findById(pid)
						.orElseThrow( ()-> new PageNotFoundException(id));
		Page oPage = op.get();
		List<String> lst = oPage.getPageUrl();
		if (lst == null) {
			lst  = new ArrayList<String>();
		}
		lst.add(sUrl);		
		oPage.setPageUrl(lst);
		repository.save(oPage);
		return oPage;
	}
	
	public Oprional<Page> removeUrl(String id, int idx) {
		Oprional<Page> op = repository.findById(pid)
						.orElseThrow( ()-> new PageNotFoundException(id));
		Page oPage = op.get();
		List<String> lst = oPage.getPageUrl();
		if (lst != null) {
			lst  = new ArrayList<String>();
			lst.remove(idx);		
			oPage.setPageUrl(lst);
			repository.save(oPage);
		}
		return oPage;
	}
	
}
