package e.the.awesome.springreactcomboapp;

import e.the.awesome.springreactcomboapp.dao.UserDao;
import e.the.awesome.springreactcomboapp.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringReactComboAppApplication  extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(SpringReactComboAppApplication.class, args);
	}

	@Bean
	CommandLineRunner initUser(UserDao userDao, BCryptPasswordEncoder passwordEncoder){
		return args -> {
			userDao.deleteAll();
			User user = new User("Devglan", "Devglan", "devglan", passwordEncoder.encode("devglan"), 12345, 34);
			userDao.save(user);
		};
	}

}
