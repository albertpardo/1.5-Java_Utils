package level1ex5;

import java.io.Serializable;

public class PersonName implements Serializable {
    private String name;

    public PersonName(String name){
        this.name = name;
    }

    public String getName(String name){
        return name;
    }

    @Override
    public String toString(){
        return "PersonName Object { name = '" + name + "'}.";
    }
}
