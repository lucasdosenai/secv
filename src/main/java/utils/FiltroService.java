package utils;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import javax.faces.bean.ManagedBean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import entity.Cidade;
import entity.Curriculo;
import entity.Filtro;
import service.ClasseGenerica;
import service.CurriculumVitae;

@ManagedBean
public class FiltroService {
// MANDO ESSE CARA
	private Filtro eFiltro = new Filtro();

	public List<CurriculumVitae> enviarFiltro(Filtro f) throws IOException {

		String url = "http://10.0.2.2:8080/aula_rest/ws/filmes/todos"; // URL FICTICIO!

		HttpHelper http = new HttpHelper();

		Gson gson = new Gson();

		String json = gson.toJson(f, Filtro.class);
		http.setContentType("application/json");

		String response = http.doPost(url, json.getBytes(), "UTF-8");

		Type collectionType = new TypeToken<List<CurriculumVitae>>() {
		}.getType();
		List<CurriculumVitae> curriculos = gson.fromJson(response, collectionType);

		return curriculos;
	}

	public List<ClasseGenerica> cGenerico() throws IOException {

		String url = "http://10.0.2.2:8080/aula_rest/ws/filmes/todos"; // URL FICTICIO!

		HttpHelper http = new HttpHelper();

		Gson gson = new Gson();
		
		ClasseGenerica c = new ClasseGenerica();

		String response = http.doGet(url);

		Type collectionType = new TypeToken<List<ClasseGenerica>>() {
		}.getType();

		List<ClasseGenerica> cidades = gson.fromJson(response, collectionType);
		
		
	//	String json = gson.fromJson();


		return null;
	}
	
	
	

	public Filtro geteFiltro() {
		return eFiltro;
	}

	public void seteFiltro(Filtro eFiltro) {
		this.eFiltro = eFiltro;
	}

}
