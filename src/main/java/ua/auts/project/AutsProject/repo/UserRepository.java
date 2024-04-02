package ua.auts.project.AutsProject.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.auts.project.AutsProject.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
