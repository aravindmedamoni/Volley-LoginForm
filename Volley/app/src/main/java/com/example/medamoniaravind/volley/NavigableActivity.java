package com.example.medamoniaravind.volley;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.medamoniaravind.volley.Fragments.AboutFragment;
import com.example.medamoniaravind.volley.Fragments.ContactsFragment;
import com.example.medamoniaravind.volley.Fragments.HomeFragment;
import com.example.medamoniaravind.volley.Fragments.MyTicketsFragment;
import com.example.medamoniaravind.volley.Fragments.ProfileFragment;
import com.example.medamoniaravind.volley.Fragments.TermsnCondFragment;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class NavigableActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
  //  TextView nvgtv1,nvgtv2;
   //
    String nvgmbnum,Tokenid,usrid;
    String url="http://vdtlabs.com/eventzapp/api.php?";
    int numbercode=0;
    NavigationView navigationView;
    SharedPreferences spreferences,sharedPreferences;
    String nv_token;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      /*  nvgtv1=findViewById(R.id.nvtxvw);
        nvgtv2=findViewById(R.id.textView);*/
        spreferences=getSharedPreferences("sp",MODE_PRIVATE);
       //nvgtv1.setText(spreferences.getString("mobile",null));
       // nvgtv2.setText(spreferences.getString("password",null));
        sharedPreferences=getSharedPreferences("abhi",MODE_PRIVATE);
       nv_token=sharedPreferences.getString("token",null);
        setContentView(R.layout.activity_navigable);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        HomeFragment homeFragment=new HomeFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,homeFragment).commit();
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

         navigationView = (NavigationView) findViewById(R.id.nav_view);
        //navigationView.getHeaderView(0).findViewById(R.id.nvtxvw);

        navigationView.setNavigationItemSelectedListener(this);


        sendTokenToServer(nv_token);
    }

    private void sendTokenToServer(String token) {
        StringRequest stringRequest;
        stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    String status=jsonObject.getString("error");
                    String msg=jsonObject.getString("msg");
                    if (status.equals("FALSE")){
                        Toast.makeText(NavigableActivity.this,msg, Toast.LENGTH_SHORT).show();

                    }else {
                        Toast.makeText(NavigableActivity.this,msg, Toast.LENGTH_SHORT).show();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> hashMap=new HashMap<String,String>();
                hashMap.put("token",Tokenid);
                hashMap.put("id",usrid);

                return hashMap;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(NavigableActivity.this);
        requestQueue.add(stringRequest);


    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }else if (!(numbercode==0)){
            numbercode=0;
            navigationView.setCheckedItem(R.id.nav_home);
            HomeFragment homeFragment=new HomeFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,homeFragment).commit();

        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigable, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home){
            numbercode=0;
            HomeFragment homeFragment=new HomeFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,homeFragment).commit();
            // Handle the camera action
        } else if (id == R.id.nav_mytickets) {
            numbercode=1;
            MyTicketsFragment myTicketsFragment=new MyTicketsFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,myTicketsFragment).commit();

        } else if (id == R.id.nav_contacts) {
            numbercode=2;
            ContactsFragment contactsFragment=new ContactsFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,contactsFragment).commit();

        } else if (id == R.id.nav_about) {
            numbercode=3;
            AboutFragment aboutFragment=new AboutFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,aboutFragment).commit();

        } else if (id==R.id.nav_rateus) {
            Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id="+getPackageName()));
            startActivity(intent);

        } else if (id == R.id.nav_share) {
            Intent intent=new Intent((Intent.ACTION_SEND));
            intent.putExtra(Intent.EXTRA_SUBJECT, "Install the app");
            intent.putExtra(Intent.EXTRA_TEXT,"http://play.google.com/store/apps/details?id="+getPackageName());
            startActivity(Intent.createChooser(intent,"choose one"));

        } else if (id==R.id.termsncond){
            numbercode=4;
            TermsnCondFragment termsnCondFragment=new TermsnCondFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,termsnCondFragment).commit();

        }else if (id==R.id.nav_profile){
            numbercode=5;
            ProfileFragment profileFragment=new ProfileFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,profileFragment).commit();

        }  else if (id==R.id.logout){
            editor=spreferences.edit();
            editor.putString("mobile","null");
            editor.putString("password","null");
            editor.commit();
            finish();
            startActivity(new Intent(NavigableActivity.this,MainActivity.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
