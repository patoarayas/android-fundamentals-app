package cl.ucn.disc.dsm.app.words.room;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "words")
public class Word {

  @PrimaryKey
  @NonNull
  @ColumnInfo(name = "word")
  private String word;


  public Word(String word){
    this.word = word;
  }

  public String getWord() {
    return word;
  }

}
