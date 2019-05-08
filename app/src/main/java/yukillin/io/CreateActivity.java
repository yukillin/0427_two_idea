package yukillin.io;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import io.realm.Realm;

public class CreateActivity extends AppCompatActivity {

    public Realm realm;


    public EditText contentEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        realm = Realm.getDefaultInstance();

        contentEditText = (EditText) findViewById(R.id.contentEditText);

    }

    public void save(final String updateDate,final String content){

        realm.executeTransaction(new Realm.Transaction(){
            @Override
            public void execute(Realm bgRealm){
                Memo memo = realm.createObject(Memo.class);
                memo.updateDate = updateDate;
                memo.content = content;
            }
        });
    }


    public void create(View view){
        Date date= new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.JAPANESE);
        String updateDate = sdf.format(date);

        String content = contentEditText.getText().toString();

        //check(updateDate,content);

        save(updateDate,content);
        finish();

    }

    private void check(String updateDate, String content){

        Memo memo = new Memo();
        memo.content=content;
        memo.updateDate= updateDate;


        Log.d("Memo",memo.content);
        Log.d("Memo",memo.updateDate);


    }



    @Override
    protected void onDestroy() {
        super.onDestroy();

        realm.close();
    }

}