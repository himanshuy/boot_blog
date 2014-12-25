package controller;

import java.util.List;

import model.Post;
import service.BlogRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class BlogController {

	@Autowired
	private BlogRepository repository;

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String homePage(Model model) {

		List<Post> posts = repository.findAll(); 
		model.addAttribute("posts", posts);

		return "home";
	}
}