public class HomeAnimal extends Animal {
    public HomeAnimal(String name, String birthDate) {
        super(name, birthDate);
    }

    // Переопределяем toString для домашнего животного (если нужны дополнительные данные)
    @Override
    public String toString() {
        return "Домашнее животное - " + super.toString();
    }
}