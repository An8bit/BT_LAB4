package com.example.nguyenthanhan_lab3bt3;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.nio.file.DirectoryStream;
import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class InfoAdapter extends RecyclerView.Adapter<InfoAdapter.InfoVH> implements Filterable {

    ArrayList<Info> infos;
    ArrayList<Info> infoFilter;
    Listener listener;

    public InfoAdapter(ArrayList<Info> infos, Listener listener) {
        this.infos = infos;
        this.listener = listener;
        this.infoFilter= infos;
    }

    @NonNull
    @Override
    public InfoVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.country_row,parent,false);
        return new InfoVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InfoVH holder, @SuppressLint("RecyclerView") int position) {
        Info info = infos.get(position);
       holder.imgFlag.setImageResource(info.getImage());
       holder.txName.setText(info.getFname()+" "+info.getLname());
        holder.txPhone.setText(info.getPhone());
        holder.txFax.setText(info.getMail());
        //viết ra để test đổi ảnh mà lỗi
        if(info.getImage()==0){
            holder.imgFlag.setImageResource(R.drawable.baseline_cake_24);
        }else {
            holder.imgFlag.setImageResource(info.getImage());
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClickListener(position,info);
            }
        });
    }

    @Override
    public int getItemCount() {
        return infos.size();
    }

    @Override
    public Filter getFilter() {
        return null;
    }


    class InfoVH extends RecyclerView.ViewHolder{

        CircleImageView imgFlag;
        TextView txName,txPhone,txFax;
        public InfoVH(@NonNull View itemView){
            super(itemView);
            imgFlag=itemView.findViewById(R.id.imgFlag);
            txName=itemView.findViewById(R.id.txName);
            txPhone=itemView.findViewById(R.id.txPhone);
            txFax=itemView.findViewById(R.id.txFax);

        }
    }
   class infoFilter extends Filter{

       @Override
       protected FilterResults performFiltering(CharSequence charSequence) {
           String charString = charSequence.toString();
           if(charString.isEmpty()){
               infoFilter=infos;
           }else {
               List<Info>filteredlist=new ArrayList<>();
              // Đoạn mã trên là một vòng lặp for-each để lọc danh sách liên lạc.
              //Trong mỗi vòng lặp, đoạn mã kiểm tra xem một hàng liên lạc có chứa chuỗi ký tự (charString) được cung cấp hay không. Nếu có, nó sẽ được thêm vào danh sách đã lọc (filteredList).
               // Điều kiện kiểm tra được thực hiện bằng cách so sánh các giá trị thuộc tính của hàng liên lạc, bao gồm tên đầu tiên (fName), số điện thoại (phone) và tên cuối (lName). Nếu bất kỳ giá trị nào chứa chuỗi ký tự được cung cấp, hàng liên lạc đó sẽ được thêm vào danh sách đã lọc.
                       //Ngoài ra, đoạn mã cũng sử dụng phương thức toLowerCase() để chuyển đổi chuỗi ký tự và thuộc tính của hàng liên lạc sang chữ thường trước khi so sánh, để đảm bảo rằng việc so sánh sẽ không bị ảnh hưởng bởi việc sử dụng chữ hoa hay chữ thường.
               for (Info row : infos){
                   if (row.getLname().toLowerCase().contains(charString.toLowerCase())||row.getPhone().contains(charSequence)||row.getLname().contains(charSequence)){
                       filteredlist.add(row);
                   }
               }
               infoFilter = (ArrayList<Info>) filteredlist;
           }
           FilterResults filterResults = new FilterResults();
           filterResults.values=infoFilter;
           return filterResults;
       }

       @Override
       protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
          infoFilter=(ArrayList<Info>) filterResults.values;
          notifyDataSetChanged();
       }
   }
   public void  addInfo(Info info){
        infoFilter.add(info);
       notifyDataSetChanged();
   }
   public  void editInfo(Info info,int pos){
        infoFilter.set(pos,info);
       notifyDataSetChanged();
   }
    public  void deleteInfo(int pos){
        infoFilter.remove(pos);
        notifyDataSetChanged();
    }
    public  void deleteInfo(Info info){
        infoFilter.remove(info);
        notifyDataSetChanged();
    }


    interface Listener {
        void onClickListener(int pos,Info info);
    }
}

