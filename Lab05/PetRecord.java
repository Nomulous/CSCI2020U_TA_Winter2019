package lab05_inclass_wednesday;

public class PetRecord {
    private String name;
    private String type;
    private String age;

    public PetRecord() { }

    public PetRecord(String name, String type, String age) {
        this.name = name;
        this.type = type;
        this.age = age;
    }

    public String getName()         {
        return this.name            ;}

    public String getType() {
        return this.type;
    }

    public String getAge() {
        return this.age;
    }
}
