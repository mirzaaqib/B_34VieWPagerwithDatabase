package com.pallefire.b_34viewpagerwithdatabase;


import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentShow extends Fragment {
    ListView listView;
    Cursor cursor;
    SimpleCursorAdapter simpleCursorAdapter;



    public FragmentShow() {
//  Required empty public constructor
   }


//    @Override
//  public void onCreate(@Nullable Bundle savedInstanceState) {
//      super.onCreate(savedInstanceState);
//      mydatabase=new Mydatabase(getActivity());
//       mydatabase.open();}
//////   //finish the activity here
//  public void onDestroy(){
//     mydatabase.close();super.onDestroy();
//   }
//    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_fragment_show, container, false);
        listView= (ListView) v.findViewById(R.id.list1);
         MainActivity mainActivity= (MainActivity) getActivity();
        cursor=mainActivity.mydatabase.queryStudent();
        if(cursor!=null)
        {
            while(cursor.moveToNext()){
                simpleCursorAdapter=new SimpleCursorAdapter(getActivity(),R.layout.row,cursor,new String[]{"_id","sname","ssubject","semail"},
                        new int[]{R.id.textView1,R.id.textView2,R.id.textView3,R.id.textView4});
                listView.setAdapter(simpleCursorAdapter);


            }
        }
        //cursor.requery();



        return v;
    }

}
