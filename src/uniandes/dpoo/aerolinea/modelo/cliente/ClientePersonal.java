package uniandes.dpoo.aerolinea.modelo.cliente;

public class ClientePersonal extends Cliente {
	
	public static final String NATURAL = "Natural";
	private String name;
	
	
	public ClientePersonal(String name) {
		super();
		this.name = name;
	}

	@Override
	public String getTipoCliente() {
		return ClientePersonal.NATURAL;
	}

	@Override
	public String getIdentificador() {
		return this.toString();
	}

}
