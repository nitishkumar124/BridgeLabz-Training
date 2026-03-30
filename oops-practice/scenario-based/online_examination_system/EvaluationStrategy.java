package week2.online_examination_system;

import java.util.*;

interface EvaluationStrategy {
	int evaluate(Exam exam, Student student);
}
