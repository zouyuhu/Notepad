package Utils;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sueword.notepad.R;

import java.util.List;

import Beans.Note;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
    private List<Note> dataList;
    private Context context;
    public MyAdapter(Context context,List<Note> dataList){
        this.context=context;
        this.dataList=dataList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.cardview_item,parent,false);
        return new ViewHolder(v);
    }

    public void onBindViewHolder(final ViewHolder holder, int position) {
        Note sentence=dataList.get(position);
        holder.title.setText(sentence.getTitle());
        holder.createTime.setText(sentence.getCreateTime());
        View itemView=holder.itemView;
        if(onItemCLickListener!=null){
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position=holder.getLayoutPosition();
                    onItemCLickListener.onItemClick(holder.itemView,position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return dataList==null?0:dataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView title;
        public TextView createTime;
        public ViewHolder(View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title1);
            createTime=itemView.findViewById(R.id.createTime);
        }
    }
    private OnItemCLickListener onItemCLickListener;
    public void setOnItemCLickListener(OnItemCLickListener onItemCLickListener){
        this.onItemCLickListener=onItemCLickListener;
    }
}
