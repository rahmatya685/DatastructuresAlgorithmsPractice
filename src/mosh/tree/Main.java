package mosh.tree;

public class Main {
    public static void main(String[] args) {
        CustomTree customTree = new CustomTree();
        customTree.insert(1);
        customTree.insert(2);
        customTree.insert(3);
        customTree.insert(4);
        customTree.insert(5);
        customTree.insert(7);
        customTree.insert(4);
        customTree.insert(9);
        customTree.insert(1);
        customTree.insert(6);
        customTree.insert(8);
        customTree.insert(10);
        customTree.insert(16);


        System.out.println("hasValue=> " + customTree.find(0));

        System.out.println("Facorial 10=> " + factorial(10));
        System.out.println("factorialRec 4=> " + factorialRec(10));

        customTree.traversePreOrder();

        System.out.println("traversePostOrder");
        customTree.traversePostOrder();

        System.out.println(" customTree.height()=> " + customTree.height());

        System.out.println(" customTree.depth()=> " + customTree.depth());


        System.out.println(" customTree.maxDepth()=> " + customTree.maxDepth());

        System.out.println(" minimum value in tree=>"+ customTree.minValue());

        System.out.println(" minInBinarySearchIteration =>"+ customTree.minInBinarySearchIteration());


        CustomTree customTree2 = new CustomTree();

        customTree2.insert(1);
        customTree2.insert(2);
        customTree2.insert(3);
        customTree2.insert(4);
        customTree2.insert(5);
        customTree2.insert(7);
        customTree2.insert(4);
        customTree2.insert(9);
        customTree2.insert(1);
        customTree2.insert(6);
        customTree2.insert(8);
        customTree2.insert(10);

        System.out.println("Equality => "+customTree.equals(customTree2));
    }


    public static int factorial(int num) {
        var sum = 1;
        for (int i = num; i > 1; i--) {
            sum *= i;
        }
        return sum;
    }

    public static int factorialRec(int num) {
        if (num == 0)
            return 1;
        else
            return num * factorialRec(num - 1);
    }


}
