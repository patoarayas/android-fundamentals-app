package cl.ucn.disc.dsm.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import cl.ucn.disc.dsm.app.counter.CounterActivity;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  /**
   * Launch Counter activity
   * @param view
   */
  public void launchCounterActivity(View view){
    Intent intent = new Intent(this, CounterActivity.class);
    startActivity(intent);
  }

}