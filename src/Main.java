public class Main {
    public static void main(String[] args) {
        ToyStore toyStore = new ToyStore();

        toyStore.addToy(new Toy(1, "Плюшевый мишка", 5, 20));
        toyStore.addToy(new Toy(2, "Машинка", 10, 30));
        toyStore.addToy(new Toy(3, "Футбольный мяч", 8, 25));
        toyStore.addToy(new Toy(4, "Пазл", 200, 9));

        toyStore.updateWeight(1, 15);

        // Розыгрыш игрушек
        toyStore.play();

        // Получение призовой игрушки
        Toy prizeToy = toyStore.getPrizeToy("prize_toys.txt");
        if (prizeToy != null) {
            System.out.println("Выиграна игрушка: " + prizeToy.getName());
        }
    }
}