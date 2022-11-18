package com.lee.linked;

/**
 * 环形链表
 * @guofulei24
 */
public class CircleLinkedDemo {
    public static void main(String[] args) {
        CircleLinked circleLinked = new CircleLinked();
        circleLinked.creatCircleLinked(5);
        circleLinked.showCircleLinked();
        circleLinked.outOfLoop(1,2);
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
     /**
     * 出圈
     * @param startNo  从第startNo开始数
     * @param countNumber   每次数countNumber个
     */
    public void outOfLoop(int startNo,int countNumber){
        int circleLinkedSize = getCircleLinkedSize();
        if(head==null && startNo<0 && startNo>circleLinkedSize && countNumber>circleLinkedSize ){
            throw new RuntimeException("出圈数据错误");
        }
        // 辅助指针指向 head尾部
        Node temp=head;
        while (true){
            if (temp.getNext()==head){
                break;
            }
            temp=temp.getNext();
        }
        // 将head 和temp 同时移动startNo-1次
        for(int i=1;i<=startNo-1;i++){
            head=head.getNext();
            temp=temp.getNext();
        }
       while (true){
           if (temp==head){
               break;
           }
           // 循环countNumber-1 次出圈
           for (int i=1;i<=countNumber-1;i++){
               head=head.getNext();
               temp=temp.getNext();
           }
           System.out.println("出圈的NO为:"+head.toString());
           head=head.getNext();
           temp.setNext(head);
       }
        System.out.println("最后出圈的NO为:"+head.toString());
    }

    public int getCircleLinkedSize(){
        if (head==null){
            throw new RuntimeException("链表为空");
        }
        Node temp=head;
        int size=0;
        while (temp!=null){
            size++;
            if (temp.getNext()==head){
                break;
            }
            temp=temp.getNext();
        }
        return size;
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
