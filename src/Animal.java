public abstract class Animal {
    private String name;
    private String birthDate;

    public Animal(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    // Переопределяем метод toString для вывода информации о животном
    @Override
    public String toString() {
        return "Животное: " + name + ", Дата рождения: " + birthDate;
    }
}