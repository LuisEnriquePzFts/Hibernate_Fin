package modelo;

import configuracion.HibernateUtil1;
import java.util.List;
import javax.persistence.OneToMany;
import net.sf.ehcache.hibernate.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.cfg.AnnotationConfiguration;

public class Operaciones {
    
    private Session session;

    private void inicioOperacion() {
        SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        session = sessionFactory.openSession();
        session.getTransaction().begin();
    }

    private void terminaOperacion() {
        session.getTransaction().commit();
        session.close();
    }

    public String guardarAlumno(Alumno alu) {
        String cveAlu = "";
        inicioOperacion();
        cveAlu = (String) session.save(alu);
        terminaOperacion();
        return cveAlu;
    }

    public String guardarGrupo(Grupo grup) {
        String cveGru = "";
        inicioOperacion();
        cveGru = (String) session.save(grup);
        terminaOperacion();
        return cveGru;
    }

    public void actualizarGrupo(Grupo grup) {
        inicioOperacion();
        session.update(grup);
        terminaOperacion();
    }

    public void actualizarAlumno(Alumno alu) {
        inicioOperacion();
        session.update(alu);
        terminaOperacion();
    }
    
    @OneToMany(mappedBy = "grupo")
    @Cascade({CascadeType.DELETE})
    
    public boolean eliminarGrupo(String cveGru) {
//        inicioOperacion();
//        List<Alumno> result;
//
//        result = session.createQuery("from Alumno").list();
//
//        result.forEach((a) -> {
//            session.delete(a);
//        });
//        
//        session.delete(grup);
//        terminaOperacion();

        SessionFactory sf = null;
        Session sesion = null;
        Transaction tx = null;
        try {
            sf= HibernateUtil1.getSessionFactory();
            sesion= sf.openSession();
            tx = sesion.beginTransaction();
            Grupo g = (Grupo) sesion.get(Grupo.class, cveGru);
            sesion.delete(g);
             Query query = sesion.createQuery("Delete Alumno where cveGru = :cveGru");
             query.setParameter("cveGru", cveGru);
             query.executeUpdate();
            tx.commit();
            sesion.close();
            return true;
            
        } catch (Exception e) {
            tx.rollback();
            return false;
        }
    }        
    
   
    public void eliminarAlumno(Alumno alu) {
        inicioOperacion();
        session.delete(alu);
        terminaOperacion();
    }

    public Grupo obtenerGrupo(String cveGru) {
        Grupo grup = null;
        inicioOperacion();
        grup = (Grupo) session.get(Grupo.class, cveGru);
        terminaOperacion();
        return grup;
    }

    public Alumno obtenerAlumno(String cveAlu) {
        Alumno alu = null;
        inicioOperacion();
        alu = (Alumno) session.get(Alumno.class, cveAlu);
        terminaOperacion();
        return alu;
    }

    public List<Grupo> ListaGrupo() {
        List<Grupo> listaGrupo = null;
        inicioOperacion();
        listaGrupo = session.createQuery("from Grupo").list();
        terminaOperacion();

        return listaGrupo;
    }

    public List<Alumno> ListaAlumno() {
        List<Alumno> listaAlumno = null;
        inicioOperacion();
        listaAlumno = session.createQuery("from Alumno").list();
        terminaOperacion();

        return listaAlumno;
    }

    public List<Grupo> cargarCombo() {
        List<Grupo> listaGrupos = null;
        inicioOperacion();
        listaGrupos = session.createQuery("from Grupo").list();
        terminaOperacion();

        return listaGrupos;
    }   
}
