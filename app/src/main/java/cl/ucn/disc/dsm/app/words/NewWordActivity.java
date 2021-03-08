package cl.ucn.disc.dsm.app.words;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import cl.ucn.disc.dsm.app.R;

public class NewWordActivity extends AppCompatActivity {

  private EditText text;
  public static final String EXTRA_REPLY = "cl.ucn.disc.dsm.app.words.REPLY";


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_new_word);

    setContentView(R.layout.activity_new_word);

    text = findViewById(R.id.edit_word);

    Button button = findViewById(R.id.button_save);

    button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent replyIntent = new Intent();
        if (TextUtils.isEmpty(text.getText())) {
          setResult(RESULT_CANCELED, replyIntent);

        } else {
          String word = text.getText().toString();
          replyIntent.putExtra(EXTRA_REPLY, word);
          setResult(RESULT_OK, replyIntent);

        }
        finish();
      }
    });
  }
}