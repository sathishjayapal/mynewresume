package mynewresume;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MynewresumeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MynewresumeApplication.class, args);
	}

}
