package Scalable.Tasks.Task7.Controllers;


import Scalable.Tasks.Solutions.Task7_Solution.Seed.DatabaseSeeder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seed")
public class Seed {


    DatabaseSeeder databaseSeeder;

    public Seed(DatabaseSeeder databaseSeeder) {
        this.databaseSeeder = databaseSeeder;
    }

    @PostMapping
    public String seed() {
        databaseSeeder.seedUsers();
        return "Seed successful!";
    }
}
