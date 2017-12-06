package Programmers;
/**
 * 
 * 숫자의 표현 
 * https://programmers.co.kr/learn/challenge_codes/156
 * 
 */
public class Challenge40 {
	public int expressions(int num) {
		int answer = 0;
		
		for (int i = 1; i <= num/2; i++) {
			int sum = 0;
			for (int j = i; j <= num; j++) {
				if (sum == num) {
					answer ++;
					break;
				} else if (sum < num){
					sum = sum + j;
					System.out.println(sum);
				} else {
					break;
				}
			}
		}
		
		answer++;
		
		return answer;
	}

	public static void main(String args[]) {
		Challenge40 expressions = new Challenge40();
		System.out.println("답 : "+expressions.expressions(15));
	}
}
