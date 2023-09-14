package model;

public class Question
{
	private String description;
	private String answerA;
	private String answerB;
	private String answerC;
	private int correctAnswer;
	
	public Question(String description, String answerA, String answerB, String answerC, int correctAnswer) {
		this.description = description;
		this.answerA = answerA;
		this.answerB = answerB;
		this.answerC = answerC;
		this.correctAnswer = correctAnswer;
	}
	public Question() {
		this.description = "";
		this.answerA = "";
		this.answerB = "";
		this.answerC = "";
		this.correctAnswer = 0;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAnswerA() {
		return answerA;
	}
	public void setAnswerA(String answerA) {
		this.answerA = answerA;
	}
	public String getAnswerB() {
		return answerB;
	}
	public void setAnswerB(String answerB) {
		this.answerB = answerB;
	}
	public String getAnswerC() {
		return answerC;
	}
	public void setAnswerC(String answerC) {
		this.answerC = answerC;
	}
	public int getCorrectAnswer() {
		return correctAnswer;
	}
	public void setCorrectAnswer(int correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	
	@Override
	public String toString() {
		return getDescription() + "\n1. " + getAnswerA() + "\n2. " 
				+ getAnswerB() + "\n3. " + getAnswerC() + "\nCorrect answer: " + getCorrectAnswer();
	}
}