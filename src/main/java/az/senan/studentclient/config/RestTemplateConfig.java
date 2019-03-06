package az.senan.studentclient.config;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import az.senan.studentclient.component.HeaderComponent;

@Configuration
public class RestTemplateConfig {

	@Autowired
	HeaderComponent header;
	
	@Bean
	RestTemplate rest() {
		RestTemplate rest=new RestTemplate();
		rest.setInterceptors(Collections.singletonList(header));
		
		return rest;
	}
}
