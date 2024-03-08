package uniandes.dpoo.aerolinea.persistencia;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.Collection;

import org.json.JSONObject;

import java.io.File

import uniandes.dpoo.aerolinea.exceptions.InformacionInconsistenteException;
import uniandes.dpoo.aerolinea.modelo.Aerolinea;
import uniandes.dpoo.aerolinea.modelo.Avion;

public class PersistenciaAerolineaJson implements IPersistenciaAerolinea {

	@Override
	public Aerolinea cargarAerolinea(String archivo, Aerolinea aerolinea)
			throws IOException, InformacionInconsistenteException {
        String jsonCompleto = new String( Files.readAllBytes( new File( archivo ).toPath( ) ) );
        JSONObject raiz = new 
        
        
		return null;
	}

	@Override
	public void salvarAerolinea(String archivo, Aerolinea aerolinea) throws IOException {
        JSONObject jobject = new JSONObject( );
        
        PrintWriter pw = new PrintWriter( archivo );
        jobject.put("aviones", aerolinea.getAviones());
        jobject.put("rutas", aerolinea.getRutas());
        jobject.put("vuelos", aerolinea.getVuelos());
        jobject.put("clientes", aerolinea.getClientes());
        jobject.write( pw, 2, 0 );
        pw.close( );
	}
	
}
