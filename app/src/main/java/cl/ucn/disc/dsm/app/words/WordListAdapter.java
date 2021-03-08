package cl.ucn.disc.dsm.app.words;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cl.ucn.disc.dsm.app.R;
import cl.ucn.disc.dsm.app.words.room.Word;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

  private final LayoutInflater inflater;
  private List<Word> words;


  public WordListAdapter(Context context) {
    inflater = LayoutInflater.from(context);
  }

  @NonNull
  @Override
  public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View itemView = inflater.inflate(R.layout.item_layout,parent,false);
    return new WordViewHolder(itemView);
  }

  @Override
  public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
    if (words != null) {
      Word current = words.get(position);

      holder.wordItemView.setText(current.getWord());
    } else {
      // Covers the case of data not being ready yet.
      holder.wordItemView.setText("No Word");
    }
  }

  public void setWords(List<Word> words) {
    this.words = words;
    notifyDataSetChanged();
  }

  @Override
  public int getItemCount() {
    if (words != null)
      return words.size();
    else return 0;
  }


  class WordViewHolder extends RecyclerView.ViewHolder{

    private final TextView wordItemView;

    public WordViewHolder(@NonNull View itemView) {
      super(itemView);
      wordItemView = itemView.findViewById(R.id.textView);
    }
  }

}
