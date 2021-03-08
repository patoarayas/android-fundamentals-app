package cl.ucn.disc.dsm.app.words.room;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class WordRepository {

  private WordDao wordDao;
  private LiveData<List<Word>> allWords;

  public WordRepository(Application application) {
    WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
    wordDao = db.wordDao();
    allWords = wordDao.getAllWords();
  }

  public LiveData<List<Word>> getAllWords(){
    return allWords;
  }

  public void insert(Word word){
    new InsertAsyncTask(wordDao).execute(word);
  }

  private static class InsertAsyncTask extends AsyncTask<Word, Void,Void> {

    private WordDao wordDao;

    InsertAsyncTask(WordDao dao){
      wordDao = dao;
    }
    @Override
    protected Void doInBackground(Word... words) {
      wordDao.insertWord(words[0]);
      return null;
    }
  }
}
