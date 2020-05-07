package e.the.awesome.springreactcomboapp;

import static org.hamcrest.Matchers.is;

import e.the.awesome.springreactcomboapp.controller.UserController;
import e.the.awesome.springreactcomboapp.model.ApiResponse;
import e.the.awesome.springreactcomboapp.model.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserControllerTest {

  @Autowired
  private UserController userController;

  @Autowired
  private Creator creator;

  @Test
  void basicTest() {
    User user = new User();
    user.setAge(10);
    creator.saveEntity(user);
    ApiResponse<User> userApiResponse = userController.getOne(user.getId());
    User responseUser = (User) userApiResponse.getResult();
    Assert.assertThat(responseUser.getAge(), is(10));
  }

}
