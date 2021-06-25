package ERP;

import java.util.ArrayList;
import java.util.Arrays;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ERP.model.Role;
import ERP.model.User;
import ERP.service.UserService;

@SpringBootApplication
public class JwtAuthServiceApp implements CommandLineRunner {

  @Autowired
  UserService userService;

  public static void main(String[] args) {
    SpringApplication.run(JwtAuthServiceApp.class, args);
  }

  @Bean
  public ModelMapper modelMapper() {
    return new ModelMapper();
  }

  @Override
  public void run(String... params) throws Exception {
    /*User adminstock = new User();
    adminstock.setUsername("adminstock");
    adminstock.setPassword("adminstock");
    adminstock.setEmail("adminstock@email.com");
    adminstock.setRoles(new ArrayList<Role>(Arrays.asList(Role.ROLE_STOCK_RES)));

    userService.signup(adminstock);

    User adminsale = new User();
    adminsale.setUsername("adminsale");
    adminsale.setPassword("adminsale");
    adminsale.setEmail("adminsale@email.com");
    adminsale.setRoles(new ArrayList<Role>(Arrays.asList(Role.ROLE_SALE_RES)));

    userService.signup(adminsale);*/
  }

}
