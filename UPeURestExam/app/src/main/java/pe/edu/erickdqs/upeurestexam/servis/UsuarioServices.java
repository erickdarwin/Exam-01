package pe.edu.erickdqs.upeurestexam.servis;

import java.util.List;

import pe.edu.erickdqs.upeurestexam.to.EventoTO;
import pe.edu.erickdqs.upeurestexam.to.UsuarioTO;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;



public interface UsuarioServices {
    @GET("/EventoUPeU/user/all")
    Call<List<UsuarioTO>> listarUsuario();

    @GET("/EventoUPeU/event/all")
    Call<List<EventoTO>> listarEvento();

    @POST("/EventoUPeU/user/add")
    Call<UsuarioTO>  guardarUsuario(@Body UsuarioTO usuario);

    @POST("/EventoUPeU/user/login")
    Call<UsuarioTO>  login(@Body UsuarioTO usuario);

}
