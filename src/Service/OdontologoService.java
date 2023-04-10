package Service;

import Dao.IDao;
import Dao.Imp.OdontologoDAOH2;
import Models.Odontologo;
import org.apache.log4j.Logger;
import java.util.List;

public class OdontologoService {

    public static Logger logger = Logger.getLogger(OdontologoDAOH2.class);
    private IDao<Odontologo> OdontologoDao = new OdontologoDAOH2();
    public IDao<Odontologo> getOdontologoDao() {
        return OdontologoDao;
    }

    public void setOdontologoDao(IDao<Odontologo> odontologoDao) {
        OdontologoDao = odontologoDao;
    }

    public Boolean guardar(Odontologo odontologo){
        boolean odontologoRegistrado = false;
        if (OdontologoDao.guardar(odontologo)!= null){
            odontologoRegistrado = true;
        }
        return odontologoRegistrado;
    }

    public List<Odontologo> listar() {
        List<Odontologo> odontologos = null;
        if (OdontologoDao.listar()!=null){
            odontologos = OdontologoDao.listar();
            logger.info("la lista se creo correctamente");
        }
        return odontologos;
    }
}
