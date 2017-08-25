package com.example.shinelon.rv_staggeredgridlayout.adapter;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.shinelon.rv_staggeredgridlayout.R;
import com.example.shinelon.rv_staggeredgridlayout.bean.Person;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * Created by Peng on 2017/8/25.
 */

public class DemoAdapter extends RecyclerView.Adapter<DemoAdapter.MyViewHolder> {
    private Context context;
    ArrayList<Person> list;
    private List<Integer> heightList;//随机数组

    public DemoAdapter(Context context, ArrayList<Person> list) {
        this.context = context;
        this.list = list;
        //记录每个控件的随机高度,避免滑回到顶部出现空白
        heightList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            //创建随机高度
            int height = new Random().nextInt(400) + 200;
            heightList.add(height);
        }

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Person person = list.get(position);
        holder.tv_content.setText(person.getId() + "");
        //动态改变控件的高度
        ViewGroup.LayoutParams params = holder.itemView.getLayoutParams();
        params.height = heightList.get(position);
        holder.itemView.setLayoutParams(params);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_content;
        LinearLayout ll_item;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv_content = (TextView) itemView.findViewById(R.id.tv_content);
            ll_item = (LinearLayout) itemView.findViewById(R.id.ll_item);
        }
    }

}
