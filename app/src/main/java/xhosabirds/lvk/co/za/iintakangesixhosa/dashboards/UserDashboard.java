package xhosabirds.lvk.co.za.iintakangesixhosa.dashboards;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import xhosabirds.lvk.co.za.iintakangesixhosa.HelperClasses.HomeAdapter.CategoriesAdapter;
import xhosabirds.lvk.co.za.iintakangesixhosa.HelperClasses.HomeAdapter.CategoriesHelperClass;
import xhosabirds.lvk.co.za.iintakangesixhosa.HelperClasses.HomeAdapter.FeaturedAdapter;
import xhosabirds.lvk.co.za.iintakangesixhosa.HelperClasses.HomeAdapter.FeaturedHelperClass;
import xhosabirds.lvk.co.za.iintakangesixhosa.HelperClasses.HomeAdapter.MostViewedAdapter;
import xhosabirds.lvk.co.za.iintakangesixhosa.HelperClasses.HomeAdapter.MostViewedHelperClass;
import xhosabirds.lvk.co.za.iintakangesixhosa.R;

public class UserDashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    RecyclerView featuredRecycler, mostViewedRecycler, catRecycler;
    RecyclerView.Adapter adapter;
    RecyclerView.Adapter msAdapter;
    RecyclerView.Adapter catAdapter;
    ImageView menuIcon;

    //drawer menu
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);

        featuredRecycler = (RecyclerView) findViewById(R.id.featured_recycler);
        mostViewedRecycler = (RecyclerView) findViewById(R.id.ms_recycler);
        catRecycler = (RecyclerView) findViewById(R.id.cat_recycler);
        menuIcon = (ImageView) findViewById(R.id.menu_icon);


        //drawer hooks
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);


        navigationDrawer();

        featuredRecycler();
        mostViewedRecycler();
        categoriesRecycler();

    }

    private void navigationDrawer() {

        //navigation drawer
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);

        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                }else{
                    drawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });


    }

    private void categoriesRecycler() {

        catRecycler.setHasFixedSize(true);
        catRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<CategoriesHelperClass> categories = new ArrayList<>();
        categories.add(new CategoriesHelperClass(R.drawable.restaurants, "Restaurants"));
        categories.add(new CategoriesHelperClass(R.drawable.hotelss, "Hotels"));
        categories.add(new CategoriesHelperClass(R.drawable.schoolss, "Schools"));

        catAdapter = new CategoriesAdapter(categories);
        catRecycler.setAdapter(catAdapter);

    }

    private void mostViewedRecycler() {
        mostViewedRecycler.setHasFixedSize(true);
        mostViewedRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<MostViewedHelperClass> mostViewed = new ArrayList<>();
        mostViewed.add(new MostViewedHelperClass(R.drawable.mcdonalds, "McDonalds", "hjhjhjhfjhjghjhfjhfjhjhfjhfhjfhjhf"));
        mostViewed.add(new MostViewedHelperClass(R.drawable.steers, "Steers", "hjhjhjhfjhjghjhfjhfjhjhfjhfhjfhjhf"));
        mostViewed.add(new MostViewedHelperClass(R.drawable.kfc, "KFC", "hjhjhjhfjhjghjhfjhfjhjhfjhfhjfhjhf"));

        msAdapter = new MostViewedAdapter(mostViewed);
        mostViewedRecycler.setAdapter(msAdapter);
    }

    private void featuredRecycler() {

        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<FeaturedHelperClass> featuredLocations = new ArrayList<>();
        featuredLocations.add(new FeaturedHelperClass(R.drawable.mcdonalds, "McDonalds", "hjhjhjhfjhjghjhfjhfjhjhfjhfhjfhjhf"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.steers, "Steers", "hjhjhjhfjhjghjhfjhfjhjhfjhfhjfhjhf"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.kfc, "KFC", "hjhjhjhfjhjghjhfjhfjhjhfjhfhjfhjhf"));

        adapter = new FeaturedAdapter(featuredLocations);
        featuredRecycler.setAdapter(adapter);


    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerVisible(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else
        super.onBackPressed();
    }



    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        return true;
    }
}
