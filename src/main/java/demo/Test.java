package demo;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.mongodb.Mongo;

public class Test {
    public static void main(String[] args) throws Exception {
        Morphia morphia = new Morphia();
        Mongo mongo = new Mongo();
        mongo.dropDatabase("test");
        Datastore ds = morphia.createDatastore(mongo, "test");

        Programmer programmer = new Programmer();
        programmer.githubUserName = "scotthernandez";
        programmer.name= "Scott Hernandez";

        ds.save(programmer);

        System.out.println(programmer);
    }
}

@Entity("programmers")
class Programmer {
    @Id
    String githubUserName;
    String name;

    @Override
    public String toString() {
        return "Programmer{" +
                "gitHubUserName=" + githubUserName +
                ", name='" + name + '\'' +
                '}';
    }
}

