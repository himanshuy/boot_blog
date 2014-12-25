package service;

import model.Post;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BlogRepository extends MongoRepository<Post, String> {

	public Post findByTitle(String title);

}