package uniandes.dpoo.aerolinea.tiquetes;

import uniandes.dpoo.aerolinea.modelo.cliente.*;
import uniandes.dpoo.aerolinea.modelo.*;

public class Tiquete {
	private Cliente cliente;
	private String codigo;
	private int tarifa;
	private boolean usado;
	private Vuelo vuelo;
	
	
	public Tiquete(Cliente cliente, String codigo, int tarifa, boolean usado, Vuelo vuelo) {
		super();
		this.cliente = cliente;
		this.codigo = codigo;
		this.tarifa = tarifa;
		this.usado = usado;
		this.vuelo = vuelo;
	}


	public Tiquete(String codigo, Vuelo vuelo, Cliente cliente, int tarifa) {
		super();
		this.cliente = cliente;
		this.codigo = codigo;
		this.tarifa = tarifa;
		this.usado = false;
		this.vuelo = vuelo;
	}


	public Cliente getCliente() {
		return cliente;
	}

	public String getCodigo() {
		return codigo;
	}

	public int getTarifa() {
		return tarifa;
	}

	public Vuelo getVuelo() {
		return vuelo;
	}
	
	public void marcarComoUsado() {
		this.usado = true;
	}
	
	public boolean esUsado() {
		return usado;
	}

}
