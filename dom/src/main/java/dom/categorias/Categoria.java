package dom.categorias;

import java.util.Date;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.VersionStrategy;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.DescribedAs;
import org.apache.isis.applib.annotation.Hidden;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.RegEx;
import org.apache.isis.applib.util.TitleBuffer;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;





@javax.jdo.annotations.PersistenceCapable(identityType=IdentityType.DATASTORE)
@javax.jdo.annotations.DatastoreIdentity(strategy=javax.jdo.annotations.IdGeneratorStrategy.IDENTITY)
@javax.jdo.annotations.Query(name="listado", language="JDQL",value="SELECT * FROM dom.autos.Categoria")
@javax.jdo.annotations.Version(strategy=VersionStrategy.VERSION_NUMBER, column="VERSION")

public class Categoria 
{

    public static enum Caja
    {
    	AUTOMATICA, MANUAL;
    }
    
    public static enum Direccion
    {
    	ASISTIDA, HIDRAULICA, MECANICA
    }
    
    public static enum Traccion
    {
    	CUATROx4 , CUATROx2 ;
    }
    
    
    public String title() 
	{
		final TitleBuffer buf = new TitleBuffer();
        buf.append(getCategorias());
        return buf.toString();
	} 
    
    private String ownedBy;
    @Hidden
	// not shown in the UI
	public String getOwnedBy() {
	    return ownedBy;
	}

	public void setOwnedBy(final String ownedBy) {
	    this.ownedBy = ownedBy;
	}  
    
	private String categorias;
	
	@RegEx(validation = "\\w[@&:\\-\\,\\.\\+ \\w]*")
	@MemberOrder(sequence="1")
	public String getCategorias()
	{
		return categorias;
	}
	
	public void setCategorias(String categorias)
	{
		this.categorias=categorias;
	}	

    private int cantPuertas ;
	
	@RegEx(validation = "\\w[@&:\\-\\,\\.\\+ \\w]*")
	@MemberOrder(sequence="2")
	public int getCantPuertas()
	{
		return cantPuertas;
	}
	
	public void setCantPuertas(int cantPuertas)
	{
		this.cantPuertas=cantPuertas;
	}	
     
	private int cantPlazas ;
	@RegEx(validation = "\\w[@&:\\-\\,\\.\\+ \\w]*")
	@MemberOrder(sequence="3")
	public int getCantPlazas()
	{
		return cantPlazas;
	}
	
	public void setCantPlazas(int cantPlazas)
	{
		this.cantPlazas=cantPlazas;
	}
	
	private Caja caja;
	@DescribedAs("Señala tipo de caja del vehiculo.")
	@RegEx(validation = "\\w[@&:\\-\\,\\.\\+ \\w]*")
	@MemberOrder(sequence="4")
	public Caja getCaja()
	{
		return caja;
	}
	
	public void setCaja(Caja caja)
	{
		this.caja=caja;
	}
	
	private Direccion direccion;
	@DescribedAs("Señala tipo de direccion del vehiculo.")
	@RegEx(validation = "\\w[@&:\\-\\,\\.\\+ \\w]*")
	@MemberOrder(sequence="5")
	public Direccion getDireccion()
	{
		return direccion;
	}
	
	public void setDireccion(Direccion direccion)
	{
		this.direccion=direccion;
	}
	
	private Traccion traccion;
	@DescribedAs("Señala tipo de traccion del vehiculo.")
	@RegEx(validation = "\\w[@&:\\-\\,\\.\\+ \\w]*")
	@MemberOrder(sequence="6")
	
	public Traccion getTraccion()
	{
		return traccion;
	}
	
	public void setTraccion(Traccion traccion)
	{
		this.traccion=traccion;
	}
	
	private int precio;
	@DescribedAs("El precio de la categoria.")
    @RegEx(validation = "\\w[@&:\\-\\,\\.\\+ \\w]*")
    @MemberOrder(sequence = "7")
	public int getPrecio()
	{
		return precio;
	}
	public void setPrecio(int precio)
	{
		this.precio=precio;
	}
	
   /* private SortedSet<Categoria> dependencies = new TreeSet<Categoria>();

    @Disabled
    @MemberOrder(sequence = "1")
    @Resolve(Type.EAGERLY)
    public SortedSet<Categoria> getDependencies()
    {
        return dependencies;
    }*/

    /*public void setDependencies(final SortedSet<Categoria> dependencies) 
    {
        this.dependencies = dependencies;
    }*/
   
    /*public Categoria Add(final Categoria toDoItem) 
    {
       getDependencies().add(toDoItem);
        return this;
    }*/
	
   
    @SuppressWarnings("unused")
    private DomainObjectContainer container;

    public void setDomainObjectContainer(final DomainObjectContainer container) 
    {
        this.container = container;
    }
    // }}
    
}