//package Scalable.Tasks.Task7;
//import Scalable.Tasks.Task7.Models.FullUser;
//import Scalable.Tasks.Task7.Models.UserCore;
//import Scalable.Tasks.Task7.Models.UserExtra;
//import Scalable.Tasks.Task7.Models.UserPreferences;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestInstance;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.Random;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//public class Task7ApplicationTests {
//
//	@Autowired
//	private MockMvc mockMvc;
//
//	@Autowired
//	private ObjectMapper objectMapper;
//
//	private final Random random = new Random();
//
//	@Test
//	void whenPostTo52Prefix_thenCreatesFullUser() throws Exception {
//		UserCore core = new UserCore("johndoe", "password123");
//		UserExtra extra = new UserExtra();
//		extra.setFirstName("John");
//		extra.setLastName("Doe");
//		extra.setEmail("john.doe@example.com");
//		UserPreferences prefs = new UserPreferences();
//		prefs.setTheme("dark");
//		prefs.setNotificationsEnabled(true);
//		FullUser payloadUser = new FullUser(core, extra, prefs);
//
//		mockMvc.perform(post("/52-1234")
//						.contentType(MediaType.APPLICATION_JSON)
//						.content(objectMapper.writeValueAsString(payloadUser)))
//				.andExpect(status().isOk());
//	}
//
//	@Test
//	void whenGetRandomIdAfterSeeding_thenReturnsFullUserJson() throws Exception {
//
//		mockMvc.perform(post("/seed"))
//				.andExpect(status().isOk());
//
//		// Random ID between 2 and 2999
//		int randomId = random.nextInt(1000) + 2;
//
//		mockMvc.perform(get("/52-1234/{id}", randomId)
//						.accept(MediaType.APPLICATION_JSON))
//				.andExpect(status().isOk())
//				.andExpect(jsonPath("$.userCore.username").exists())
//				.andExpect(jsonPath("$.userExtra.email").exists())
//				.andExpect(jsonPath("$.userPreferences.theme").exists());
//	}
//}
//
