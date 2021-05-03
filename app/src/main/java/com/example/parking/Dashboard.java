package com.example.parking;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.parking.R.id;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class Dashboard extends AppCompatActivity {
// Navbar code
    DrawerLayout drawerLayout;
    NavigationView nav;
    ActionBarDrawerToggle toggle;

// Tablayout code
TabLayout tabLayout;
TabItem tab1,tab2,tab3;
ViewPager viewPager;
PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

 // Code for Navigation drawer is written in this segment
      Toolbar  toolbar = findViewById(R.id.toolbar);
      setSupportActionBar(toolbar);


      nav = findViewById(R.id.navbar);
      drawerLayout = findViewById(R.id.drawer);

      toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
      drawerLayout.addDrawerListener(toggle);
      toggle.syncState();

      nav.setNavigationItemSelectedListener(item -> {

          switch (item.getItemId()){

              case id.menu_home:
                  Toast.makeText(Dashboard.this, "The Home is open", Toast.LENGTH_SHORT).show();
                  drawerLayout.closeDrawer(GravityCompat.START);
                  break;

              case id.menu_maps:
                  Toast.makeText(Dashboard.this, "The Location is open", Toast.LENGTH_SHORT).show();
                  drawerLayout.closeDrawer(GravityCompat.START);
                  break;

              case id.menu_shop:
                  Toast.makeText(Dashboard.this, "The Shopping is Open", Toast.LENGTH_SHORT).show();
                  drawerLayout.closeDrawer(GravityCompat.START);
                  break;

              case id.menu_setting:
                  Toast.makeText(Dashboard.this, "The settings is open", Toast.LENGTH_SHORT).show();
                  drawerLayout.closeDrawer(GravityCompat.START);
                  break;
              default:
                  throw new IllegalStateException("Unexpected value: " + item.getItemId());
          }
          return true;
      });
      // Navigation drawer code is ended here
// Tablayout working with fragment with the help of viewpager and pageAdapter
        tabLayout = findViewById(R.id.TabLayout);
        tab1 = findViewById(R.id.Tab1);
        tab2 = findViewById(R.id.Tab2);
        tab3 = findViewById(R.id.Tab3);
        viewPager = findViewById(R.id.viewpager);

// this pageAdapter excepts two parameter fragmentmanager and tabcount and then assign fragments to that tab
        pagerAdapter = new PagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));


    }


}