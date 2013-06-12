package dom.categorias;

import java.util.Date;
import java.util.List;

import org.apache.isis.applib.AbstractContainedObject;
import org.apache.isis.applib.annotation.Hidden;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Named;


import com.google.common.base.Objects;

import dom.categorias.Categoria.Caja;
import dom.categorias.Categoria.Direccion;
import dom.categorias.Categoria.Traccion;


@Named("Categoria")
public class CategoriaServicio extends AbstractContainedObject {

	@MemberOrder(sequence="1")
	public Categoria CargarCategoria(
			@Named("Categoria")String categoria,
			@Named("Cantidad de puertas")int cantPuert,
			@Named("Cantidad de plazas")int cantPlaz,
			@Named("Tipo de caja")Caja caja,
			@Named("Tipo de direccion") Direccion direccion,
			@Named("Tipo de traccion") Traccion traccion,
			@Named("Precio de la categoria")int precio)
	{   
		final String ownedBy = currentUserName();
		return laCategoria(categoria,cantPuert,cantPlaz,caja,direccion,traccion,precio,ownedBy);
	}
	public Categoria laCategoria(
		String cat,
		int cantPuert,
		int cantPlaz,
		Caja caja,
		Direccion direccion,
		Traccion traccion,
		int precio,
		String userName)
		{
			final Categoria categoria= newTransientInstance(Categoria.class);
			categoria.setCategorias(cat);
			categoria.setCantPuertas(cantPuert);
			categoria.setCantPlazas(cantPlaz);
			categoria.setCaja(caja);
			categoria.setDireccion(direccion);
			categoria.setTraccion(traccion);
			categoria.setPrecio(precio);
			categoria.setOwnedBy(userName);
			
			persist(categoria);
			return categoria;
		}
	protected boolean ownedByCurrentUser(final Categoria t) {
	    return Objects.equal(t.getOwnedBy(), currentUserName());
	}
	protected String currentUserName() {
	    return getContainer().getUser().getName();
	}
	
	
}
