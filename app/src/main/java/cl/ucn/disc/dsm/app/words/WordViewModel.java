package cl.ucn.disc.dsm.app.words;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import cl.ucn.disc.dsm.app.words.room.Word;
import cl.ucn.disc.dsm.app.words.room.WordRepository;

public class WordViewModel extends AndroidViewModel {

  private WordRepository repository;
  private LiveData<List<Word>> allWords;

  public WordViewModel(@NonNull Application application) {
    super(application);
    repository = new WordRepository(application);
    allWords = repository.getAllWords();
  }

  public LiveData<List<Word>> getAllWords() {
    return allWords;
  }

  public void insertWord(Word word) {
    repository.insert(word);
  }
}
