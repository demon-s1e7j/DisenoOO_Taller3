package uniandes.dpoo.aerolinea.persistencia;

import uniandes.dpoo.aerolinea.exceptions.InformacionInconsistenteException;
import uniandes.dpoo.aerolinea.modelo.Aerolinea;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 * Esta clase no está implementada - y no debería implementarse como parte del taller.
 * 
 * Su objetivo es sólo ilustrar que podría haber varias implementaciones de la misma interfaz, y que durante la ejecución alguien podría decidir cuál de estas implementaciones
 * usar.
 */
public class PersistenciaAerolineaPlaintext implements IPersistenciaAerolinea
{
    @Override
    public Aerolinea cargarAerolinea( String archivo, Aerolinea aerolinea ) throws java.io.IOException ,InformacionInconsistenteException
    {
    	Aerolinea obj;
    	try {
    	FileInputStream file = new FileInputStream(archivo);
    	ObjectInputStream in = new ObjectInputStream(file);
    	
    	obj = (Aerolinea) in.readObject();
    	}
    	catch (ClassNotFoundException ex) {
    		obj = null;
    		System.out.println("Class not Found is caught");
    	}
    	return obj;
    }

    @Override
    public void salvarAerolinea( String archivo, Aerolinea aerolinea ) throws IOException
    {
    	FileOutputStream file = new FileOutputStream(archivo);
        ObjectOutputStream out = new ObjectOutputStream(file);
        
        out.writeObject(aerolinea);
        
        out.close();
        file.close();
         
    }

}
