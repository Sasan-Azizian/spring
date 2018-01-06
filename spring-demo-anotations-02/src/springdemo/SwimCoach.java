package springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SwimCoach implements Coach {

	@Value("${foo.email}")
	private String email;
	
	@Value("${foo.team}")
	private String team;
	
	@Autowired
	@Qualifier("randomServise")
	private FortuneService fortuneService;
	
	@Override
	public String getDailyWorkout() {		
		return "Swim very hard....";
	}

	@Override
	public String getDailyFortune() {
		System.out.println("Email: "+email+"  Team:  "+team);
		return fortuneService.getFortune();		
		
	}

	public String getTeam() {
		return team;
	}

	public FortuneService getFortuneService() {
		return fortuneService;
	}

	
}
