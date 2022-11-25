package com.lee.stack;

/**
 * 计算器
 *
 * @guofulei24
 */
public class EvaluatorExpressionDemo {
    public static void main(String[] args) {
        String expression = "97+9*6-2";
        StackArr stackArr1 = new StackArr(10);
        StackArr stackArr2 = new StackArr(10);
        int index = 0;
        int number1 = 0;
        int number2 = 0;
        char str;
        String num = "";
        //编辑每个字符
        while (true) {
            str = expression.substring(index, index + 1).charAt(0);
            //如果是运算符
            if (stackArr2.isOperator(str)) {
                //运算符栈不为空
                if (!stackArr2.isEmpty()) {
                    //当前运算符小于等于运算符栈末的运算符
                    if (stackArr2.operationPriority(str) <= stackArr2.operationPriority((char) stackArr2.peek())) {
                        number1 = stackArr1.popStack();
                        number2 = stackArr1.popStack();
                        char s = (char) stackArr2.popStack();
                        int res = stackArr2.operation(number1, number2, s);
                        stackArr1.pushStack(res);
                        stackArr2.pushStack(str);
                    } else {
                        //当前运算符大于运算符栈末的运算符
                        stackArr2.pushStack(str);
                    }
                } else {
                    stackArr2.pushStack(str);
                }
            } else {
                //否则就是数字

                num += str;
                //连续数字
                if (index == expression.length() - 1) {
                    stackArr1.pushStack(Integer.parseInt(num));
                } else if (stackArr1.isOperator(expression.substring(index + 1, index + 2).charAt(0))) {
                    stackArr1.pushStack(Integer.parseInt(num));
                    num = "";
                }
            }
            index++;
            if (index == expression.length()) {
                break;
            }
        }
        while (true) {
            if(stackArr2.isEmpty()){
                break;
            }
            number1 = stackArr1.popStack();
            number2 = stackArr1.popStack();
            char s = (char) stackArr2.popStack();
            int res = stackArr2.operation(number1, number2, s);
            stackArr1.pushStack(res);
        }
        System.out.println("表达式" + expression + "结果为" + stackArr1.popStack());
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

    public int operation(int number1, int number2, char s) {
        int res = 0;
        switch (s) {
            case '+':
                res = number1 + number2;
                break;
            case '-':
                res = number2 - number1;
                break;
            case '*':
                res = number1 * number2;
                break;
            case '/':
                res = number2 / number1;
                break;
            default:
                break;
        }
        return res;
    }

    public int operationPriority(char a) {
        if (a == '*' || a == '/') {
            return 1;
        } else if (a == '+' || a == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    public boolean isOperator(char c) {
        return c == '*' || c == '/' || c == '-' || c == '+';
    }

    public int peek() {
        return stack[top];
    }
}
