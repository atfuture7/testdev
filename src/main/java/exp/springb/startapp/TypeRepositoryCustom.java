package exp.springb.startapp;

import java.util.Optional;

public interface TypeRepositoryCustom {
	Type appendPage(String id, String pid);
	Type removePage(String id, String pid);
	Type removePage(String id, int idx);
}

