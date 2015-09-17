package com.example.noviceguide;

import android.R.id;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends Activity {

  // public List<File> Localphotos_List = new ArrayList<File>();
  private static final int[] pics = { R.drawable.guide1, R.drawable.guide2, R.drawable.guide3, R.drawable.guide4, R.drawable.guide5 };

  private ViewPager mViewPager;
  private ImageView mPage0;
  private ImageView mPage1;
  private ImageView mPage2;
  private ImageView mPage3;
  private ImageView mPage4;
  private Button start_bn;

  private boolean isFirste;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    setContentView(R.layout.activity_main);

    // getPhotos();

    // isFirste =
    // SharedPreferencesUtils.getFirstLoginState(this.getApplicationContext());

    mViewPager = (ViewPager) findViewById(R.id.whatsnew_viewpager);
    start_bn = (Button) findViewById(R.id.start_bn);
    start_bn.setOnClickListener(new View.OnClickListener() {
      
      @Override
      public void onClick(View v) {
        
        
      }
    });
    
    mViewPager.setOnPageChangeListener(new MyOnPageChangeListener());

    mPage0 = (ImageView) findViewById(R.id.page0);
    mPage1 = (ImageView) findViewById(R.id.page1);
    mPage2 = (ImageView) findViewById(R.id.page2);
    mPage3 = (ImageView) findViewById(R.id.page3);
    mPage4 = (ImageView) findViewById(R.id.page4);

    final ArrayList<ImageView> list = new ArrayList<ImageView>();
    // 初始化引导图片列表
    for (int i = 0; i < pics.length; i++) {
      ImageView iv = new ImageView(this);
      iv.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
      iv.setImageResource(pics[i]);
      iv.setScaleType(ImageView.ScaleType.CENTER_CROP); 
      list.add(iv);
    }

    /*
     * if (isFirste) { mPage3.setVisibility(View.VISIBLE); list.add(view4); }
     * else { mPage3.setVisibility(View.GONE); }
     */

    PagerAdapter adapter = new PagerAdapter() {

      @Override
      public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
      }

      @Override
      public int getCount() {
        return list.size();
      }

      @Override
      public void destroyItem(View container, int position, Object object) {
        ((ViewPager) container).removeView(list.get(position));
      }

      @Override
      public Object instantiateItem(View container, int position) {
        ((ViewPager) container).addView(list.get(position));
        return list.get(position);
      }
    };

    mViewPager.setAdapter(adapter);
  }

  public class MyOnPageChangeListener implements OnPageChangeListener {

    @Override
    public void onPageScrollStateChanged(int arg0) {

    }

    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {

    }

    @Override
    public void onPageSelected(int arg0) {
      switch (arg0) {
        case 0:
          display();
          mPage0.setImageDrawable(getResources().getDrawable(R.drawable.page_now));
          mPage1.setImageDrawable(getResources().getDrawable(R.drawable.page));
          mPage2.setImageDrawable(getResources().getDrawable(R.drawable.page));
          mPage3.setImageDrawable(getResources().getDrawable(R.drawable.page));
          mPage4.setImageDrawable(getResources().getDrawable(R.drawable.page));
          break;

        case 1:
          display();
          mPage0.setImageDrawable(getResources().getDrawable(R.drawable.page));
          mPage1.setImageDrawable(getResources().getDrawable(R.drawable.page_now));
          mPage2.setImageDrawable(getResources().getDrawable(R.drawable.page));
          mPage3.setImageDrawable(getResources().getDrawable(R.drawable.page));
          mPage4.setImageDrawable(getResources().getDrawable(R.drawable.page));
          break;

        case 2:
          display();
          mPage0.setImageDrawable(getResources().getDrawable(R.drawable.page));
          mPage1.setImageDrawable(getResources().getDrawable(R.drawable.page));
          mPage2.setImageDrawable(getResources().getDrawable(R.drawable.page_now));
          mPage3.setImageDrawable(getResources().getDrawable(R.drawable.page));
          mPage4.setImageDrawable(getResources().getDrawable(R.drawable.page));
          break;

        case 3:
          display();
          mPage0.setImageDrawable(getResources().getDrawable(R.drawable.page));
          mPage1.setImageDrawable(getResources().getDrawable(R.drawable.page));
          mPage2.setImageDrawable(getResources().getDrawable(R.drawable.page));
          mPage3.setImageDrawable(getResources().getDrawable(R.drawable.page_now));
          mPage4.setImageDrawable(getResources().getDrawable(R.drawable.page));
          
/*          mPage3.setVisibility(View.GONE);
          mPage0.setVisibility(View.GONE);
          mPage1.setVisibility(View.GONE);
          mPage2.setVisibility(View.GONE);*/

          /*
           * SharedPreferencesUtils.saveFirstLoginState(Activity_WhatsNew.this.
           * getApplicationContext()); File dbFile = new
           * File(ResourceManager.DBDIR_PATH + "/userprofiledb.db"); if
           * (!dbFile.exists()) { UserProfileDB.instance().createNew(); } new
           * Handler().postDelayed(new Runnable() { public void run() {
           * startActivity(new Intent(Activity_WhatsNew.this,
           * Activity_LoginForFirst.class)); finish(); } }, 500);
           */
          break;
         
        case 4:
/*          mPage0.setImageDrawable(getResources().getDrawable(R.drawable.page));
          mPage1.setImageDrawable(getResources().getDrawable(R.drawable.page));
          mPage2.setImageDrawable(getResources().getDrawable(R.drawable.page));
          mPage3.setImageDrawable(getResources().getDrawable(R.drawable.page));
          mPage4.setImageDrawable(getResources().getDrawable(R.drawable.page_now));*/
          hide();
          break;
      }
    }
  }
  
  
  private void hide() {
    mPage0.setVisibility(View.GONE);
    mPage1.setVisibility(View.GONE);
    mPage2.setVisibility(View.GONE);
    mPage3.setVisibility(View.GONE);
    mPage4.setVisibility(View.GONE);
    start_bn.setVisibility(View.VISIBLE);
  }
  
  private void display() {
    mPage0.setVisibility(View.VISIBLE);
    mPage1.setVisibility(View.VISIBLE);
    mPage2.setVisibility(View.VISIBLE);
    mPage3.setVisibility(View.VISIBLE);
    mPage4.setVisibility(View.VISIBLE);
    start_bn.setVisibility(View.GONE);
  }

}
