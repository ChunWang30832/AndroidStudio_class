/*
 * Copyright (C) 2018 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.finalproject;

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

/***
 * Item是recyclerView顯示的東西
 */
public class MainActivity extends AppCompatActivity {

    // Member variables.
    private RecyclerView mRecyclerView;
    private ArrayList<Item> mItemData; //所有Item物件的Data
    private ItemsAdapter mAdapter;
    public static Cart cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbarm);
        setSupportActionBar(toolbar);
        cart = new Cart();

        // 初始化 RecyclerView.
        mRecyclerView = findViewById(R.id.recyclerView);

        // 設定 Layout Manager.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // 初始化 ArrayList.
        mItemData = new ArrayList<>();

        // 初始化 adapter & 設定 RecyclerView 的 adapter.
        mAdapter = new ItemsAdapter(this, mItemData);
        mRecyclerView.setAdapter(mAdapter);
        // Get the data.
        initializeData();
    }

    /**
     * 從 Resources 初始化 Item data.
     */
    private void initializeData() {
        // 從 XML 取得 Resource.
        String[] sportsList = getResources().getStringArray(R.array.sports_titles);
        String[] sportsInfo = getResources().getStringArray(R.array.sports_info);
        TypedArray ImgResources = getResources().obtainTypedArray(R.array.sports_images);

        // 清空 ArrayList.
        mItemData.clear();

        // 依 Resource 建構 Item 物件 & 設定所有加入購物車次數為0
        for (int i = 0; i < sportsList.length; i++) {
            Item obj = new Item(sportsList[i], sportsInfo[i], ImgResources.getResourceId(i, 0));
            mItemData.add(obj);
        }

        // Recycle the typed array.
        ImgResources.recycle();

    }

    //////////////////////////////////////郁鈞打的///////////////////////////////////
    private CharSequence menuIconWithText(Drawable r, String title) {
        r.setBounds(0, 0, r.getIntrinsicWidth(), r.getIntrinsicHeight());
        SpannableString sb = new SpannableString("    " + title);
        ImageSpan imageSpan = new ImageSpan(r, ImageSpan.ALIGN_BOTTOM);
        sb.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return sb;
    }
    /**程式中新增MenuItem選項*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        /**itemId為稍後判斷點擊事件要用的*/
        menu.add(0,0,0,"新增商品");
        menu.add(0,1,1,"設定");
        //menu.add(0,2,2,"第三選項");
        /**setShowAsAction預設為NEVER
         *MenuItem.SHOW_AS_ACTION_IF_ROOM 為如果Toolbar內還有空間，便會將這個item放到Toolbar內*/
        //menu.add(0,4,4,"外部選項").setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        return super.onCreateOptionsMenu(menu);
    }
    /**此處為設置點擊事件*/
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        /**取得Item的ItemId，判斷點擊到哪個元件*/
        switch (item.getItemId()){
            case 0:
                Toast.makeText(this, "新增商品", Toast.LENGTH_SHORT).show();
                break;
            case 1:
                Toast.makeText(this, "設定", Toast.LENGTH_SHORT).show();
                break;
            /*case 2:
                Toast.makeText(this, "選三", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(this, "選帶ICON的Item", Toast.LENGTH_SHORT).show();
                break;
            case 4:
                Toast.makeText(this, "選在外面的", Toast.LENGTH_SHORT).show();
                break;*/

        }
        return super.onOptionsItemSelected(item);
    }
//////////////////////////////////////////////////////////////////////////////////////////小弟打的/////////////////////

    /**
     * 購物車按鈕的OnClick.
     *
     * @param view The button view that was clicked.
     */
    public void goCart(View view) {
        Intent intent = new Intent(this, cartActivity.class);
        intent.putExtra("ItemString[]", cart.cartItem.toArray(new String[0]));
        intent.putExtra("counts[]", cart.cartCount);
        this.startActivity(intent);
    }
}