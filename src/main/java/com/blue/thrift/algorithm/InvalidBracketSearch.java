package com.blue.thrift.algorithm;

import java.util.*;

/**
 * 删除最小数量的无效括号，使得输入的字符串有效，返回所有可能的结果。
 * 说明: 输入可能包含了除 ( 和 ) 以外的字符。
 * <p>
 * <p>
 * 示例-1
 * 输入: "()())()"
 * 输出: ["()()()", "(())()"]
 * <p>
 * 示例-2
 * 输入: "(a)())()"
 * 输出: ["(a)()()", "(a())()"]
 * <p>
 * 示例-3
 * 输入: ")("
 * 输出: [""]
 * <p>
 * 题目解析
 * 所谓有效的括号，那么字符串中的左右括号数应该相同，而且每个右括号左边一定有其对应的左括号。这里很容易想到使用一个栈来模拟匹配过程，'(' 入栈，')' 出栈，若栈为空说明该串是符合题意的。
 * 首先对括号进行删除，遍历从前往后遍历可以删除不符合的 ')' 括号，从后往前遍历可以删除不符合的'('括号，通过 BFS，不断的对队列的字符串进行 checkLeft 和 checkRight 操作，若遇到 ture，
 * 则说明当前的字符串已经是删除最少无效的括号的最优解了，接着就对队列中的其他字符串进行 check 即可。
 * 这道题目的动画与 LeetCode 第 20 号问题--有效的括号很类似，这里就拿出来进行参考理解一下，区别点就在于多了遍历和哈希存储。
 * <p>
 * Created by zs on 2019/5/24.
 */
public class InvalidBracketSearch {

    public static void main(String[] asss) {
        Solution solution = new Solution();

        String testStr = "()())()";
        System.out.println(testStr);
        System.out.println("==========");

        List<String> result = solution.removeInvalidParentheses(testStr);

        result.stream().forEach(s -> System.out.println(s));
    }


    public static class Solution {
        Set<String> vis = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        public List<String> removeInvalidParentheses(String s) {
            queue.offer(s);
            vis.add(s);
            boolean flag = false;
            List<String> ans = new ArrayList<>();
            while (!queue.isEmpty()) {
                String cur = queue.poll();
                if (flag) {
                    check(cur, ans);
                } else {
                    flag = checkLeft(cur, ans) || checkRight(cur, ans);
                }
            }
            if (ans.size() == 0) {
                ans.add("");
            }
            return new ArrayList<String>(ans);
        }


        public void check(String s, List<String> ans) {  //查看是否正确
            Stack<Character> st = new Stack<Character>();
            for (char c : s.toCharArray()) {
                if (c == '(') {
                    st.push(c);
                }
                if (c == ')') {
                    if (st.isEmpty()) {
                        return;
                    }
                    st.pop();
                }
            }
            if (st.isEmpty()) {
                ans.add(s);
            }
        }

        public boolean checkLeft(String trs, List<String> ans) { //检查左边
            //delete right
            Stack<Character> st = new Stack<Character>();
            for (int i = 0; i < trs.length(); ++i) {

                if (trs.charAt(i) == '(') {
                    st.push(trs.charAt(i));
                } else if (trs.charAt(i) == ')') {

                    if (st.isEmpty()) {
                        for (int j = i; j >= 0; --j) { //删除不符合的 ')' 的种情况
                            if (trs.charAt(j) == ')') {
                                String s1 = trs.substring(0, j) + trs.substring(j + 1);
                                if (!vis.contains(s1)) {
                                    vis.add(s1);
                                    queue.offer(s1);
                                }
                            }
                        }
                        return false;
                    } else {
                        st.pop();
                    }
                }
            }
            if (st.isEmpty()) {
                ans.add(trs);
                return true;
            }
            return false;
        }

        public boolean checkRight(String s, List<String> ans) { //检查右边
            //delete right
            Stack<Character> st = new Stack<Character>();
            st.clear();
            for (int i = s.length() - 1; i >= 0; --i) {
                if (s.charAt(i) == ')') {
                    st.push(s.charAt(i));
                } else if (s.charAt(i) == '(') {
                    if (st.isEmpty()) {
                        for (int j = i; j < s.length(); ++j) {
                            if (s.charAt(j) == '(') {  //删除不符合的'(' 多种情况
                                String s1 = s.substring(0, j) + s.substring(j + 1);
                                if (!vis.contains(s1)) {
                                    vis.add(s1);
                                    queue.add(s1);
                                }
                            }
                        }
                        return false;
                    } else {
                        st.pop();
                    }
                }
            }
            if (st.isEmpty()) {
                ans.add(s);
                return true;
            }
            return false;
        }
    }

}
