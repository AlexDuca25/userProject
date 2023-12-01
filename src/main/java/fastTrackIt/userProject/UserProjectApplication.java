package fastTrackIt.userProject;

import fastTrackIt.userProject.model.User;
import fastTrackIt.userProject.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UserProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserProjectApplication.class, args);
	}
	@Bean
	CommandLineRunner atStartUp(UserRepository repository){
		return args -> {
			User u1 =  new User("Alex","alexsejoaca","alexsejoaca@gmail.com",32,"test");
			User u2 = new User("Ioan","ioancluj123","ioancluj123@hotmail.com",21,"ioan_password");
			User u3 = new User("Vasile","vaseile12oradea","vasile12oradea@mail.com",19,"vasile_password");
			repository.save(u1);
			repository.save(u2);
			repository.save(u3);
		};
	}
}
