package android.alex.edu.internalitents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class LastActivity extends AppCompatActivity {

    private static final int PASSED_QUESTIONS_NUM = 3;

    int numberOfRightAnswers;
    TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last);

        Intent intent = getIntent();
        int numberOfRightAnswers = intent.getIntExtra(ThirdActivity.RIGHT_ANSWERS_NUM, 0);
        textViewResult = (TextView) findViewById(R.id.tvResult);;
        textViewResult.setText("Your score is " + numberOfRightAnswers + " right answers from " + PASSED_QUESTIONS_NUM);
    }
}
