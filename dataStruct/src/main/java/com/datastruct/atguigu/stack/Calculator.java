package com.datastruct.atguigu.stack;

import com.datastruct.newcode.stack.Stack;

public class Calculator {

    class StackCal<E> extends Stack<E> {

        public boolean operator(char ch) {
            return ch == '+' || ch == '-' || ch == '*' || ch == '/';
        }

        public int calculator(int num1, int num2, char ch) {
            int res = 0;
            switch (ch) {
                case '+':
                    res = num1 + num2;
                    break;
                case '-':
                    res = num1 - num2;
                    break;
                case '*':
                    res = num1 * num2;
                    break;
                case '/':
                    res = num1 / num2;
                    break;
                default:
                    break;
            }
            return res;
        }

        public int priority(char ch) {
            if (ch == '+' || ch == '-') {
                return 0;
            } else if (ch == '*' || ch == '/') {
                return 1;
            } else {
                return -1;
            }
        }
    }


    public int analysis(String str) {

        StackCal<String> numStack = new StackCal();
        StackCal operatorStack = new StackCal();

        int index = 0;
        char ch = ' ';
        boolean flag = true;
        StringBuilder number = new StringBuilder();
        while (true) {
            ch = str.charAt(index);
            //如果是操作符
            if (operatorStack.operator(ch)) {
                flag = false;
                //如果操作符栈是空的
                if (operatorStack.isEmpty()) {
                    operatorStack.push(ch);
                } else {
                    //如果操作符栈不是空的，需要比较当前元素与栈顶元素的优先级
                    // 当前元素的优先级> 栈顶元素的优先级
                    if (operatorStack.priority(ch) > operatorStack.priority((char) operatorStack.peek())) {
                        operatorStack.push(ch);
                    } else {
                        //当前元素优先级<= 栈顶元素优先级
                        // 数据栈取出两个元素，符号栈取出栈顶元素
                        char operator = (char) operatorStack.pop();
                        String pop1 = numStack.pop();
                        String pop2 = numStack.pop();
                        int num1 = Integer.parseInt(pop1);
                        int num2 = Integer.parseInt(pop2);

                        //计算出具体的值，然后入栈
                        int calculator = operatorStack.calculator(num1, num2, operator);
                        numStack.push(String.valueOf(calculator));
                        operatorStack.push(ch);
                    }
                }
            } else {
                // 如果是数字，需要考虑多位数
                if (flag) {
                    if (numStack.isEmpty()) {
                        number.append(ch);
                        String string = number.toString();
                        numStack.push(string);
                    } else {
                        int pop = Integer.parseInt(numStack.pop());
                        number.append(ch + (char) pop);
                        numStack.push(number.toString());
                    }

                } else {
                    numStack.push(String.valueOf(ch));
                }
                flag = true;
            }
            index++;
            if (index > str.length() - 1) {
                break;
            }
        }
        while (!numStack.isEmpty() && !operatorStack.isEmpty()) {
            //当前元素优先级<= 栈顶元素优先级
            // 数据栈取出两个元素，符号栈取出栈顶元素
            char operator = (char) operatorStack.pop();
            String pop2 = numStack.pop();
            String pop1 = numStack.pop();
            int num2 = Integer.parseInt(pop2);
            int num1 = Integer.parseInt(pop1);

            //计算出具体的值，然后入栈
            int calculator = operatorStack.calculator(num1, num2, operator);
            numStack.push(String.valueOf(calculator));
        }
        return Integer.parseInt(numStack.pop());
    }

    public static void main(String[] args) {
        String string = "28+4/2*10";
        int res = new Calculator().analysis(string);
        System.out.println(res);
    }

}
