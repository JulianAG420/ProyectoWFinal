
package Proyecto_Grupo4.Service;


import Proyecto_Grupo4.Entity.Empleado;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author yulien
 */
@Service
public interface  IEmpleadoService {
      public List<Empleado> getAllEmpleados();
    public Empleado getEmpleadoById (long id);
    public void saveEmpleado(Empleado empleado);
    public void delete (long id);
}
