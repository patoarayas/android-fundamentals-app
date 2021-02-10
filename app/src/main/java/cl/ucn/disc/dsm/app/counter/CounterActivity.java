package cl.ucn.disc.dsm.app.counter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import cl.ucn.disc.dsm.app.R;

public class CounterActivity extends AppCompatActivity {

  private int count = 0;
  private TextView showCount;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_counter);
    showCount = (TextView) findViewById(R.id.showCount);
  }

  public void showToast(View view) {
    Toast toast = Toast.makeText(this,R.string.toast_message, Toast.LENGTH_LONG);
    toast.show();
  }

  public void countUp(View view){
    count++;
    if(showCount != null){
      showCount.setText(Integer.toString(count));
    }

  }
}