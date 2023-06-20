package com.testcases.testing.repository;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.fail;

import com.testcases.testing.entity.User;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * Spring data test case
 */
@ExtendWith(SpringExtension.class)
@DataJpaTest
// to run the tests against an application configured real database
//@AutoConfigureTestDatabase(replace = Replace.NONE)
public class UserRepositoryTest {


  @Autowired
  private UserRepository repository;

  /**
   * Test is connecting to real database
   */
  @Test
  void checkFirstDBRecord() {
    Optional<User> userOptional = repository.findById(1L);
    if (userOptional.isPresent()) {
      User user = userOptional.get();
      //System.out.println(user);
      //assertEquals("Jack", user.getName() );
      Assertions.assertAll(
          () -> assertThat(user.getName(), is("Jack")),
          () -> assertThat(user.getEmail(), is("jack@beanstalk.com"))
          );
    } else {
      fail();
    }
  }

}
