package blog.service;

import org.springframework.data.mongodb.repository.MongoRepository;

import blog.model.Post;

/**
 * Mongo Template for Blog App
 */

public interface BlogRepository extends MongoRepository<Post, String> {

	public Post findByTitle(String title);

}