package pk.adnan.ecommerceapp;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
//BottomNavigationView bottomNavigation;
    Button btnWriteReview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.product_click_listener);
        btnWriteReview = findViewById(R.id.btnWriteReview);

        btnWriteReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.write_review_dlg);

                dialog.show();

                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT , ViewGroup.LayoutParams.WRAP_CONTENT);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
                dialog.getWindow().setGravity(Gravity.BOTTOM);

            }
        });




//
//
//        bottomNavigation = findViewById(R.id.bottomNavigation);
//
//        loadFragment(new HomeFragment());
//
//
//        bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//                int itemId = menuItem.getItemId();
//
//                if (itemId == R.id.navHome){
//                    loadFragment(new HomeFragment());
//
//                    return true;
//                }
//                if (itemId == R.id.navCart){
//                    loadFragment(new CartFragment());
//                    return true;
//                }
//                if (itemId == R.id.navFavorite){
//                    loadFragment(new FavouritesFragment());
//                    return true;
//                }
//                if (itemId == R.id.navProfile){
//
//                    loadFragment(new ProfileFragment());
//
//                    return true;
//
//                }
//                return false;
//            }
//        });

    }


    public void loadFragment (Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frameLayout , fragment);
        transaction.commit();
    }

}