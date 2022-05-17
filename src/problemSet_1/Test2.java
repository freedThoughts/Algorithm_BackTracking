package problemSet_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Test2 {

    public static void main(String[] arg) {

        List<Integer> bundleQuantities = new ArrayList<>();
        bundleQuantities.add(20);
        bundleQuantities.add(19);
        List<Integer> bundleCosts = new ArrayList<>();
        bundleCosts.add(24);
        bundleCosts.add(20);



    System.out.println(budgetShopping(50, bundleQuantities, bundleCosts));


    }

    public static int budgetShopping(int n, List<Integer> bundleQuantities, List<Integer> bundleCosts) {

        Set<Node> set = new TreeSet<Node>((n1, n2) -> n1.rate.compareTo(n2.rate));
        for (int i = 0; i < bundleQuantities.size(); i++) {
            set.add(new Node((double)bundleCosts.get(i)/ bundleQuantities.get(i), i));
        }

        int ans = 0;
        for (Node node : set) {
            int quant = (int) (n / node.rate);
            int q = quant / bundleQuantities.get(node.index);
            ans = ans + q*bundleQuantities.get(node.index);
            n = n - (q * bundleCosts.get(node.index));
            if (n <= 0) return ans;
        }

        return ans;


    }

    public static class Node {
        Double rate;
        int index;
        Node (double rate, int index) {
            this.rate = rate;
            this.index = index;
        }
    }
}
