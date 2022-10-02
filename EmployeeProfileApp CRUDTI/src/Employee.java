import java.awt.image.BufferedImage;
import java.nio.Buffer;

public class Employee {

    private String id;
    private String name;
    private String age;
    private String gender;
    private String startDate;
    private String level;
    private String teamInfo;
    private String position;
    private String phone;
    private String email;
    private BufferedImage image;

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getLevel() {
        return level;
    }

    public String getTeamInfo() {
        return teamInfo;
    }

    public String getPosition() {
        return position;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public BufferedImage getImage() {
        return image;
    }

    public Employee(String id, String name, String age, String gender, String startDate, String level,
                    String teamInfo, String position, String phone, String email, BufferedImage image) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.startDate = startDate;
        this.level = level;
        this.teamInfo = teamInfo;
        this.position = position;
        this.phone = phone;
        this.email = email;
        this.image = image;
    }


}
