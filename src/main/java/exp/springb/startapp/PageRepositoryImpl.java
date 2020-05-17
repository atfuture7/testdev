package exp.springb.startapp;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;

public class PageRepositoryImpl implements PageRepositoryCustom {
	
	@Autowired
	private PageRepository repository;

	@Override
	public List<String> findByNotAtt(String type) {
//		Page oPage = repository.findById(pid).get();
//		List<String> lst=null;
//		if (oPage != null) {
//			lst = oPage.getPageUrl();
//			lst.add(url);
//			oPage.setPageUrl(lst);
			
//		}a
		List<String> lst = new ArrayList<String>();
		lst.add("how come");
		lst.add("everything can go wrong");
		return lst;
	}
}
