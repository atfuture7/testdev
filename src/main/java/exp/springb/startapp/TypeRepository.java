package exp.springb.startapp;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TypeRepository extends MongoRepository<Type, String>
		, TypeRepositoryCustom {
	
	Type save(Type nPage);
	Optional<Type> findById(String id);
	List<Type> findByType( String type);
	void deleteById( String id);
	
	
	List<Type> findByTypeLike(String name);

	//custom method
	Type appendPage(String id, String pid);
	Type removePage(String id, String pid);
	Type removePage(String id, int idx);
}

