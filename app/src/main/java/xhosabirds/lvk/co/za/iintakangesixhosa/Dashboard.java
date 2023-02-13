package xhosabirds.lvk.co.za.iintakangesixhosa;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


public class Dashboard extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    Fragment fragmentt;

    ImageView left, men;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavView);
        bottomNavigationView.getMenu().getItem(2).setEnabled(false);

        left = (ImageView) findViewById(R.id.left_arrow);
        text = (TextView) findViewById(R.id.text);
        men = (ImageView) findViewById(R.id.menu);

        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Dashboard.this, "Back clicked", Toast.LENGTH_SHORT).show();
            }
        });

        men.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showMenu(v);
            }
        });

    }

    private void showMenu(View v) {

        PopupMenu popupMenu = new PopupMenu(Dashboard.this, v);
        popupMenu.getMenuInflater().inflate(R.menu.bottom_nav_menu, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.action_home) {
                    Toast.makeText(Dashboard.this, "Home selected", Toast.LENGTH_SHORT).show();
                }
                return true;
            }

        });

        popupMenu.show();
    }

    public void swapFragmant(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.container, fragment);
    }

}
