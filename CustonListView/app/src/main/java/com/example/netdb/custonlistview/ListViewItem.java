package com.example.netdb.custonlistview;
//이 클래스를 통해 listview_item.xml파일에 있는 것들을 리스트에 넣을거얌
import android.graphics.drawable.Drawable;

//매우매우중요쉬움 , 이미지뷰1개, 텍스트뷰2개-> listview_item.xml파일에서 그렇게 쓰기로 했응께
public class ListViewItem {
    Drawable icon;//이미지뷰
    String title;
    String desc;//지금 선언한 변수로부터 getter와 setter 하나씩 가져야함-> alt+insert

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
