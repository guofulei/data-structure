package com.lee.linked;

/**
 * 双链表
 * @guofulei24
 */
public class DoubleLinkedDemo {
    public static void main(String[] args) {
        DoubleLinked doubleLinked = new DoubleLinked();
//         HeroNode2 linked1 = new HeroNode2(1, "linked1");
//         HeroNode2 linked2 = new HeroNode2(2, "linked2");
//         HeroNode2 linked3 = new HeroNode2(3, "linked3");
//         HeroNode2 linked4 = new HeroNode2(4, "linked4");
//         HeroNode2 linked5 = new HeroNode2(5, "linked5");
//         HeroNode2 linked6 = new HeroNode2(6, "linked6");
//         doubleLinked.add(linked1);
//         doubleLinked.add(linked2);
//         doubleLinked.add(linked3);
//         doubleLinked.add(linked4);
//         doubleLinked.add(linked5);
//         doubleLinked.add(linked6);

//         System.out.println("链表为：");
//         doubleLinked.show();
//         doubleLinked.delete(3);
        HeroNode2 linked1 = new HeroNode2(1, "linked1");
        HeroNode2 linked2 = new HeroNode2(7, "linked7");
        HeroNode2 linked3 = new HeroNode2(4, "linked4");
        HeroNode2 linked4 = new HeroNode2(3, "linked3");
        HeroNode2 linked5 = new HeroNode2(2, "linked2");
        HeroNode2 linked6 = new HeroNode2(6, "linked6");
        System.out.println("链表为：");
        doubleLinked.addOrderBy(linked1);
        doubleLinked.addOrderBy(linked2);
        doubleLinked.addOrderBy(linked3);
        doubleLinked.addOrderBy(linked4);
        doubleLinked.addOrderBy(linked5);
        doubleLinked.addOrderBy(linked6);
        doubleLinked.show();
        System.out.println("链表为：");
        doubleLinked.show();
    }
}

class DoubleLinked{
    HeroNode2 head=new HeroNode2(0,"");

    public void show(){
        if (head.next==null){
            throw new RuntimeException("链表为空");
        }
        HeroNode2 temp=head.next;
        while (temp!=null){
            System.out.println("Node:"+temp.toString());
            temp=temp.next;
        }
    }

    public void add(HeroNode2 node){
        if (head.next==null){
            head.next=node;
            node.pre=head;
        }else {
            HeroNode2 temp=head.next;
            while (temp.next!=null){
                temp=temp.next;
            }
            temp.next=node;
            node.pre=temp;
        }
    }
    
     public void addOrderBy(HeroNode2 node2) {
        HeroNode2 temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > node2.no) {
                break;
            }
            if (temp.next.no == node2.no) {
                flag = false;
                break;
            }
            temp=temp.next;
        }
        if (!flag) {
            //在尾部添加
            if (temp.next == null) {
                temp.next = node2;
                node2.pre = temp;
            }
            //在temp temp.next 之间添加
            else {
                node2.pre = temp;
                node2.next = temp.next;
                temp.next = node2;
                node2.next.pre = node2;
            }
        } else {
            throw new RuntimeException("该序号已存在");
        }
    }

    public void update(HeroNode2 node){
        if (head.next==null){
            throw new RuntimeException("链表为空");
        }
        HeroNode2 temp= head.next;
        boolean start=false;
        while (true){
            if(temp.next==null){
                return;
            }
            if(temp.no==node.no){
                start=true;
                break;
            }
            temp=temp.next;
        }
        if (start){
            temp.name=node.name;
        }else {
            System.out.println("没有找到");
        }
    }

    public void delete(int no){
        if (head.next==null){
            throw new RuntimeException("链表为空");
        }else {
            HeroNode2 temp=head.next;
            while (temp!=null){
                if (temp.no==no){
                    break;
                }
                temp=temp.next;
            }
            temp.pre.next=temp.next;
            if (temp.next!=null){
                temp.next.pre=temp.pre;
            }
        }
    }

}

class HeroNode2{
    public int no;
    public String name;
    public HeroNode2 pre;
    public HeroNode2 next;

    public HeroNode2(int no, String name) {
        this.no = no;
        this.name = name;
    }
    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

}
