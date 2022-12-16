package africa.semicolon.Blog.data.repositories;

import africa.semicolon.Blog.data.models.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    Post findPostById(String id);
}
