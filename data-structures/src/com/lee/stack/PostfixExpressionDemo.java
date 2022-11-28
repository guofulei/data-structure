package com.lee.stack;

import java.util.Stack;

/**
 * 后缀表达式
 * @guofulei24
 */
public class PostfixExpressionDemo {
    public static void main(String[] args) {
        String expression="10 , 6 , 9 , 3 , + , -11 , * , / , * , 17 , + , 5 , +";
        String[] expressionArr = expression.split(" , ");
        Stack<String> stack = new Stack<>();
        for (String item: expressionArr){
            if (!isNumber(item)){
                stack.push(item);
            }else {
                Integer popRight = Integer.parseInt(stack.pop());
                Integer popLeft = Integer.parseInt(stack.pop());
                Integer res=0;
                switch (item){
                    case "*":
                        res=popLeft*popRight;
                        break;
                    case "/":
                        res=popLeft/popRight;
                        break;
                    case "+":
                        res=popLeft+popRight;
                        break;
                    case "-":
                        res=popLeft-popRight;
                        break;
                    default:
                        throw new RuntimeException("运算父错误");
                }
                stack.push(res.toString());
            }
        }
        System.out.println("后缀表达式："+expression+"运算结果为："+stack.pop());
    }

    private static boolean isNumber(String s){
        return s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/");
    }
}
