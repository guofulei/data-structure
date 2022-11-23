package com.lee.stack;

/**
 * 计算器
 * @guofulei24
 */
public class EvaluatorExpressionDemo {
    public static void main(String[] args) {
        StackArr stackArr1 = new StackArr(10);
        StackArr stackArr2 = new StackArr(10);
        int index=0;
        int number1=0;
        int number2=0;
        char str;
        //编辑每个字符
        while (true){
            //如果是运算符
            if (){
                //当前运算符小于等于运算符栈末的运算符
                if(){

                }else {
                 //当前运算符大于运算符栈末的运算符

                }
            }else {
            //否则就是数字

            }
            index++;
        }
    }
    public static int operationPriority(char a){
        if (a=='*' || a=='/'){
            return 1;
        }else if(a=='+' || a=='-'){
            return 0;
        }else {
            return -1;
        }
    }

    public static int operation(int number1,int number2,char s){
        int res=0;
        switch (s){
            case '+':
                res=number1+number2;
                break;
            case '-':
                res=number2-number1;
                break;
            case '*':
                res=number1*number2;
                break;
            case '/':
                res=number2/number1;
                break;
            default:
                break;
        }
        return res;
    }
}

class StackArr {
    public int maxSize;
    public int[] stack;
    public int top = -1;

    public StackArr(int size) {
        this.maxSize = size;
        stack = new int[maxSize];
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void pushStack(int no) {
        if (isFull()) {
            throw new RuntimeException("栈已满");
        }
        top++;
        stack[top] = no;
    }

    public int popStack() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        int value = stack[top];
        top--;
        return value;
    }

    public void showStack() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }
}
