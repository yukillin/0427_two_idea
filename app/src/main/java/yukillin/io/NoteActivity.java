package yukillin.io;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class NoteActivity extends AppCompatActivity {
    EditText note;
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        note = (EditText) findViewById(R.id.note);
        pref = getSharedPreferences("pref_memo", MODE_PRIVATE);

        note.setText(pref.getString("key_content",""));

    }

    public void save(View v){

    String contentText = note.getText().toString();

    SharedPreferences.Editor editor = pref.edit();
    editor.putString("key_content",contentText);
    editor.commit();

    finish();


    }
}



