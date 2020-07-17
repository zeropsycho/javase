package javase.conllection;

import sun.reflect.generics.tree.Tree;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSets implements Comparator {

    private String name;
    public static void main(String[] args) {

        TreeSets treeSets = new TreeSets();
//        treeSets.name = "zhang";

        TreeSets treeSets2 = new TreeSets();
        treeSets2.name = "zdf";

        TreeSets treeSets1 = new TreeSets();
        treeSets1.name = "32d2";

        TreeSet treeSet = new TreeSet(new TreeSets());
        treeSet.add(treeSets1);
        treeSet.add(treeSets2);

//        treeSets.compareTo(treeSet);
        treeSets.compare(treeSets2, treeSets1);


//        for (int i = 10; i > 0; i--) {
//
//
//            treeSet.add(i);
//        }

        for (Object j : treeSet) {
            System.out.println(((TreeSets)j).name);
        }

    }


    /**
     * 自定义排序规则 从小到大
     * @param compareTo
     * @return
     */
    /*@Override
    public int compareTo(Object o) {
        int index = 0;
        if (o instanceof TreeSets) {
            TreeSets te = (TreeSets) o;
            if (te.name.length() < this.name.length()) {
                index = 1;
            } else if (te.name.length() > this.name.length()) {
                index = -1;
            } else {
                index = 0;
            }
        }
        return index;
    }*/

    @Override
    public int compare(Object o1, Object o2) {
        int index = 0;
        if (o1 instanceof TreeSets && o2 instanceof TreeSets) {

            if (((TreeSets) o1).name.length() < ((TreeSets) o2).name.length()) {
                index = -1;
            } else if (((TreeSets) o1).name.length() > ((TreeSets) o2).name.length()) {
                index = 1;
            }
        }
        return index;
    }
}
