package exp.springb.startapp;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.data.repository.query.Param;


public interface PageRepository extends MongoRepository<Page, String>
		, PageRepositoryCustom {
	
	Page save(nPage);
	List<Page> findByTitle( String title);
	void deleteById( String title);
	
	
	List<Page> findByTitleLike(String name);

	//custom method
	List<String> findByNotAtt(  String title);
}

