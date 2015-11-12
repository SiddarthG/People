package com.hackerearth.sid.people;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;

public class ReadActivity extends AppCompatActivity {

    ImageLoader mImageLoader;
    VolleySingleton volley;

    TextView ethnicity;
    ImageView imageView;
    TextView status;
    TextView dob;
    TextView height;
    TextView weight;
    TextView is_veg;
    TextView drinks;


    DataSet dataSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
        Toolbar toolbar= (Toolbar) findViewById(R.id.appbar);
        setSupportActionBar(toolbar);
        volley = VolleySingleton.getsInstance();
        mImageLoader = volley.getImageLoader();
        imageView= (ImageView) findViewById(R.id.imageViewContent);

        ethnicity=(TextView)findViewById(R.id.textViewEthnicity);
        status=(TextView)findViewById(R.id.textViewStatus);
        dob=(TextView)findViewById(R.id.dob);
        height=(TextView)findViewById(R.id.height);
        weight=(TextView)findViewById(R.id.weight);
        is_veg=(TextView)findViewById(R.id.is_veg);
        drinks=(TextView)findViewById(R.id.drink);

        Intent i=getIntent();
        dataSet= (DataSet) i.getExtras().getSerializable(MyRecAdapter.DATA_ARRAY);
        ethnicity.setText(dataSet.ethnicity);
        status.setText(dataSet.status);
       dob.setText((dataSet.dob).toString());
        height.setText(String.valueOf(dataSet.height));
        weight.setText(String.valueOf(dataSet.ethnicity));
        if(dataSet.is_veg) {
            is_veg.setText("Yes");
        }else{
            is_veg.setText("No");
        }
        if(dataSet.drink){
        drinks.setText("Yes");
        }else{
            drinks.setText("No");
        }
        String Thumburl=dataSet.image;

        loadImages(Thumburl);


    }


    private void loadImages(String urlThumbnail) {
        if (urlThumbnail!=null) {
            mImageLoader.get(urlThumbnail, new ImageLoader.ImageListener() {
                @Override
                public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
                    imageView.setImageBitmap(response.getBitmap());
                }

                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_read, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
