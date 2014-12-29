package blog.service;

import org.springframework.data.mongodb.repository.MongoRepository;

import blog.model.Post;

public interface BlogRepository extends MongoRepository<Post, String> {

	public Post findByTitle(String title);

}