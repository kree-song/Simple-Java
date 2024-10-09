package com.xsq._2stack.use;

import com.xsq._2stack.MyArrayStack;

/*
 * 使用栈来计算算术表达式的值
 * */
public class CalculateExpression {
    public static void main(String[] args) {
        String expression = "4+3+(6-10+2*3)*4";
        double result = calculate(expression);
        System.out.println(result);
        /*int a=4+3+(6-10+2*3)*4;
        System.out.println(a);*/
    }

    //定义方法计算指定表达式的值
    private static double calculate(String expression) {
        MyArrayStack operatorStack = new MyArrayStack(); //存储操作符
        MyArrayStack operandStack = new MyArrayStack();  //存储操作数

        //遍历表达式中的操作数与操作符
        for (int i = 0; i < expression.length(); i++) {
            char cc = expression.charAt(i);
            //如果cc是数字
            if (Character.isDigit(cc)) {
                //取出操作数，只要是数字就是操作数的一部分
                StringBuilder sb = new StringBuilder();
                while (Character.isDigit(cc)) {//445464564
                    sb.append(cc);
                    i++;//取下一个字符
                    if (i >= expression.length()) {
                        break;
                    }
                    cc = expression.charAt(i);//取下一个字符
                }
                //操作数入栈
                operandStack.push(sb.toString());
                //修正i变量的值
                i--;
                //System.out.println(sb);
            } else {  //如果是操作符
                //1)栈为空，直接把操作符入栈
                if (operatorStack.isEmpty()) {
                    operatorStack.push(cc);
                    continue;
                }
                //2)操作符栈不为空的情况
                while (!operatorStack.isEmpty()) {
                    char op1 = (char) operatorStack.peek();
                    //判断栈中运算符与当前运算符的优先级
                    if (compareOperator(op1, cc) < 0) {
                        //当前运算符的优先级高于栈顶运算符优先级
                        operatorStack.push(cc);
                        break;
                    } else if (compareOperator(op1, cc) == 0) {
                        //当前运算符的优先级等于栈顶运算符优先级，只有一种情况，左一半括弧遇到右一半括弧
                        operatorStack.pop();  //左一半小括弧出栈
                        break;
                    } else {    //栈顶运算符优先级高
                        //取出两个操作数
                        double num1 = Double.parseDouble(operandStack.pop().toString());
                        double num2 = Double.parseDouble(operandStack.pop().toString());
                        //取栈顶运算符
                        char operator = (char) operatorStack.pop();
                        //计算num2 op num1
                        double result = compute(operator, num2, num1);
                        //把结果存储到操作数栈中
                        operandStack.push(result);
                        //如果当前操作符栈为空，新的操作符入栈
                        if (operatorStack.isEmpty()) {
                            operatorStack.push(cc);
                            break;
                        }
                    }
                }
            }
        }

        //当表达式遍历完后，如果操作符栈不为空，需要继续计算
        while (!operatorStack.isEmpty()) {
            char operator = (char) operatorStack.pop();
            //如果操作数栈为空，表达式错误
            if (operandStack.isEmpty()) {
                throw new RuntimeException("表达式错误");
            }

            double num1 = Double.parseDouble(operandStack.pop().toString());
            if (operandStack.isEmpty()) {
                throw new RuntimeException("表达式错误");
            }
            double num2 = Double.parseDouble(operandStack.pop().toString());
            double result = compute(operator, num2, num1);
            operandStack.push(result);
        }
        //当操作符栈为空，操作数栈中多于一个数，表达式错误
        if (operandStack.getSize() > 1) {
            throw new RuntimeException("表达式错误");
        }
        return Double.parseDouble(operandStack.pop().toString());
    }


    //计算num2 op num1
    private static double compute(char operator, double num1, double num2) {
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                return num1 / num2;
        }
        return 0;
    }

    //判断两个运算符的优先级,如果op1优先级高返回正数，如果op2优先级高返回负数
    private static int compareOperator(char op1, char op2) {
        if (op1 == '+' || op1 == '-') {
            if (op2 == '*' || op2 == '/' || op2 == '(') {
                return -1;
            }
        }
        if (op1 == '*' || op1 == '/') {
            if (op2 == '(') {
                return -1;
            }
        }
        if (op1 == '(') {
            if (op2 == ')') {
                return 0;
            } else {
                return -1;
            }
        }
        return 1;
    }
}
