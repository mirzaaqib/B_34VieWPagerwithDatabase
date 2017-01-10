package com.pallefire.b_34viewpagerwithdatabase;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentSave extends Fragment {
    EditText et1,et2,et3;
    Button save;
   // Mydatabase mydatabase;


    public FragmentSave() {
        // Required empty public constructor
    }
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        //open database here in onreate ()
//        mydatabase=new Mydatabase(getActivity());
//        mydatabase.open();
//    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_fragment_save, container, false);
        et1 = (EditText) v.findViewById(R.id.et1);
        et2 = (EditText) v.findViewById(R.id.et2);
        et3 = (EditText) v.findViewById(R.id.et3);
        save = (Button) v.findViewById(R.id.bt1);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=et1.getText().toString();
                String subject=et2.getText().toString();
                String email=et3.getText().toString();
                if (name.matches("")&& subject.matches("")&&email.matches(""))
                {
                    Toast.makeText(getActivity(), "Please fill all the fields", Toast.LENGTH_SHORT).show();
                }
                else {
                    MainActivity mainActivity= (MainActivity) getActivity();
                    mainActivity.mydatabase.insertStudent(name,subject,email);
                    mainActivity.notifyData();
                    //request db for file for insertion

                    et1.setText("");
                    et2.setText("");
                    et3.setText("");
                 et1.requestFocus();
                    et2.requestFocus();
                    et3.requestFocus();
                    et3.setText("");
                    Toast.makeText(mainActivity, "Data Inserted Successfully", Toast.LENGTH_SHORT).show();

                }
            }

        });
        return v;
    }

}
