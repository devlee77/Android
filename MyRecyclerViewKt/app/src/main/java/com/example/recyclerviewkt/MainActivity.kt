package com.example.recyclerviewkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val profileList = arrayListOf(
            Profiles(R.drawable.man, "이성찬", 26, "개발자"),
            Profiles(R.drawable.woman, "조형진", 27, "안드로이드 개발자"),
            Profiles(R.drawable.woman, "이주현", 23, "하이브리드 개발자"),
            Profiles(R.drawable.man, "김세정", 24, "웹 앱 개발자"),
            Profiles(R.drawable.woman, "이동주", 21, "리액트 개발자"),
            Profiles(R.drawable.man, "김병윤", 30, "그냥 개발자"),
            Profiles(R.drawable.man, "김나영", 35, "배고픈 개발자"),
            Profiles(R.drawable.woman, "이승주", 42, "유니티 개발자"),
            Profiles(R.drawable.man, "조병재", 23, "클린 개발자"),
            Profiles(R.drawable.man, "이아영", 26, "아이폰 개발자"),
            Profiles(R.drawable.woman, "이나현", 19, "개발자"),
            Profiles(R.drawable.woman, "조예빈", 26, "개발자")
        )

        rv_profile.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rv_profile.setHasFixedSize(true)

        rv_profile.adapter = ProfileAdapter(profileList);
    }

}
