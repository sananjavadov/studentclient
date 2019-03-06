package az.senan.studentclient.component;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

@Component
public class HeaderComponent implements ClientHttpRequestInterceptor {

	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
			throws IOException {
		
		HttpHeaders headers=request.getHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setBasicAuth("user", "123");
				
		return execution.execute(request, body);

	}

}
