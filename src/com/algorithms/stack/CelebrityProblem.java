package com.algorithms.stack;

/**
 * 
 * @author Sasi Jolla on 14-Jul-2018, 4:48:22 pm
 */
public class CelebrityProblem {
	
	/**Running test case with four persons considering with numbers 1 to 4*/
	static int persons = 4;
	
	/**relations matrix represents if one person know other person. 1 represents yes or 0 represents no.*/
	static int relations[][] = {{0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}, {0, 0, 1, 0}};
	
	/**
	 * 
	 * @return
	 */
	public static int findCelebrity(){
		
		/**Pushing all persons to a stack*/
		com.datastructures.linear.Stack<Integer> stack = new com.datastructures.linear.Stack<>();
		for(int i = 1; i <= persons; i++){
			stack.push(i);
		}
		
		while(stack.size() > 1){
			int person1 = stack.pop();
			int person2 = stack.pop();
			
			/**If person1 know person2 then person1 is not celebrity so adding person2 back to stack.*/
			if(knows(person1, person2)){
				stack.push(person2);
			}else{
				stack.push(person1);
			}
		}
		
		return stack.pop();
	}
	
	private static boolean knows(int person1, int person2){
		return relations[person1 - 1][person2 - 1] == 1 ? true : false;
	}
	
	public static void main(String[] args) {
		System.out.println(findCelebrity());
	}
}
