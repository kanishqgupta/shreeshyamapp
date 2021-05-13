package com.yoursuperidea.shyamsena;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;

import com.skydoves.powermenu.MenuAnimation;
import com.skydoves.powermenu.PowerMenu;
import com.skydoves.powermenu.PowerMenuItem;

public class MainActivity extends AppCompatActivity {

    PowerMenu powerMenu;
    ImageView first_menu_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        first_menu_btn = (ImageView) findViewById(R.id.first_menu_btn);

//        powerMenu = new PowerMenu.Builder(getApplicationContext())
//                .addItemList(list) // list has "Novel", "Poerty", "Art"
//                .addItem(new PowerMenuItem("Journals", false)) // add an item.
//                .addItem(new PowerMenuItem("Travel", false)) // aad an item list.
//                .setAnimation(MenuAnimation.SHOWUP_TOP_LEFT) // Animation start point (TOP | LEFT).
//                .setMenuRadius(10f) // sets the corner radius.
//                .setMenuShadow(10f) // sets the shadow.
//                .setTextColor(ContextCompat.getColor(context, R.color.md_grey_800))
//                .setTextGravity(Gravity.CENTER)
//                .setTextTypeface(Typeface.create("sans-serif-medium", Typeface.BOLD))
//                .setSelectedTextColor(Color.WHITE)
//                .setMenuColor(Color.WHITE)
//                .setSelectedMenuColor(ContextCompat.getColor(context, R.color.colorPrimary))
//                .setOnMenuItemClickListener(onMenuItemClickListener)
//                .build();

        first_menu_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                powerMenu.showAsDropDown(view);
            }
        });
    }
}