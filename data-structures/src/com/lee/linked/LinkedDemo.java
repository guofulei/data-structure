package com.lee.linked;


import java.util.Scanner;

/**
 * 链表
 *
 * @guofulei24
 */
public class LinkedDemo {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        boolean run = true;
        Scanner scanner = new Scanner(System.in);
        while (run) {

            System.out.println("a->向链表添加元素");
            System.out.println("o->向链表添加元素并排序");
            System.out.println("s->展示链表");
            System.out.println("r->移除链表中某个元素");
            System.out.print("请输入你的选择：");
            char c = scanner.next().charAt(0);
            switch (c){
                case 'a':
                    System.out.print("请输入number:");
                    int i = scanner.nextInt();
                    linkedList.addToLinked(i);
                    break;
                case 'o':
                    System.out.print("请输入number:");
                    int j = scanner.nextInt();
                    linkedList.addToLinkedOrderBy(j);
                    break;
                case 's':
                    linkedList.showLinked();
                    break;
                case 'r':
                    System.out.print("请输入number:");
                    int n = scanner.nextInt();
                    linkedList.removeNode(n);
                    break;
                default:
                    break;
            }


        }

        linkedList.showLinked();
    }
}

class LinkedList{
    Linked head = new Linked(0);

    public void addToLinked(int no){
        if (head.nextNode==null){
            head.nextNode=new Linked(no);
        }else {
           Linked temp= head.nextNode;
           while (temp.nextNode!=null){
               temp=temp.nextNode;
           }
           temp.nextNode=new Linked(no);
        }
    }

    public boolean isEmpty(){
        if (head.nextNode==null){
            return true;
        }else {
            return false;
        }
    }

    public void addToLinkedOrderBy(int no){
        // 添加到temp 与 temp.next 区间
        Linked temp=head;
        while (true){
            if(temp.nextNode==null){
                break;
            }
            if(temp.nextNode.no>no){
                break;
            }
            if (temp.nextNode.no==no){
                throw new RuntimeException("该no已存在无法添加");
            }
            temp=temp.nextNode;
        }
        Linked linkedNode=new Linked(no);
        linkedNode.nextNode=temp.nextNode;
        temp.nextNode=linkedNode;
    }

    public void removeNode(int no){
         Linked temp=head;
        while (temp.nextNode!=null){
            if(temp.nextNode.no==no){
                break;
            }
            temp=temp.nextNode;
        }
        if(temp.nextNode.nextNode!=null){
            temp.nextNode=temp.nextNode.nextNode;
        }else {
            temp.nextNode=null;
        }

    }

    public void showLinked(){
        Linked temp=head;
        int i=0;
        while (temp!=null){
            System.out.printf("node：%d=%d\n",i,temp.no);
            i++;
            temp=temp.nextNode;
        }
    }
}

class Linked {
    public int no;
    public Linked nextNode;

    public Linked(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "Linked{" +
                "no=" + no +
                '}';
    }
}
