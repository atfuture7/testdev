package exp.springb.startapp;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;


@RepositoryRestResource(collectionResourceRel = "pageurl", path = "pageurl" )
public interface PageRepository extends MongoRepository<Page, String>
		, PageRepositoryCustom {
	
	@RestResource(exported = true)
	List<Page> findByTitle( String title);
	@RestResource(exported = true)
	List<String> findByNotAtt(  String title);
	@RestResource(exported = false)
	List<Page> findByBrief( String str);
}

