import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;
import java.util.stream.IntStream;

class day01b {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        
        while (sc.hasNextInt()) {
            left.add(sc.nextInt());
            right.add(sc.nextInt());
        }
        
        int similarityScore = calculateSimilarityScore(sortList(left), sortList(right));
        System.out.println("Similarity Score: " + similarityScore);
        sc.close();
    }
    
    static List<Integer> sortList(ArrayList<Integer> list) {
        return list.stream().sorted().toList();
    }

    static int countFreq(List<Integer> list, int elem) {
        return list.stream().filter(x -> x.equals(elem))
            .map(x -> 1)
            .reduce(0, (x,y) -> x + y);
    }
    
    static int calculateSimilarityScore(List<Integer> left, List<Integer> right) {
        return IntStream.range(0, left.size())
            .map(index -> left.get(index))
            .map(x -> x * countFreq(right, x))
            .reduce(0, (x,y) -> x + y);
    }
}
