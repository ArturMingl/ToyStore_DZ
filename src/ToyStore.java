import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class ToyStore {
    private Queue<Toy> toys;
    private Queue<Toy> prizeToys;

    public ToyStore() {
        toys = new LinkedList<>();
        prizeToys = new LinkedList<>();
    }

    public void addToy(Toy toy) {
        int count = toy.getQuantity();
        for (int i = 0; i < count; i++)
            toys.add(toy);
    }

    public void updateWeight(int toyId, double weight) {
        for (Toy toy : toys) {
            if (toy.getId() == toyId) {
                toy.setWeight(weight);
                break;
            }
        }
    }

    public void play() {
        double totalWeight = 0;
        for (Toy toy : toys) {
            totalWeight += toy.getWeight();
        }

        Random random = new Random();
        double randomNumber = random.nextDouble() * totalWeight;

        double cumulativeWeight = 0;
        for (Toy toy : toys) {
            cumulativeWeight += toy.getWeight();
            if (randomNumber <= cumulativeWeight) {
                prizeToys.add(toy);
                toys.remove(toy);
                break;
            }
        }
    }

    public Toy getPrizeToy(String filename) {
        if (prizeToys.isEmpty()) {
            return null;
        }
        Toy prizeToy = prizeToys.poll();

        try {
            FileWriter writer = new FileWriter(filename, true);
            writer.write("id:" + prizeToy.getId() + " " + prizeToy.getName() + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл игрушки");
        }

        return prizeToy;
    }
}