package com.example.whatsapp;

import android.content.Intent;
import android.provider.MediaStore;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class AdpterForFragment extends FragmentPagerAdapter {
    public AdpterForFragment(@NonNull FragmentManager fm, int behavior) {
        super(fm,behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
     switch (position){
         case 0:
             CameraFragment fragment1=new CameraFragment();
          return  fragment1;

         case 1:
             ChatsFragment fragment2=new ChatsFragment();
             return  fragment2;
         case 2:
             CallsFragment fragment3=new CallsFragment();
             return  fragment3;
     }
     return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
  @Override
    public CharSequence getPageTitle(int position) {
        switch (position){

          case 0:
        return "Camera";
            case 1:
                return  "Chats";
            case 2:
                return  "Calls";
        }
        return null;
    }


}
