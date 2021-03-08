package cl.ucn.disc.dsm.app.words.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface WordDao {

  @Insert
  void insertWord(Word word);

  @Query("DELETE FROM words")
  void deleteAll();

  @Query("SELECT * from words ORDER BY word ASC")
  LiveData<List<Word>> getAllWords();
}
