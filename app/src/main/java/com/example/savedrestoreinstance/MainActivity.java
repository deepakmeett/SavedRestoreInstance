package com.example.savedrestoreinstance;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button1, button2;
    int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        editText = findViewById( R.id.edit );
        button1 = findViewById( R.id.bt1 );
        button2 = findViewById( R.id.bt2 );
        number = 0;
        button1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number++;

            }
        } );
        button2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText( MainActivity.this, "Number is " + number, Toast.LENGTH_SHORT ).show();
            }
        } );
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        
        super.onSaveInstanceState( outState );
        String s1 = editText.getText().toString();
        outState.putString( "s1", s1 );
        outState.putInt( "s2", number );
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState( savedInstanceState );
        editText.setText( savedInstanceState.getString( "s1" ) );
        number = savedInstanceState.getInt( "s2" );
    }

}
