class Count implements AutoCloseable {
    private int count = 0;
    private boolean isOpen = false;

    public Count() {
        isOpen = true;
    }

    public void add() {
        if (!isOpen) {
            throw new IllegalStateException("Счетчик закрыт!");
        }
        count++;
    }

    @Override
    public void close() {
        isOpen = false;
        System.out.println("Счетчик закрыт. Текущее значение: " + count);
    }

    public static void main(String[] args) {
        try (Count count = new Count()) {
            count.add();
            count.add();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}