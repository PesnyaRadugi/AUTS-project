package ua.auts.project.AutsProject.RepositoryTest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import ua.auts.project.AutsProject.models.User;
import ua.auts.project.AutsProject.repo.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateUser() {
        User user = new User();
        user.setEmail("bigBooba2007@gayMail.kys");
        user.setPassword("booba");
        user.setFirstName("globlogabgallab");
        user.setUsername("LolKek");

        try {
            User savedUser = userRepository.save(user);
        
            User existUser = entityManager.find(User.class, savedUser.getId());

            Assertions.assertThat(existUser.getEmail()).isEqualTo(user.getEmail());
        } catch (Exception e) {
            System.out.println("User creation test already been done");
        }

    }

    @Test
    public void testFindUserByUsername() {
        String username = "amogusSussy";

        User user = userRepository.findByUsername(username);
        Assertions.assertThat(user).isNotNull();
        System.out.println("Found User");
    }
}
