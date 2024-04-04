


public class MainApp {

    public static void main(String[] args) {

        Person person = new Person("Иванов","Иван", 20);

        String json = person.serializeToJson();

        System.out.println("В JSON ________________");
        System.out.println(person.serializeToJson());

        System.out.println("В Person + Person.toString()____________");
        Person deserializedPerson = Person.deSerialize(json);
        System.out.println(deserializedPerson.toString());

    }

}
