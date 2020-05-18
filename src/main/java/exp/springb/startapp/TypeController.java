package exp.springb.startapp;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;



@RestController
class TypeController {
	private final TypeRepository repository;
	
	TypeController(TypeRepository repository) {
		this.repository = repository;
	}
	
	// Aggregate root
	@GetMapping("/type")
	List<Type> all() {
		return repository.findAll();
	}

	// Add new Type
	@PostMapping( value = "/type")
	@ResponseBody
	Type newType(@RequestBody Type nType) {
		return repository.save(nType);
	}
	
	// read one Type from id
	@GetMapping(value = "/type/{id}")
	@ResponseBody
	Type getType(@PathVariable String id) {
		return repository.findById(id)
				.orElseThrow( ()-> new TypeNotFoundException(id));
	}
	
	// update Type 
	@PutMapping( value = "/type/{id}")
	@ResponseBody
	Type replaceType(@RequestBody Type oType, @PathVariable String id) {
		return repository.findById(id).map(
				type->{
					type.setType(oType.getType());
					type.setDescription(oType.getDescription());
					type.setLstPage(oType.getLstPage());
					return repository.save(Type);
				}).orElseGet( ()->{
					nType.setId(id);
					return repository.save(nType);
				});
			
	}
	
	// delete a Type 
	@DeleteMapping(	value = "/type/{id}") 
	@ResponseBody
	void deleteType(@PathVariable String id) {
			repository.deleteById(id);
	}
	
	
	@GetMapping(
		value = "/type/getFromType",
		params = "type",
		produces = "application/json" )
	@ResponseBody
	List<Type> getListViaTitle(@RequestParam("type") String type) {
		return repository.findByTypeLike(type);
	}
	
	// Add/remove item in list is what the custom interface for
	// Append Url 
	@GetMapping(
		value = "/type/append/{id}",
		params = "pid")
	@ResponseBody
	Type appendPage(@PathVariable("id") String id, 
						@RequestParam("pid") String pid) {
		return repository.appendPage(id, sUrl);
	}

	// Remove page
	@GetMapping(
		value = "/type/removePage/{id}",
		params = "idx")
	@ResponseBody
	Type appendUrlById(@PathVariable("id") String id, 
						@RequestParam("idx") int idx) {
		return repository.removePage( id, idx);
	}

	// Remove page
	@GetMapping(
		value = "/type/removePage/{id}",
		params = "pid")
	@ResponseBody
	Type appendUrlById(@PathVariable("id") String id, 
						@RequestParam("pid") String pid) {
		return repository.removePage( id, pid);
	}

}
