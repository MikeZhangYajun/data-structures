package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {

	public static void main(String[] args) {
		
		String expression = "1+((2+3)*4)-5";
		List<String> infixExpreesionList = toInfixExpreesionList(expression);
		System.out.println(infixExpreesionList);
		List<String> suffixExpressionList = parseSuffixExpressionList(infixExpreesionList);
		System.out.println(suffixExpressionList);
		
		
		
		
		
		
//		String suffixExpression = "4 5 * 8 - 60 + 8 2 / +";
//		List<String> list = getListString(suffixExpression);
//		System.out.println("List="+list);
//		
//		
		System.out.println("计算的结果是 "+ calculate(suffixExpressionList));
		
	}
	
	public static List<String> toInfixExpreesionList(String s){
		List<String> ls = new ArrayList<String>();
		int i = 0;
		String str;
		char c;
		do {
			if((c=s.charAt(i))<48||(c=s.charAt(i))>57) {
				ls.add(""+c);
				i++;
			}else {
				str="";
				while(i<s.length() && (c=s.charAt(i))>=48 && (c=s.charAt(i))<=57) {
					str+=c;
					i++;
				}
				ls.add(str);
			}
		} while (i<s.length());
		return ls;
	}
	
	public static List<String> parseSuffixExpressionList(List<String> ls){
		Stack<String> s1 = new Stack<String>();
		ArrayList<String> s2 = new ArrayList<String>();
		for(String item : ls) {
			if(item.matches("\\d+")) {
				s2.add(item);
			}else if(item.equals("(")) {
				s1.push(item);
			}else if(item.equals(")")) {
				while(!s1.peek().equals("(")) {
					s2.add(s1.pop());
				}
				s1.pop();
			}else {
				while(s1.size()!=0 && Operation.getValue(s1.peek())>=Operation.getValue(item)) {
					s2.add(s1.pop());
				}
				s1.push(item);
			}
		}
		while(s1.size()!=0) {
			s2.add(s1.pop());
		}
		return s2;
	}
	
	
	
	
	
	
	
	public static List<String> getListString(String suffixExpression){
		String[] split = suffixExpression.split(" ");
		List<String> list = new ArrayList<String>();
		for(String ele: split) {
			list.add(ele);
		}
		return list;
	}
	
	 static int calculate(List<String> ls) {
		 Stack<String> stack = new Stack<String>();
		 for(String item: ls) {
			 if(item.matches("\\d+")) {
				 stack.push(item);
			 }else {
				 int num2 = Integer.parseInt(stack.pop());
				 int num1 = Integer.parseInt(stack.pop());
				 int res = 0;
				 if(item.equals("+")) {
					 res=num1+num2;
				 }else if(item.equals("-")) {
					 res=num1-num2;
				 }else if(item.equals("*")) {
					 res=num1*num2;
				 }else if(item.equals("/")) {
					 res=num1/num2;
				 }else {
					 throw new RuntimeException("运算符有误~~");
				 }
				 stack.push(""+res);
			 }
		 }
		 return Integer.parseInt(stack.pop());
	 }
}

class Operation{
	public static int getValue(String operation) {
		int result = 0;
		switch (operation) {
		case "+":
			result=1;
			break;
		case "-":
			result=1;
			break;
		case "*":
			result=2;
			break;
		case "/":
			result=2;
			break;
		default:
			//System.out.println("运算符不存在");
			break;
		}
		return result;
	}
}
