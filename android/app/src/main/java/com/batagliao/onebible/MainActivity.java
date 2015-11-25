package com.batagliao.onebible;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.batagliao.onebible.interfaces.NavigationEnabledActivity;
import com.batagliao.onebible.util.NavigationService;

public class MainActivity extends AppCompatActivity implements NavigationEnabledActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NavigationService.getInstance().RegisterContext(this, this);

        Fragment fragment = MainActivityFragment.newInstance();
        NavigationService.getInstance().Navigate(this, fragment);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        NavigationService.getInstance().UnregisterContext(this);
    }

    @Override
    public View getFragmentPlaceholder() {
        return findViewById(R.id.fragmentPlaceholder);
    }
}
