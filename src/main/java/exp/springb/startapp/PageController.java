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

	// Add new Page
	@RequestMapping(
		value = "/pageurl/{id}",
		method = RequestMethod.POST)
	@ResponseBody
	Page replacePage(@RequestBody nPage) {
		return repository.save(nPage);
	}
	
	// read one Page from id
	@RequestMapping(
		value = "/pageurl/{id}",
		method = RequestMethod.GET)
	@ResponseBody
	Page getPage(@PathVariable String id) {
		return repository.findById(id)
				.orElseThrow( ()-> new PageNotFoundException(id));
	}
	
	// update page 
	@RequestMapping(
		value = "/pageurl/{id}",
		method = RequestMethod.POST)
	@ResponseBody
	Page replacePage(@RequestBody nPage, @PathVariable String id) {
		return repository.findById.map(
				page->{
					page.setTitle(nPage.getName());
					page.setBrief(nPage.getBrief());
					page.setPageUrl(nPage.getPageUrl());
					return repository.save(page);
				}).orElseGet( ()->{
					nPage.setId(id);
					return repository.save(nPage);
				});
			
	}
	
	// delete a page 
	@RequestMapping(
		value = "/pageurl/{id}",
		method = RequestMethod.DELETE)
	@ResponseBody
	void deletePage(@Pathvariable String id) {
			repository.deleteNyId(id);
	}
	
	
	@RequestMapping(
		value = "/pageurl/getFromTitle",
		params = "title",
		method = RequestMethod.GET,
		produces = "application/json" )
	@ResponseBody
	List<Page> getListViaTitle(@RequestParam("title") String title) {
		return repository.findByTitleLike(title);
	}
	
	@RequestMapping(
		value = "/pageurl/getTestStr",
		params = "title",
		method = RequestMethod.GET)
	@ResponseBody
	List<String> getCustom(@RequestParam("title") String title) {
		return repository.findByNotAtt(title);
	}

		
}
