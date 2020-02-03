package com.example.whatsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.IInterface;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuInflater;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ViewPager main_viewPager;
AdpterForFragment adapter;
TabLayout main_tab;

    TabItem camera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main_viewPager =findViewById(R.id.main_viewPager);
        adapter= new AdpterForFragment(getSupportFragmentManager(),3);
        main_viewPager.setAdapter(adapter);

        main_tab=findViewById(R.id.main_tab);
        main_tab.getTabAt(0).setIcon(R.drawable.ic_camera_alt_black_24dp);
        main_tab.getTabAt(1).setText("Chats");
        main_tab.getTabAt(2).setText("Calls");
       /* main_tab.addTab(main_tab.newTab().setIcon(R.drawable.ic_camera_alt_black_24dp));
        main_tab.addTab(main_tab.newTab().setText("Chats"));
        main_tab.addTab(main_tab.newTab().setText("Calls"));*/
        main_tab.setTabGravity(TabLayout.GRAVITY_FILL);
        main_tab.setupWithViewPager(main_viewPager);

main_tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        switch (tab.getPosition()){
            case 0:
                Intent intent=new Intent();
                intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent);
                break;
            case 1:
               addToRecycleChats();
               break;
            case 2:
                addToRecycleCall();

        }
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
});


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return  true;
    }

    public void addToRecycleChats(){
        AdapterForChatsRecycle adapterForChatsRecycle;
        RecyclerView recyclerView;
        RecyclerView.LayoutManager layoutManager;
        final ArrayList<ChatsView> arrayList;
        recyclerView=(RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);

        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        arrayList=new ArrayList<>();

        arrayList.add(new ChatsView("Ram","Tamam","at 11 am",R.drawable.mar));
        arrayList.add(new ChatsView("Mum","ya yasmin","at 2 am",R.drawable.mum));
        arrayList.add(new ChatsView("Dad","Bye","at 1 am",R.drawable.dad));

        arrayList.add(new ChatsView("Moaa","hater","at 9 am",R.drawable.asmaa));
        arrayList.add(new ChatsView("Roka","ya yasmin","at 2 pm",R.drawable.rokiaa));
        arrayList.add(new ChatsView("Dad","Bye","at 1 am",R.drawable.dad));
        arrayList.add(new ChatsView("Ram","Tamam","at 11 am",R.drawable.mar));
        arrayList.add(new ChatsView("Moaa","hater","at 9 am",R.drawable.asmaa));


        adapterForChatsRecycle=new AdapterForChatsRecycle(arrayList, new OnClickViewItemAdapter() {
            @Override
            public void onClickViewItem(int id) {
                Intent i=new Intent(getApplicationContext(),Main2Activity.class);
                i.putExtra("image",id);
                startActivity(i);
            }
        });
        recyclerView.setAdapter(adapterForChatsRecycle);
    }
    void addToRecycleCall(){
        AdapterForCallRecycle adapterForCallRecycle;
        RecyclerView recyclerView2;
        RecyclerView.LayoutManager layoutManager2;
        ArrayList<CallView> arrayList2;
        recyclerView2=findViewById(R.id.recyclerviewCall);
        recyclerView2.setHasFixedSize(true);

        layoutManager2=new LinearLayoutManager(this);
        recyclerView2.setLayoutManager(layoutManager2);
        arrayList2=new ArrayList<>();

        arrayList2.add(new CallView("Ram",R.drawable.mar));
        arrayList2.add(new CallView("Mum",R.drawable.mum));
        arrayList2.add(new CallView("Dad ",R.drawable.dad));

        arrayList2.add(new CallView("Moa",R.drawable.asmaa));
        arrayList2.add(new CallView("Roka",R.drawable.rokiaa));
        arrayList2.add(new CallView("Ram",R.drawable.mar));


        adapterForCallRecycle=new AdapterForCallRecycle(arrayList2);
        recyclerView2.setAdapter(adapterForCallRecycle);
    }
    }

