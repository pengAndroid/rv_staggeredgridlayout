package com.example.shinelon.rv_staggeredgridlayout;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.shinelon.rv_staggeredgridlayout.adapter.DemoAdapter;
import com.example.shinelon.rv_staggeredgridlayout.bean.Person;
import com.example.shinelon.rv_staggeredgridlayout.utils.SpaceItemDecoration;
import com.example.shinelon.rv_staggeredgridlayout.utils.Utils;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    /**
     * recyclerview
     */
    private RecyclerView rv_datas;
    /**
     * adapter
     */
    private DemoAdapter adpter;
    /**
     * 上下文
     */
    private Context mContext;

    /**
     * 列表数据
     */
    private ArrayList<Person> list;
    /**
     * 分割线
     */
    private int space;

    /**
     * 列数（可在这里改变列数）
     * 如果要分割线均等，得自己去SpaceItemDecoration类判断，这边我只写了两列为例子
     */
    public static final int spanCount = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        rv_datas = (RecyclerView) findViewById(R.id.rv_datas);
        space = Utils.px2dip(mContext, 64);
        //瀑布流的布局方式: 2列,垂直方向
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(spanCount, StaggeredGridLayoutManager.VERTICAL);
        rv_datas.setLayoutManager(staggeredGridLayoutManager);
        //初始化数据
        initData();
        //创建适配器
        adpter = new DemoAdapter(mContext, list);
        //设置分割线
        rv_datas.addItemDecoration(new SpaceItemDecoration(space, spanCount));
        //设置适配器
        rv_datas.setAdapter(adpter);

    }

    /**
     * 创造数据
     */
    private void initData() {
        list = new ArrayList<Person>();
        Person person;
        for (int i = 0; i < 50; i++) {
            person = new Person();
            person.setId(i);
            list.add(person);
        }
    }
}
