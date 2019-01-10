package com.example.netdb.custonlistview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018-10-10.
 */

public class ListAdapter extends BaseAdapter{ //alt+enter 그냥 엔터(implenet method)-getter

    ArrayList<ListViewItem> items=new ArrayList<ListViewItem>();//getter setter쓰려고 ListViewItem 을 생성자로 갖는 배열리스트
    //ListViewItem 이거 내가 만든 java파일이여
    public ListAdapter(){//생성자, 나중에 mainActivity 에서 사용할거야

    }//<- 역시 없어도 돼


    @Override
    public int getCount() {
        return items.size();//return에 size로 고쳐주는거; 이거 해주려고 ArrauList items 선언해야함 :짱중요 매우중요 고치는거 매우매우 중요 ->mainActivity가 돌아감
    }//return 0이면 view에 암것도 안떠,,

    @Override
    public ListViewItem getItem(int i) { //int i: position
        return items.get(i);//이것도 고쳐
    }

    @Override
    public long getItemId(int i) {
        return i;//이것도 고쳐
    }

    @Override//view를 그려주는 메소드
    public View getView(int position, View Convertview, ViewGroup parent) { //int i:position View view:ConvertView/ ViewGroup: parent
        Context context = parent.getContext(); //context:안드로이드에서 기본적으로 제공해주는 컨퍼런트를 쓸 수 있게 해주는 함수 ->를 ViewGroup에서 가져와(우리는 parent에서만 가져올거얀)
        //view그룹에 있는 context를 가져와서 새롭게 정의한 context에 저장 하겠다(윗줄)


        if (Convertview == null){//view가 하나도 생성되지 않았을 때(처음화면은 view가 비어있잖어 넘나 당연;)

            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);//시스템에서 레이아웃인플레이터라는 서비스를 제공하는거를 우리가 쓰는겨
            //여기서 context.은 context 클래스임, 내가 선언한거 x
            Convertview=layoutInflater.inflate(R.layout.listview_item,null);//view를 만들건데, 우리가 만든 레이아웃을(listview_item) 가져와서 그 화면을 ㅇㄴ플레이트 시켜주겠다 ->매우중요 짱중요, null은 원래 그래..
        }//처음 화면이 돌때 listView가 실해오디고 adaper로 넘어와서 view가 인플레이트되서 우리가 담은 listview가 화면에 나온다

        ImageView icon=(ImageView)Convertview.findViewById(R.id.imageView1); //어디 context에서 받아와?
        TextView title=(TextView)Convertview.findViewById(R.id.textView1);//mainActovoty가 아니기때문에 context가 필요해..
        TextView name=(TextView)Convertview.findViewById(R.id.textView2);

        ListViewItem item=getItem(position);//저거 밑에 set-함수들 써주려고,listview아이템을 인덱스별로 가져 오겠다

        icon.setImageDrawable(item.getIcon());//어떤 이미지를 세팅 하겠냐 ->item.getIcon: listview 클래스에서 getIcon메서드를 불러줌
        title.setText(item.getTitle());
        name.setText(item.getDesc());

        return Convertview;//이것도 바꿔
    }

    public void addItem(Drawable Icon, String Title,String Name){
        ListViewItem item=new ListViewItem();

        item.setIcon(Icon);
        item.setTitle(Title);
        item.setDesc(Name);

        items.add(item);
    }



//    public void addItem(Drawable icon,String title, String desc){} ->이거 mainAcitivy에서 이거의 매개변수 순서와 똑같아야함 adapter.addItem이거의 매개변수 순서!!!
//    ListViewItem
}

/*

 */