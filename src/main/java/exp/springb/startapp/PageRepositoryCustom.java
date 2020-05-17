package exp.springb.startapp;

import java.util.List;

public interface PageRepositoryCustom {
	List<String> findByNotAtt(String type);

}

