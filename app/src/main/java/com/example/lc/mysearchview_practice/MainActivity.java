package com.example.lc.mywidget_practice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;///!!!!!!!注意，引错包很大罪
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private ListView lv;
    private final String [] strings={"aaaaa","bbbbb","ccccc","ddddd"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView)findViewById(R.id.lv);
        lv.setAdapter(new ArrayAdapter<> (this,
                android.R.layout.simple_list_item_1, strings));
        lv.setTextFilterEnabled(true);

        SearchView searchView = (SearchView) findViewById(R.id.sv);
        //默认是否缩小图标
        assert searchView != null;
        searchView.setIconifiedByDefault(false);
        //设置sv显示搜索按钮
        searchView.setSubmitButtonEnabled(true);
        //设置sv默认显示的文本
        searchView.setQueryHint("查找");
        //为sv组件设置时间监听器
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextChange(String newText) {
                if (TextUtils.isEmpty(newText)){
                    lv.clearTextFilter();
                }
                else {
                    lv.setFilterText(newText);
                }
                return true;
            }
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(MainActivity.this,"您的选择是：" + query,Toast.LENGTH_SHORT).show();
                return false;
            }
        });

    }

}