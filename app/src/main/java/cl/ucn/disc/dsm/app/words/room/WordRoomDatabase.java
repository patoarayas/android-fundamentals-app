package cl.ucn.disc.dsm.app.words.room;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Word.class}, version = 1, exportSchema = false)
public abstract class WordRoomDatabase extends RoomDatabase {
  public abstract WordDao wordDao();

  private static WordRoomDatabase INSTANCE;

  public static WordRoomDatabase getDatabase(Context context) {
    if (INSTANCE == null) {
      synchronized (WordRoomDatabase.class) {
        if (INSTANCE == null) {
          INSTANCE = Room.databaseBuilder(context.getApplicationContext(), WordRoomDatabase.class, "word_database")
              .fallbackToDestructiveMigration()
              .addCallback(populateDbCallBack)
              .build();
        }
      }
    }
    return INSTANCE;
  }

  private static RoomDatabase.Callback populateDbCallBack =
      new RoomDatabase.Callback() {

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
          super.onOpen(db);
          new PopulateDbAsync(INSTANCE).execute();
        }
      };

  private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

    private String[] testWords = {"These", "are", "test", "words",
        "Click", "on", "the", "plus", "button", "to", "add", "new", "ones"};
    private final WordDao dao;


    PopulateDbAsync(WordRoomDatabase db) {
      dao = db.wordDao();
    }

    @Override
    protected Void doInBackground(Void... voids) {
      dao.deleteAll();
      for (int i = 0;i < testWords.length ;i++) {
        dao.insertWord(new Word(testWords[i]));
      }

      return null;

    }

  }
}
