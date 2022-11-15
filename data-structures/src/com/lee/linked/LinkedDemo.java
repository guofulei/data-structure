package com.lee.linked;


import java.util.Scanner;

/**
 * 单链表
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
            System.out.println("l->获取链表倒是第k个元素");
            System.out.println("g->获取链表长度");
            System.out.println("f->反转链表");
             System.out.println("h->合并两个有序链表");
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
                case 'l':
                    System.out.print("请输入number:");
                    int l = scanner.nextInt();
                    linkedList.getLastIndexNode(l);
                    break;
                case 'g':
                    int linkedLength = linkedList.getLinkedLength();
                    System.out.println("链表长度为:"+linkedLength);
                    break;
                case 'f':
                    linkedList.reversalLinked();
                    break;
                case 'h':
                    LinkedList linked1 = new LinkedList();
                    linked1.addToLinked(1);
                    linked1.addToLinked(3);
                    linked1.addToLinked(5);
                    Linked link1 = linked1.addToLinked(7);
                    LinkedList linked2 = new LinkedList();
                    linked2.addToLinked(2);
                    linked2.addToLinked(4);
                    linked2.addToLinked(6);
                    Linked link2 = linked2.addToLinked(8);
                    System.out.println("有序链表1:");
                    linked1.showLinkedByLinked(link1);
                    System.out.println("有序链表2:");
                    linked2.showLinkedByLinked(link2);
                    linked1.margeOrderlinessLinked(link1,link2);
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

    public int getLinkedLength(){
        Linked temp=head.nextNode;
        int i=0;
        while (temp!=null){
            i++;
            temp=temp.nextNode;
        }
        return i;
    }

    public void getLastIndexNode(int index){
        Linked temp=head.nextNode;
        if (temp==null){
            throw new RuntimeException("链表为空");
        }else {
            int linkedLength = getLinkedLength();
            for (int i=0;i<linkedLength-index;i++){
                temp=temp.nextNode;
            }
            System.out.println("倒是第"+index+"个节点值为"+temp.no);
        }
    }
    
    public void reversalLinked(){
        if (head.nextNode==null && head.nextNode.nextNode==null){
            System.out.println("反转后来的链表为：");
            showLinked();
        }else{
            Linked temp=head.nextNode;
            Linked next=null;
            Linked newLinked=new Linked(0);
            while (temp!=null){
               next=temp.nextNode;
               temp.nextNode=newLinked.nextNode;
               newLinked.nextNode=temp;
               temp=next;
            }
            head.nextNode=newLinked.nextNode;
            System.out.println("反转后来的链表为：");
            showLinked();
        }
    }
    
    public void margeOrderlinessLinked(Linked l1,Linked l2){
        if (l1.nextNode==null){
            Linked temp=l2.nextNode;
            while (temp!=null){
                System.out.println("Lind:"+temp.no);
                temp=temp.nextNode;
            }
        }
        if (l2.nextNode==null){
            Linked temp=l1.nextNode;
            while (temp!=null){
                System.out.println("Lind:"+temp.no);
                temp=temp.nextNode;
            }
        }
        Linked ll1=l1.nextNode;
        Linked ll2=l2.nextNode;
        Linked newLk = new Linked(0);
        Linked temp=newLk;
        while (ll1!=null && ll2!=null){
            if (ll1.no<=ll2.no){
                temp.nextNode=new Linked(ll1.no);
                ll1=ll1.nextNode;
            }else {
                temp.nextNode=new Linked(ll2.no);
                ll2=ll2.nextNode;
            }
            temp=temp.nextNode;
        }
        if (ll1!=null){
            temp.nextNode=ll1;
        }
        if (ll2!=null){
            temp.nextNode=ll2;
        }
        Linked tp=newLk;
        while (tp!=null){
            System.out.println("Link:"+tp.no);
            tp=tp.nextNode;
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
