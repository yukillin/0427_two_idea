package yukillin.io;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

import io.realm.Realm;
import io.realm.RealmResults;

public class TopActivity extends AppCompatActivity {

    public Realm realm;

    TextView word1;
    TextView word2;
    int string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);

        realm = Realm.getDefaultInstance();
        word1 = (TextView) findViewById(R.id.word1);
        word2 = (TextView) findViewById(R.id.word2);

        //RealmResults<Memo> results = realm.where(Memo.class).findAll();
        //results.size();
        //results.get(0);

        //random.nextInt(results.size());

    }

    public void change(View v){

        Random random = new Random();

        RealmResults<Memo> results = realm.where(Memo.class).findAll();


        int randomInt1 = random.nextInt(results.size());
        int randomInt2 = random.nextInt(results.size());

        String wordStr1 = results.get(randomInt1).content;
        String wordStr2 = results.get(randomInt2).content;

        word1.setText(wordStr1);
        word2.setText(wordStr2);

    }

    public void plus(View v){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);

    }

}
