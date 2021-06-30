package BSTs;

import javax.management.RuntimeErrorException;

public class BST implements IBST<Employee>{

    public Employee root;

    public BST leftTree, rightTree, father;

    @Override
    public boolean hasChildren() {
        return root != null && leftTree == null && rightTree == null; 
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    private void insertNode(Employee empl, BST father) {
        if (root == null) {
            this.root = empl;
            this.father = father;
        } else {
            if (empl.compareTo(root) < 0) {
                if (leftTree == null) leftTree = new BST();
                leftTree.insertNode(empl, this);
            } else if (empl.compareTo(root) > 0) {
                if (rightTree == null) rightTree = new BST();
                rightTree.insertNode(empl, this);
            } else{
                throw new RuntimeErrorException(null, "Duplicate element Employee, id already exists.");
            }
        }
    }

    
    @Override
    public void insert(Employee empl) {
        insertNode(empl, null);
        
    }

    @Override
    public boolean exist(int id) {
        if (root != null) { 
            if (id == root.getId()) {
                return true;
            } else if (leftTree != null && id < root.getId()) {
                return leftTree.exist(id);
            } else if (rightTree != null && id > root.getId()) {
                return rightTree.exist(id);
            } else {
                return false;
            }
        } else {
            return false;
        
        }
    }

    @Override
    public Employee get(int id) {
        if (root != null) {
            if (id == root.getId()) {
                return root;
            } else if (leftTree != null && id < root.getId()) {
                return leftTree.get(id);
            } else if (rightTree != null && id > root.getId()){
                return rightTree.get(id);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    private void preOrderGraphic(String layout){
        if ( root != null ){
            System.out.println(layout + root);
            if (leftTree != null) leftTree.preOrderGraphic(layout + "  ");
            if (rightTree != null) rightTree.preOrderGraphic(layout + "  ");
        } 
    }

    @Override
    public void preOrder() {
        preOrderGraphic("");
    }

    private void inOrderGraphic(String layout){
        if ( root != null ){
            if (leftTree != null) leftTree.inOrderGraphic(layout + "  ");
            System.out.println(layout + root);
            if (rightTree != null) rightTree.inOrderGraphic(layout + "  ");
        } 
    }

    @Override
    public void inOrder() {
        inOrderGraphic("");
    }

    private void postOrderGraphic(String layout){
        if ( root != null ){
            if (leftTree != null) leftTree.postOrderGraphic(layout + "  ");
            if (rightTree != null) rightTree.postOrderGraphic(layout + "  ");
            System.out.println(layout + root);
        } 
    }

    @Override
    public void postOrder() {
        postOrderGraphic("");
    }

    private BST minimun(){
        if (leftTree != null && !leftTree.isEmpty()){
            return leftTree.minimun();
        } else {
            return this;
        }
    }

    private void deleteElement(int id) {
        if (leftTree != null && rightTree != null) {
            // Delete node with 2 children
            BST min = rightTree.minimun();
            this.root = min.root;
            rightTree.remove(min.root.getId());
        } else if (leftTree != null || rightTree != null) {
            // Delete node with 1 child
            BST alternateNode = leftTree != null ? leftTree : rightTree;
            this.root = alternateNode.root;
            this.leftTree = alternateNode.leftTree;
            this.rightTree = alternateNode.rightTree;
            this.father = null;
        } else {
            // delete node with no child
            if (father != null){
                if (this == father.leftTree) father.leftTree = null;
                if (this == father.rightTree) father.rightTree = null;
                father = null;
            }
            root = null;
        }
    }

    @Override
    public void remove(int id) {
        if(root != null){
            if (id == root.getId()){
                //delete this valuie
                deleteElement(id);
            } else if (id < root.getId() && leftTree != null) {
                leftTree.remove(id);
            } else if (id > root.getId() && rightTree != null) {
                rightTree.remove(id);
            }
        }
        
    }
    
}
