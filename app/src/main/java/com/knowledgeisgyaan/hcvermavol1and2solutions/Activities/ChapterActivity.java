package com.knowledgeisgyaan.hcvermavol1and2solutions.Activities;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.knowledgeisgyaan.hcvermavol1and2solutions.Models.*;
import com.knowledgeisgyaan.hcvermavol1and2solutions.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ChapterActivity extends AppCompatActivity {

    ViewPager viewPager;
    LinearLayout sliderdots;
    private int dotcount;
    private ImageView[] dots;

    private List<String> bannerDataList;

    ListView chapters;

    ArrayList<chapter> list1;
    ArrayList<chapter> list2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter);

        chapters = (ListView) findViewById(R.id.chptrs);
        list1 = new ArrayList<chapter>();
        list2 = new ArrayList<chapter>();

        bannerDataList = new ArrayList<String>();

        getjson();
        setViewPager();


        String volnum = getIntent().getStringExtra("Vol");
        String Vol = " ";
        if(volnum.equals("0")){
            Vol = "Volume 1";
            setData1();
            setAdapter1();
        } else if(volnum.equals("1")) {
            Vol = "Volume 2";
            setData2();
            setAdapter2();
        }

        getSupportActionBar().setTitle(Vol);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }


    private void setViewPager() {

        viewPager = (ViewPager) findViewById(R.id.v_pager2);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this,bannerDataList);
        viewPager.setAdapter(viewPagerAdapter);

        sliderdots = (LinearLayout) findViewById(R.id.llayout);
        dotcount = viewPagerAdapter.getCount();

        dots = new ImageView[dotcount];

        for(int i=0;i<dotcount;i++)  {
            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.nonactive_dot));

            LinearLayout.LayoutParams params= new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(8, 0,8,0);
            sliderdots.addView(dots[i], params);
        }
        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.active_dot));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                for(int j=0;j<dotcount;j++) {
                    dots[j].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.nonactive_dot));
                }
                dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.active_dot));
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });


    }

    private void getjson() {
        String json;
        try{
            InputStream inputStream = getAssets().open("app.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer,"UTF-8");
            JSONObject obj = new JSONObject(json);
            JSONArray jsonArray = obj.getJSONArray("bannersdata");
            for(int i=0;i<jsonArray.length();i++) {
                JSONObject url = jsonArray.getJSONObject(i);
                String urlString = url.getString("url");
                bannerDataList.add(urlString);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void setAdapter1() {

        ChapterAdapter adapter = new ChapterAdapter(this, list1);
        chapters.setAdapter(adapter);

        chapters.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String chpName = list1.get(position).getChp();
                String chpnum = list1.get(position).getNum();
                Intent intent = new Intent(ChapterActivity.this,PdfActivity.class);
                intent.putExtra("chapter",chpName);
                intent.putExtra("number",chpnum);
                startActivity(intent);
            }
        });
    }

    private void setData1() {

        chapter c1 = new chapter("Introduction to Physics", "1");
        chapter c2 = new chapter("Physics and Mathematics", "2");
        chapter c3 = new chapter("Rest and Motion : Kinematics ", "3");
        chapter c4 = new chapter("The Forces", "4");
        chapter c5 = new chapter("Newton's Laws of Motion", "5");
        chapter c6 = new chapter("Friction", "6");
        chapter c7 = new chapter("Circular Motion", "7");
        chapter c8 = new chapter("Work and Energy", "8");
        chapter c9 = new chapter("Centre of Mass, Linear Momentum, Collision", "9");
        chapter c10 = new chapter("Rotational Mechanics", "10");
        chapter c11 = new chapter("Gravitation", "11");
        chapter c12 = new chapter("Simple Harmonic Motion", "12");
        chapter c13 = new chapter("Fluid Mechanics", "13");
        chapter c14 = new chapter("Some Mechanical Properties of Matter", "14");
        chapter c15 = new chapter("Wave Motion and Waves on a String", "15");
        chapter c16 = new chapter("Sound Waves", "16");
        chapter c17 = new chapter("Light Waves", "17");
        chapter c18 = new chapter("Geometrical Optics", "18");
        chapter c19 = new chapter("Optical Instruments", "19");
        chapter c20 = new chapter("Dispersion and Spectra", "20");
        chapter c21 = new chapter("Speed of Light", "21");
        chapter c22 = new chapter("Photometry", "22");

        list1.add(c1);
        list1.add(c2);
        list1.add(c3);
        list1.add(c4);
        list1.add(c5);
        list1.add(c6);
        list1.add(c7);
        list1.add(c8);
        list1.add(c9);
        list1.add(c10);
        list1.add(c11);
        list1.add(c12);
        list1.add(c13);
        list1.add(c14);
        list1.add(c15);
        list1.add(c16);
        list1.add(c17);
        list1.add(c18);
        list1.add(c19);
        list1.add(c20);
        list1.add(c21);
        list1.add(c22);
    }

    private void setAdapter2() {

        ChapterAdapter adapter = new ChapterAdapter(this, list2);
        chapters.setAdapter(adapter);

        chapters.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String chpName = list2.get(position).getChp();
                String chpnum = list2.get(position).getNum();
                Intent intent = new Intent(ChapterActivity.this,PdfActivity.class);
                intent.putExtra("chapter",chpName);
                intent.putExtra("number",chpnum);
                startActivity(intent);
            }
        });
    }

    private void setData2() {

        chapter c1 = new chapter("Heat and Temperature", "23");
        chapter c2 = new chapter("Kinetic Theory of Gases", "24");
        chapter c3 = new chapter("Calorimetry", "25");
        chapter c4 = new chapter("Laws of Thermodynamics", "26");
        chapter c5 = new chapter("Specific Heat Capacities of Gases", "27");
        chapter c6 = new chapter("Heat Transfer", "28");
        chapter c7 = new chapter("Electric Field and Potential", "29");
        chapter c8 = new chapter("Gauss's Law", "30");
        chapter c9 = new chapter("Capacitors", "31");
        chapter c10 = new chapter("Electric Current in Conductors", "32");
        chapter c11 = new chapter("Thermal and Chemical Effects of Electric Current", "33");
        chapter c12 = new chapter("Magnetic Field", "34");
        chapter c13 = new chapter("Magnetic Field due to a Current", "35");
        chapter c14 = new chapter("Permanent Magnets", "36");
        chapter c15 = new chapter("Magnetic Properties of Matter", "37");
        chapter c16 = new chapter("Electromagnetic Induction", "38");
        chapter c17 = new chapter("Alternating Current", "39");
        chapter c18 = new chapter("Electromagnetic Waves", "40");
        chapter c19 = new chapter("Electric Current through Gases", "41");
        chapter c20 = new chapter("Photoelectric Effect and Wave-Particle Duality", "42");
        chapter c21 = new chapter("Bohr's Model and Physics of the Atom", "43");
        chapter c22 = new chapter("X-rays", "44");
        chapter c23 = new chapter("Semiconductors and Semiconductor Devices", "45");
        chapter c24 = new chapter("The Nucleus", "46");
        chapter c25 = new chapter("The Special Theory of Relativity", "47");



        list2.add(c1);
        list2.add(c2);
        list2.add(c3);
        list2.add(c4);
        list2.add(c5);
        list2.add(c6);
        list2.add(c7);
        list2.add(c8);
        list2.add(c9);
        list2.add(c10);
        list2.add(c11);
        list2.add(c12);
        list2.add(c13);
        list2.add(c14);
        list2.add(c15);
        list2.add(c16);
        list2.add(c17);
        list2.add(c18);
        list2.add(c19);
        list2.add(c20);
        list2.add(c21);
        list2.add(c22);
        list2.add(c23);
        list2.add(c24);
        list2.add(c25);

    }


}