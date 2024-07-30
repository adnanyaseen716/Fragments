package pk.adnan.ecommerceapp;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
FrameLayout frameLayout;
BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        frameLayout = findViewById(R.id.frameLayout);
        bottomNavigation = findViewById(R.id.bottomNavigation);


            loadFragment(new HomeFragment());



        bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int itemId = menuItem.getItemId();

                if (itemId == R.id.navHome){
                    loadFragment(new HomeFragment());
                    return true;
                }
                if (itemId == R.id.navCart){
                    loadFragment(new CartFragment());
                    return true;
                }
                if (itemId == R.id.navFavorite){
                    loadFragment(new FavouritesFragment());

                    return true;
                }
                if (itemId == R.id.navProfile){
                    loadFragment(new ProfileFragment());
                    return true;
                }
                return false;
            }
        });

    }


    public void loadFragment (Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frameLayout , fragment);
        transaction.commit();
    }
}