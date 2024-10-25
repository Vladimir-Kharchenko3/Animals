//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Registry registry = new Registry(); // Создаем объект реестра
        Count counter = new Count(); // Создаем объект счетчика
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            registry.showMenu();
            System.out.print("Выберите опцию: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // захват новой строки после ввода числа

            switch (choice) {
                case 1: // Завести новое животное
                    try (Count c = new Count()) { // Используем try-with-resources для работы со счетчиком
                        System.out.print("Введите имя животного: ");
                        String name = scanner.nextLine();
                        System.out.print("Введите дату рождения животного (формат ГГГГ-ММ-ДД): ");
                        String birthDate = scanner.nextLine();

                        System.out.print("Выберите тип животного (1 - Домашнее, 2 - Вьючное): ");
                        int type = scanner.nextInt();
                        scanner.nextLine(); // захват новой строки после ввода числа

                        if (type == 1) {
                            HomeAnimal newAnimal = new HomeAnimal(name, birthDate);
                            registry.addNewAnimal(newAnimal);
                        } else if (type == 2) {
                            RackAnimal newAnimal = new RackAnimal(name, birthDate);
                            registry.addNewAnimal(newAnimal);
                        } else {
                            System.out.println("Неверный выбор типа животного!");
                        }

                        counter.add(); // увеличиваем счетчик при успешном добавлении животного
                    } catch (Exception e) {
                        System.out.println("Ошибка при заведении животного: " + e.getMessage());
                    }
                    break;

                case 2: // Показать команды животного
                    System.out.print("Введите имя животного: ");
                    String animalName = scanner.nextLine();
                    registry.showCommands(animalName);
                    break;

                case 3: // Обучить животное новой команде
                    System.out.print("Введите имя животного: ");
                    String trainAnimalName = scanner.nextLine();
                    System.out.print("Введите новую команду для животного: ");
                    String command = scanner.nextLine();
                    registry.trainNewCommand(trainAnimalName, command);
                    break;

                case 4: // Показать всех животных и их команды
                    registry.showAllAnimalsAndCommands();
                    break;

                case 0: // Выход
                    running = false;
                    System.out.println("Выход из программы.");
                    break;

                default:
                    System.out.println("Неверный выбор, попробуйте снова.");
            }
        }
        scanner.close();
    }
}