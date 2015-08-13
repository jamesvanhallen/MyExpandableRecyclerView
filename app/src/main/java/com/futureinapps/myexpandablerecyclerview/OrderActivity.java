package com.futureinapps.myexpandablerecyclerview;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by fappsilya on 23.07.15.
 */
public class OrderActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.tabLayout)
    TabLayout tabs;
    @Bind(R.id.viewPager)
    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        ButterKnife.bind(this);

        toolbar.setNavigationIcon(ContextCompat.getDrawable(this, R.drawable.back_arrow));

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("MyExpandableRecyclerView");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        initTabsAndPager();
    }

    public void initTabsAndPager() {
        setupViewPager(pager);
        tabs.setupWithViewPager(pager);
    }

    private void setupViewPager(ViewPager viewPager) {
        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
        NewsFragment newsFragment = new NewsFragment();
        ContentFragment contentFragment = new ContentFragment();
        adapter.addFrag(newsFragment, "Simple RV");
        adapter.addFrag(contentFragment, "Expandable RV");
        viewPager.setAdapter(adapter);
    }

}
