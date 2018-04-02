/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Jobs;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import tools.HibernateUtil;

/**
 *
 * @author Ignatius
 */
public class JobsDAO {
    public Session session;
    private SessionFactory factory;
    public Transaction transaction;
    public FunctionsDAO fdao;

    public JobsDAO() {
        this.fdao = new FunctionsDAO(HibernateUtil.getSessionFactory());
    }
    
    public List<Object> getAll(){
        String query = "FROM Jobs";
        return fdao.getAll(query);
    }
    
        /**
     * Fungsi untuk mengambil berdasarkan ID yang ada di tabel Jobs
     
     * @return data
     * /getById() berdasarkan Jobs Id
      
     */

    public Object getById(String id) {
        Object data = new Object();
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            data = session.createQuery("FROM Jobs WHERE job_id = " + id).uniqueResult();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }

        return data;
    }
    
        /**
     * Fungsi untuk mengupdate data pada tabel JOBS
     
     * @return flag
     * /update berdasarkan Jobs Id
      
     */

    public boolean update(Object object) {
        boolean flag = false;
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            Jobs jobs = (Jobs) object;
            Jobs jj = (Jobs) session.get(Jobs.class, jobs.getJobId());
            jj.setJobTitle(jobs.getJobTitle());
            jj.setMaxSalary(jobs.getMaxSalary());
            jj.setMinSalary(jobs.getMinSalary());
            session.update(jj);
            flag = true;
        } catch (Exception e) {
            if (transaction!=null) transaction.rollback();
        } finally {
            session.close();
        } return flag;
    }
    
}