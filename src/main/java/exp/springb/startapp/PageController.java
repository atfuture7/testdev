package exp.springb.startapp;

import java.util.List;

import org.springframeworwk.web.bind.annotation.DeleteMapping;
import org.springframeworwk.web.bind.annotation.GetMapping;
import org.springframeworwk.web.bind.annotation.PostMapping;
import org.springframeworwk.web.bind.annotation.PutMapping;
import org.springframeworwk.web.bind.annotation.PathVariable;
import org.springframeworwk.web.bind.annotation.RequestBody;
import org.springframeworwk.web.bind.annotation.RestController;

@RestController
class PageController {
	private final PageRepository repository;
	
	PageController(PageRepository repository) {
		this.repository = repository;
	}
	
	// Aggregate root
	
	@GetMapping("/pageurl")
	List<Page> all() {
		return repository.findAll();
	}
	
	@PostMapping("/pageurl")
	Page newPage(@RequestBody Page newPage) {
		return repository.save(newPage);
	}
	
	@PostMapping("/pageurl/{title}")
	List<Page> getListViaTitle(@PathVariable String title) {
		return repository.findByTitle(title);
	}
	
	@PostMapping("/pageurl/{title}")
	List<String> getCustom(@PathVariable String title) {
		return repository.findByNotAtt(title);
	}

		
}