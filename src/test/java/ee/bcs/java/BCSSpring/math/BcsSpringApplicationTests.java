package ee.bcs.java.BCSSpring.math;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc //need this in Spring Boot test
public class BcsSpringApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testMinMethod() throws Exception{
		RequestBuilder request =
				MockMvcRequestBuilders.get("/testing/min?a=2&b=3")
				.contentType("application/json");
		mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().string("2"));
	}

	public void testMinMethod2() throws Exception {
		RequestBuilder request =
				MockMvcRequestBuilders.get("/testing/min?a=10&b=-99")
				.contentType(("application/json"));
		mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().string("-99"));
	}

	@Test
	void contextLoads() {
	}

}
