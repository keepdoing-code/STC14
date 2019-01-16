package lections.lec03.Entity;

/**
 * Created by yuri on 16.01.19.
 */
public class Skill {
    private String description;
    private int level;

    public Skill(String description, int level) {
        this.description = description;
        this.level = level;
    }

    @Override
    public String toString() {
        return "Skill " +
                "'" + description + '\'' +
                "=" + level;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
