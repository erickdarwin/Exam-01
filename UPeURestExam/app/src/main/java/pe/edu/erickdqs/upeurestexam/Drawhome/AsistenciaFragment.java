package pe.edu.erickdqs.upeurestexam.Drawhome;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import pe.edu.erickdqs.upeurestexam.R;


public class AsistenciaFragment extends Fragment {

    Button btnRegistrar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myFragmentView= inflater.inflate(R.layout.fragment_asistencia, container, false);

        btnRegistrar=myFragmentView.findViewById(R.id.button);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Context context=v.getContext();
                Intent intent=new Intent();
                intent.putExtra("idUsuario", 1);
                intent.setClass(v.getContext(), SimpleScannerActivity.class);
                startActivity(intent);
            }
        });
        return myFragmentView;
    }



}
