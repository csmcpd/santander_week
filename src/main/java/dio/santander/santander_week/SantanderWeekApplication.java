package dio.santander.santander_week;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import dio.santander.santander_week.model.Account;
import dio.santander.santander_week.model.Card;
import dio.santander.santander_week.model.Feature;
import dio.santander.santander_week.model.News;
import dio.santander.santander_week.model.User;
import dio.santander.santander_week.repository.UserRepository;

@SpringBootApplication
public class SantanderWeekApplication {

	public static void main(String[] args) {
		SpringApplication.run(SantanderWeekApplication.class, args);
	}

	@Bean
	CommandLineRunner inirDataBase(UserRepository userRepository) {
		return args -> {
			userRepository.deleteAll();

			Account account = new Account();
			account.setNumber("123456");
			account.setAgency("13424");

			Card card = new Card();
			card.setNumber("1111 2222 4444 4444");
			card.setLimit((float) 12344.55);

			Feature feature = new Feature();
			feature.setDescription("Descrição teste");

			News news = new News();
			news.setDescription("Descrição de news");
	
			User user = new User();		
			user.setName("João");
			user.setAccount(account);	
			user.setCard(card);
			user.setFeatures(null);
			user.setNews(null);

			Account account2 = new Account();
			account2.setNumber("993456");
			account2.setAgency("87924");

			Card card2 = new Card();
			card2.setNumber("3333 6622 4489 6578");
			card2.setLimit((float) 14466.55);

			Feature feature2 = new Feature();
			feature2.setDescription("Descrição teste 2");

			News news2 = new News();
			news2.setDescription("Descrição de news 2");
	
			User user2 = new User();		
			user2.setName("Maria");
			user2.setAccount(account2);	
			user2.setCard(card2);
			user2.setFeatures(null);
			user2.setNews(null);

			userRepository.save(user);
			userRepository.save(user2);
		};
	}

}
