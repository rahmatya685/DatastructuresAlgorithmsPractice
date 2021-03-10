package mosh.tree;

public class Main {
    public static void main(String[] args) {
        CustomTree customTree=new CustomTree();
        customTree.insert(7);
        customTree.insert(4);
        customTree.insert(9 );
        customTree.insert(1);
        customTree.insert(6);
        customTree.insert(8);
        customTree.insert(10);

        System.out.println("hasValue=> " + customTree.find(0));
    }
}
