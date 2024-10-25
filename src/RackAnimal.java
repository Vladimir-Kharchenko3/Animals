public class RackAnimal extends Animal {
    public RackAnimal(String name, String birthDate) {
        super(name, birthDate);
    }

    // Переопределяем toString для вьючного животного
    @Override
    public String toString() {
        return "Вьючное животное - " + super.toString();
    }
}