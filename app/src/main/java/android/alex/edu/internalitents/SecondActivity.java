package android.alex.edu.internalitents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity
{
    public static final String RIGHT_ANSWERS_NUM  = "numberOfRightAnswers";

    private static final String QUESTION_STRING = "What science group belongs to psychology?";
    private static final String FIRST_ANSWER = "Brain science";
    private static final String SECOND_ANSWER = "Humanities";
    private static final String THIRD_ANSWER = "Social Sciences";
    private static final String FOURTH_ANSWER = "Political Science";

    private static final String RIGHT_ANSWER = "Social Sciences";

    private static final int PASSED_QUESTIONS_NUM = 1;

    private int numberOfRightAnswers = 0;
    private int rightAnswerNumber = R.id.rbThirdAnswer;

    private TextView textViewQuestion;
    private RadioGroup radioGroupAnswers;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        numberOfRightAnswers = intent.getIntExtra(FirstActivity.RIGHT_ANSWERS_NUM, 0);
        textViewResult = (TextView) findViewById(R.id.tvResult);;
        textViewResult.setText("You have " + numberOfRightAnswers + " right answers from " + PASSED_QUESTIONS_NUM);

        textViewQuestion = (TextView) findViewById(R.id.tvQuestion);
        textViewQuestion.setText(QUESTION_STRING);

        radioGroupAnswers = (RadioGroup)findViewById(R.id.rgGroupAnswers);

        RadioButton radioButtonFirstAnswer = (RadioButton)findViewById(R.id.rbFirstAnswer);
        radioButtonFirstAnswer.setText(FIRST_ANSWER);

        RadioButton radioButtonSecondAnswer = (RadioButton)findViewById(R.id.rbSecondAnswer);
        radioButtonSecondAnswer.setText(SECOND_ANSWER);

        RadioButton radioButtonThirdAnswer = (RadioButton)findViewById(R.id.rbThirdAnswer);
        radioButtonThirdAnswer.setText(THIRD_ANSWER);

        RadioButton radioButtonFourthAnswer = (RadioButton)findViewById(R.id.rbFourthAnswer);
        radioButtonFourthAnswer.setText(FOURTH_ANSWER);
    }

    public void getAnswer(View view)
    {
        if(radioGroupAnswers.getCheckedRadioButtonId() == -1)
        {
            Toast.makeText(this, "You have to check answer", Toast.LENGTH_LONG).show();
            return;
        }
        else {
            radioGroupAnswers = (RadioGroup) findViewById(R.id.rgGroupAnswers);
            int checkedId = radioGroupAnswers.getCheckedRadioButtonId();
            if (checkedId == rightAnswerNumber) {
                numberOfRightAnswers += 1;
                Toast.makeText(this, "Right Answer!",  Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Wrong Answer. The answer is: " + RIGHT_ANSWER, Toast.LENGTH_LONG).show();
            }

            Intent intent = new Intent(this , ThirdActivity.class);
            intent.putExtra(RIGHT_ANSWERS_NUM, numberOfRightAnswers);
            startActivity(intent);
        }
    }

}
