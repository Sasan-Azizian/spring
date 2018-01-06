package springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomServise implements FortuneService {

	String[] data= {
			"you are Greate",
			"You are bad day",
			"Awesome"
		};
	private Random random=new Random();
	@Override
	public String getFortune() {
		
		int index=random.nextInt(data.length);
		return data[index];
	}

}
