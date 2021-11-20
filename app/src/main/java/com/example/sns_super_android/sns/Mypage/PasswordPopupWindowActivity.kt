package com.example.sns_super_android.sns.Mypage

import android.app.ActionBar
import android.graphics.drawable.BitmapDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.PopupWindow
import android.widget.TextView
import com.example.sns_super_android.R

class PasswordPopupWindowActivity : AppCompatActivity() {
    private var btn_number_check: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password_popup_window)
        btn_number_check = findViewById<View>(R.id.btn_check_number) as Button
        btn_number_check!!.setOnClickListener { v ->
            val popup = PopupWindow(v)
            val inflater =
                getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
            //팝업으로 띄울 커스텀뷰를 설정하고
            val view = inflater.inflate(R.layout.wrong_info_popup_window, null)
            popup.contentView = view
            //팝업의 크기 설정
            popup.setWindowLayoutMode(
                ActionBar.LayoutParams.MATCH_PARENT,
                ActionBar.LayoutParams.MATCH_PARENT
            )
            //팝업 뷰 터치 되도록
            popup.isTouchable = true
            //팝업 뷰 포커스도 주고
            popup.isFocusable = true
            //팝업 뷰 이외에도 터치되게 (터치시 팝업 닫기 위한 코드)
            popup.isOutsideTouchable = true
            popup.setBackgroundDrawable(BitmapDrawable())
            //인자로 넘겨준 v 아래로 보여주기
            popup.showAsDropDown(v)
        }
    }
}