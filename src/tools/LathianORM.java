package tools;

import dao.CountriesDAO;
import dao.EmployeesDAO;
import dao.JobsDAO;
import dao.DepartmentsDAO;
import dao.LocationsDAO;
import entities.Countries;
import entities.Locations;
import entities.Departments;
import entities.Employees;
import entities.Jobs;
import java.util.Date;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ignatius
 */
public class LathianORM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        System.out.println();
//        List<Object> data = new EmployeesDAO()
//                .getAll();
//        data = new EmployeesDAO().search(
//                "lastName", "King");
//        for (Object object : data) {
//            Employees emp = (Employees) object;
//            System.out.println(emp.getFirstName()
//            +" "+emp.getLastName());
//        }
//        Employees emp = (Employees) 
//                new EmployeesDAO()
//                        .getById("100");
//        System.out.println(emp.getFirstName()
//        +" "+emp.getLastName()+" ");
//        +emp.getDepartmentId().getDepartmentName());
        
//        emp = new Employees
//        (207, "Santosa", "joekelir", new Date());
//        emp.setJobId(new Jobs("AD_PRES"));
//        System.out.println(new EmployeesDAO()
//                .insert(emp));
//        System.out.println(new EmployeesDAO()
//                .delete(207));
//        emp.setFirstName("Ignatius");
//        System.out.println(new EmployeesDAO()
//                .update(emp));
//        
//        System.out.println(Employees.class);

//        for (Object object : new JobsDAO().getAll()) {
//            Jobs jobs = (Jobs) object;
//            System.out.println(jobs.getJobId()+" "+jobs.getJobTitle()+" "
//                    +jobs.getMaxSalary()+" "+jobs.getMinSalary()+" ");
//        }
//        
//        Countries countries = new Countries("NS", "Nusantara");
//        System.out.println(new CountriesDAO().insert(countries));

          Departments dep = (Departments) new DepartmentsDAO().getById("15");
          System.out.println(dep.getDepartmentName());
          
          List <Object> datas = new LocationsDAO().getAll();
          datas = new LocationsDAO().search("CITY", "Roma");
          for (Object data : datas) {
            Locations loc = (Locations) data;
            System.out.println(" Alamat Jalan: " + loc.getStreetAddress() + "| Kode Pos: " + loc.getPostalCode());   
        }
          
              //getById() berdasarkan employee Id
        Jobs jb = (Jobs) new JobsDAO().getById("PR_REP");;
        System.out.println(jb.getJobTitle()+ " " + jb.getMaxSalary());
        
        /**
         * update jobs
         */
        
                jb.setJobId(new Jobs("AD_PRES")+"");
                jb.setJobTitle("Pembantu Presiden");
                System.out.println(new JobsDAO().update(jb));
        /*
        Insert Countries
        */
        Countries countries = new Countries("NS", "Nusantara");
        System.out.println(new CountriesDAO().insert(countries));
        /**
         * Delete Countries
         */
        countries = new Countries("NS");
        System.out.println(new CountriesDAO().delete("NS"));
        
        
        
    }
    }
    

