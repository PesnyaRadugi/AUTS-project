package ua.auts.project.AutsProject.repo;

import org.springframework.data.repository.CrudRepository;
import ua.auts.project.AutsProject.models.Post;

public interface PostRepository extends CrudRepository<Post, Long> {

}
