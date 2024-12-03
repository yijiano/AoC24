import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;
import java.util.stream.IntStream;

class day01a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        
        while (sc.hasNextInt()) {
            left.add(sc.nextInt());
            right.add(sc.nextInt());
        }
        
        int totalDistance = calculateTotalDistance(sortList(left), sortList(right));
        System.out.println("Total Distance: " + totalDistance);
        sc.close();
    }
    
    static <T extends Comparable<T>> List<T> sortList(ArrayList<T> list) {
        return list.stream().sorted().toList();
    }
    
    static int calculateTotalDistance(List<Integer> left, List<Integer> right) {
        return IntStream.range(0, left.size())
            .parallel()
            .map(index -> Math.abs(left.get(index) - right.get(index)))
            .reduce(0, (x,y) -> x + y);
    }
}
