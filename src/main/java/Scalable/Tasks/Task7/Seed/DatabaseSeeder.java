package Scalable.Tasks.Task7.Seed;

import Scalable.Tasks.Solutions.Task7_Solution.Models.FullUser;
import Scalable.Tasks.Solutions.Task7_Solution.Models.UserCore;
import Scalable.Tasks.Solutions.Task7_Solution.Models.UserExtra;
import Scalable.Tasks.Solutions.Task7_Solution.Models.UserPreferences;
import Scalable.Tasks.Solutions.Task7_Solution.Services.FullUserService;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class DatabaseSeeder {

    private final FullUserService fullUserService;
    private final Random random = new Random();

    public DatabaseSeeder(FullUserService fullUserService) {
        this.fullUserService = fullUserService;
    }

    public void seedUsers() {
        for (int i = 1; i <= 1000; i++) {
            String username = "user" + i;
            UserCore core = new UserCore(username, "pass" + i);

            UserExtra extra = new UserExtra();
            extra.setFirstName("First" + i);
            extra.setLastName("Last" + i);
            extra.setEmail(username + "@example.com");

            UserPreferences prefs = new UserPreferences();
            prefs.setTheme(random.nextBoolean() ? "light" : "dark");
            prefs.setNotificationsEnabled(random.nextBoolean());

            FullUser user = new FullUser(core, extra, prefs);
            fullUserService.createFullUser(user);
        }
    }
}
