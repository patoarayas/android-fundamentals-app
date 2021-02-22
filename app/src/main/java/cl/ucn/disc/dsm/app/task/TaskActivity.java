package cl.ucn.disc.dsm.app.task;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import cl.ucn.disc.dsm.app.R;

public class TaskActivity extends AppCompatActivity {
  
  private static final String TEXT_STATE = "";
  private TextView textView;
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_task);
    textView = findViewById(R.id.textView);

    if(savedInstanceState != null) {
      textView.setText(savedInstanceState.getString(TEXT_STATE));
    }
  }

  public void startTask(View view) {
    textView.setText(R.string.task_working_msg);
    new SimpleTask(textView).execute();
  }

  @Override
  protected void onSaveInstanceState(@NonNull Bundle outState) {
    super.onSaveInstanceState(outState);

    outState.putString(TEXT_STATE, textView.getText().toString());
  }
}