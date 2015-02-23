package hkim142.map524lab3;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by student on 2/6/15.
 */
public class ActivityTerminology extends ActionBarActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terminology);
        final String[] appdevterm= getResources().getStringArray(R.array.appdevterm);
        final String[] appdevdef = getResources().getStringArray(R.array.appdevtermdef);
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_dropdown_item_1line,appdevterm);
        AutoCompleteTextView actvdev=(AutoCompleteTextView)findViewById(R.id.actvdev);

        actvdev.setThreshold(1);
        actvdev.setAdapter(adapter);
        actvdev.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3) {
                boolean searchArrayResult = false;
                int i = 0;
                for (String str : getResources().getStringArray(R.array.appdevterm)){
                    searchArrayResult = str.contains((CharSequence)arg0.getItemAtPosition(arg2));
                    if(searchArrayResult){
                        Toast.makeText(getApplicationContext(),appdevdef[i], Toast.LENGTH_LONG).show();
                        break;
                    }
                    else{
                        i++;
                    }
                }
                Toast.makeText(getApplicationContext(),"Sorry, Their is no such term", Toast.LENGTH_LONG).show();
            }
        });
    }
}
