package com.lee.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InfixExpressionToSuffixExpressionDemo {
    public static void main(String[] args) {
        /**
         * 1)初始化两个栈:运算符栈s1和储存中间结果的栈2;
         * 2)从左至右扫描中缀表达式;
         * 3)遇到操作数时，将其压s2;
         * 4)遇到运算符时，比较其与s1栈顶运算符的优先级:
         * 1.如果s1为空，或栈顶运算符为左括号“"，则直接将此运算符入栈;
         * 2.否则，若优先级比栈顶运算符的高，也将运算符压入s1;
         * 3.否则，将s1栈顶的运算符弹出并压入到s2中，再次转到(4-1)与s1中新的栈顶运算符相比较;
         * 5)遇到括号时:
         * (1)如果是左括号“(”，则直接压入s1
         * (2)如果是右括号“)”，则依次弹出s1栈顶的运算符，并压入s,直到遇到左括号为止，此时将这一对括号丢弃
         * 6)重复步骤2至5，直到表达式的最右边
         * 7)将s1中剩余的运算符依次弹出并压入s2
         * 8)依次弹出s2中的元素并输出，结果的逆脚为中缀表达式对应的后缀表达式
         */
        String infixExpression = "9+(3-1)*3+8/2";
        List<String> array = stringToArray(infixExpression);
        //运算符栈
        Stack<String> stack1 = new Stack<>();
        //操作数栈
        Stack<String> stack2 = new Stack<>();
        for (String s : array) {
            if (s.matches("\\d+")) {
                stack2.push(s);
            } else if (s.equals("(")) {
                stack1.push(s);
            } else if (s.equals(")")) {
                while (!stack1.peek().equals("(")) {
                    stack2.push(stack1.pop());
                }
                stack1.pop();
            } else {
                while (stack1.size() != 0 && Priority.getValue(stack1.peek()) >= Priority.getValue(s)) {
                    stack2.push(stack1.pop());
                }
                stack1.push(s);
            }
        }
        while (stack1.size()!=0){
            stack2.push(stack1.pop());
        }
        List<String> strings = new ArrayList<>();
        while (stack2.size()!=0){
            strings.add(0,stack2.pop());
        }
        System.out.println(strings);

    }

    public static List<String> stringToArray(String str) {
        List<String> strings = new ArrayList<>();
        int index = 0;
        char c;
        String num = "";
        do {
            //运算符字符

            if ((c = str.charAt(index)) < 48 || (c = str.charAt(index)) > 57) {
                strings.add("" + c);
                index++;
            } else {
                num = "";
                while (index < str.length() && (c = str.charAt(index)) >= 48 && (c = str.charAt(index)) <= 57) {
                    num += c;
                    index++;
                }
                strings.add(num);
            }
        } while (index < str.length());
        return strings;
    }
}

class Priority {
    private static int ADD = 1;
    private static int SUBTRACT = 1;
    private static int MULTIPLY = 1;
    private static int DIVIDE = 1;
    private static int LEFT = 0;

    public static int getValue(String s) {
        int res = 0;
        switch (s) {
            case "+":
                res = ADD;
                break;
            case "-":
                res = SUBTRACT;
                break;
            case "*":
                res = MULTIPLY;
                break;
            case "/":
                res = DIVIDE;
                break;
            case "(":
                res = LEFT;
                break;
            default:
                break;
        }
        return res;
    }
}
