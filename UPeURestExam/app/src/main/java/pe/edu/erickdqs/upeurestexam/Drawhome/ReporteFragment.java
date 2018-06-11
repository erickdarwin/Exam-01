package pe.edu.erickdqs.upeurestexam.Drawhome;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import java.util.List;

import pe.edu.erickdqs.upeurestexam.R;
import pe.edu.erickdqs.upeurestexam.dao.EventoDao;
import pe.edu.erickdqs.upeurestexam.servis.UsuarioServices;
import pe.edu.erickdqs.upeurestexam.to.EventoTO;
import pe.edu.erickdqs.upeurestexam.util.EventoAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ReporteFragment extends Fragment {
    private EventoDao dao;
    List<EventoTO> evento;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter<EventoAdapter.EventoViewHolder> adapter;
    private RecyclerView.LayoutManager layoutManager;
    public final String TAG=this.getClass().getSimpleName();
    Retrofit retrofit;
    UsuarioServices usuarioServis;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View myFragmentView= inflater.inflate(R.layout.fragment_reporte, container, false);

        this.recyclerView=(RecyclerView)myFragmentView.findViewById(R.id.recyclerView);
        this.layoutManager = new LinearLayoutManager(this.getContext());

        // Rest
        retrofit=new Retrofit.Builder()
                .baseUrl("http://192.168.0.101:8084/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        usuarioServis=retrofit.create(UsuarioServices.class);
        Call<List<EventoTO>> listarEventoTodos=usuarioServis.listarEvento();
        listarEventoTodos.enqueue(new Callback<List<EventoTO>>() {
            @Override
            public void onResponse(Call<List<EventoTO>> call, Response<List<EventoTO>> response) {
                evento = (List<EventoTO>)response.body();
                Toast.makeText(getContext(), "Llego.......!", Toast.LENGTH_SHORT).show();
//                Log.e(TAG,"Llego.......!"+response.body().size());
            }

            @Override
            public void onFailure(Call<List<EventoTO>> call, Throwable t) {
                Toast.makeText(getContext(), "Error al recuperar rest", Toast.LENGTH_SHORT).show();
//                Log.e(TAG,"Error al recuperar el Servicio Rest de Usuario!");
            }
        });

//        dao=new EventoDao(this.getContext());
//        evento=dao.ListarEvento();
//        Log.v("DMP", "Cantidad: "+evento.size());
        this.adapter=new EventoAdapter(evento);
        this.recyclerView.setLayoutManager(layoutManager);
        this.recyclerView.setAdapter(adapter);

        return myFragmentView;
    }


}
