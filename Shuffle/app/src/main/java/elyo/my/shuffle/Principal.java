package elyo.my.shuffle;

import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Display;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class Principal extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        Controles.OnFragmentInteractionListener,
        ListaAlfabetica.OnFragmentInteractionListener,
        ApagadoAutomatico.OnFragmentInteractionListener,
        ApagadoAutomaticoTimer.OnFragmentInteractionListener

{
    @Override
    public void onFragmentInteraction(Uri uri) {

    }
    static int windowWidth, windowHeight;
    static NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();


        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        windowWidth = size.x;
        windowHeight = size.y;

        navigationView.getMenu().getItem(0).setChecked(true);
        getSupportFragmentManager().beginTransaction().replace(R.id.content_principal,new Controles()).commit();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            //super.onBackPressed();
            drawer.openDrawer(GravityCompat.START);
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        if(id==R.id.nav_rep){
            Controles fragment = new Controles();
            transaction.replace(R.id.content_principal,fragment);
        }
        else if (id == R.id.nav_lista) {
            ListaAlfabetica fragment = new ListaAlfabetica();
            transaction.replace(R.id.content_principal,fragment);
        }
        else if (id == R.id.nav_shuffle){
            //Revolver lista de reproduccion
            //Mandar a la pantalla de reproduccion
            Controles fragment = new Controles();
            navigationView.getMenu().getItem(0).setChecked(true);
            transaction.replace(R.id.content_principal,fragment);
        }
        else if (id == R.id.nav_refresh){
            //Riniciar contadores y enviar a la lista de canciones ordenada
            ListaAlfabetica fragment = new ListaAlfabetica();
            navigationView.getMenu().getItem(1).setChecked(true);
            transaction.replace(R.id.content_principal,fragment);
        }
        else if (id == R.id.nav_tiempo){
            ApagadoAutomatico fragment = new ApagadoAutomatico();
            transaction.replace(R.id.content_principal,fragment);
        }
        else if (id == R.id.nav_tiempo2){
            ApagadoAutomaticoTimer fragment = new ApagadoAutomaticoTimer();
            transaction.replace(R.id.content_principal,fragment);
        }
        else if (id == R.id.nav_minimizar){
            //Guardar el indice de la seleccion anterior y volver a ese item
            Controles fragment = new Controles();
            transaction.replace(R.id.content_principal,fragment);
            moveTaskToBack(true);
        }
        else if (id == R.id.nav_shutdown){
            finish();
        }

        transaction.commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
