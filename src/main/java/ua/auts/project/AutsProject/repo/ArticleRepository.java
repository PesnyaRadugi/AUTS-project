package ua.auts.project.AutsProject.repo;

import org.springframework.data.repository.CrudRepository;

import ua.auts.project.AutsProject.models.Article;

public interface ArticleRepository extends CrudRepository<Article, Long> {

}
