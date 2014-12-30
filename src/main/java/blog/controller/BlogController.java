package blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import blog.model.Post;
import blog.service.BlogRepository;

@Controller
public class BlogController {

	@Autowired
	private BlogRepository repository;

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String homePage(Model model) {
		List<Post> posts = repository.findAll(); 
		System.out.println("Number of posts: "+posts.size());
		model.addAttribute("posts", posts);

		return "home";
	}

	@RequestMapping(value="/createPost", method=RequestMethod.GET)
	public String getNewPost(Model model) {
		model.addAttribute("post", new Post());
		return "createPost";
	}

	@RequestMapping(value="/createPost", method=RequestMethod.POST)
	public String createNewPost(@ModelAttribute Post post, Model model) {
		System.out.println("Blog title "+post.getTitle());
		repository.save(post);
		List<Post> posts = repository.findAll(); 
		model.addAttribute("posts", posts);
		return "home";
	}
	
	@RequestMapping(value="/getPostContent/{title}", method=RequestMethod.GET)
	public String getPostContent(@PathVariable String title, Model model) {
		Post post = repository.findByTitle(title);
		model.addAttribute("post", post);
		
		return "content";
	}
}