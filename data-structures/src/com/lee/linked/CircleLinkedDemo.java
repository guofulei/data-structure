package com.lee.linked;

/**
 * 环形链表
 * @guofulei24
 */
public class CircleLinkedDemo {
    public static void main(String[] args) {
        CircleLinked circleLinked = new CircleLinked();
        circleLinked.creatCircleLinked(8);
        circleLinked.showCircleLinked();
    }
}

class CircleLinked{
    public Node head=null;
    public void creatCircleLinked(int number){
        Node temp=null;
        for (int i=0;i<number;i++){
           Node node =new Node(i);
            if (i==0){
                head=node;
                head.setNext(node);
                temp=head;
            }else {
                temp.setNext(node);
                node.setNext(head);
                temp=node;
            }
        }
    }
    public void showCircleLinked(){
        if (head==null){
            throw new RuntimeException("环形链表为空！");
        }else {
            Node temp=head;
            while (temp!=null){
                System.out.println(temp.toString());
                if (temp.getNext()==head){
                    return;
                }
                temp=temp.getNext();
            }
        }
    }
}

class Node{
    public Integer no;
    public Node next;

    public Node(Integer no) {
        this.no = no;
    }

    public Integer getNo() {
        return no;
    }
    public void setNo(Integer no) {
        this.no = no;
    }
    public Node getNext() {
        return next;
    }
    public void setNext(Node next) {
        this.next = next;
    }
    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                '}';
    }
}
