package exam02.cv;

import java.util.ArrayList;
import java.util.List;

public class Cv {
    private final String name;

    private List<Skill> skills = new ArrayList<>();

    public Cv(String name) {
        this.name = name;
    }

    public void addSkills(String... str) {
        for (String item : str) {
            skills.add(convertSkillFromString(item));
        }
    }

    private Skill convertSkillFromString(String str) {
        String[] splitted = str.split("[()]");
        return new Skill(splitted[0].trim(), Integer.parseInt(splitted[1]));
    }

    public String getName() {
        return name;
    }

    public List<Skill> getSkills() {
        return new ArrayList<>(skills);
    }

    public int findSkillLevelByName(String skillName) {
        for (Skill item : skills) {
            if (item.getName().equals(skillName)) {
                return item.getLevel();
            }
        }
        throw new SkillNotFoundException("Skill not founded: " + skillName);
    }
}
