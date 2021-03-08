package cl.ucn.disc.dsm.app.words;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import cl.ucn.disc.dsm.app.R;
import cl.ucn.disc.dsm.app.words.WordListAdapter;
import cl.ucn.disc.dsm.app.words.WordViewModel;
import cl.ucn.disc.dsm.app.words.room.Word;

public class WordActivity extends AppCompatActivity {

  private static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;
  private WordViewModel wordViewModel;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_word);

    RecyclerView recyclerView = findViewById(R.id.recyclerview);
    WordListAdapter adapter = new WordListAdapter(this);
    recyclerView.setAdapter(adapter);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));

    wordViewModel = ViewModelProviders.of(this).get(WordViewModel.class);
    wordViewModel.getAllWords().observe(this, new Observer<List<Word>>() {
      @Override
      public void onChanged(List<Word> words) {
        adapter.setWords(words);
      }
    });

  }

  public void launchNewWordActivity(View view) {
    Intent intent = new Intent(this, NewWordActivity.class);
    startActivityForResult(intent,NEW_WORD_ACTIVITY_REQUEST_CODE);
  }

  public void onActivityResult(int requestCode, int resultCode, Intent data){
    super.onActivityResult(requestCode,resultCode,data);

    if (requestCode == NEW_WORD_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
      Word word = new Word(data.getStringExtra(NewWordActivity.EXTRA_REPLY));
      wordViewModel.insertWord(word);
    } else {
      Toast.makeText(
          getApplicationContext(),
          R.string.empty_not_saved,
          Toast.LENGTH_LONG).show();
    }
  }
}