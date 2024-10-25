import java.util.ArrayList;
import java.util.HashMap;

public class Registry {
    private ArrayList<Animal> animals; // Список всех животных
    private HashMap<String, ArrayList<String>> commands; // Карта для хранения команд животных

    public Registry() {
        this.animals = new ArrayList<>();
        this.commands = new HashMap<>();
    }

    // Метод для отображения меню
    public void showMenu() {
        System.out.println("1. Завести новое животное");
        System.out.println("2. Показать команды животного");
        System.out.println("3. Обучить животное новой команде");
        System.out.println("4. Показать всех животных и их команды");
        System.out.println("0. Выход");
    }

    // Метод для добавления нового животного
    public void addNewAnimal(Animal animal) {
        animals.add(animal);
        commands.put(animal.getName(), new ArrayList<>()); // Добавляем пустой список команд для нового животного
        System.out.println("Добавлено новое животное: " + animal.getName());
    }

    public void sowCommands() {
        if (animals.isEmpty()) {
            System.out.println("Животные не добавлены.");
        } else {
            for (Animal animal : animals) {
                System.out.println(animal + ", Команды: " + commands.get(animal.getName()));
            }
        }
    }
    // Метод для обучения животного новой команде
    public void trainNewCommand(String name, String command) {
        if (commands.containsKey(name)) {
            commands.get(name).add(command);
            System.out.println("Животное " + name + " выучило новую команду: " + command);
        } else {
            System.out.println("Животное с именем " + name + " не найдено.");
        }
    }

    // Метод для показа всех животных и их команд
    public void showAllAnimalsAndCommands() {
        if (animals.isEmpty()) {
            System.out.println("Животные не добавлены.");
        } else {
            for (Animal animal : animals) {
                System.out.println("Животное: " + animal.getName() + ", Команды: " + commands.get(animal.getName()));
            }
        }
    }

    public void showCommands(String animalName) {
    }
}