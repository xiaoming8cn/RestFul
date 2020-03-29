/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.service;

import java.util.List;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import student.Student;

/**
 *
 * @author xiaoming
 */
@Stateless
@Path("student.student")
public class StudentFacadeREST extends AbstractFacade<Student> {

    @PersistenceContext(unitName = "NameedQueryTutorialPU")
    private EntityManager em;

    public StudentFacadeREST() {
        super(Student.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Student entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Student entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Student find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Student> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Student> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    @GET
    @Path("findByStudname/{studname}")
    @Produces({"application/json"})
    public List<Student> findByStudname(@PathParam("studname") String
    studname) {
    Query query = em.createNamedQuery("Student.findByStudname");
    query.setParameter("studname", studname);
    return query.getResultList();
    }

    /**
     *
     * @return
     */
    @GET
    @Path("findByLikePostcode")
    @Produces({"application/json"})
    public List<Student> findByLikePostCode() {
    Query query = em.createNamedQuery("Student.findByLikePostcode");
    return query.getResultList();
    }

    @GET
    @Path("findByCourse2/{courseid}")
    @Produces({"application/json"})
    public List<Student> findByCourse2(@PathParam("courseid") Integer courseid) {
    TypedQuery<Student> q = em.createQuery("SELECT s FROM Student s WHERE s.courseid.courseid = :courseid", Student.class);
    q.setParameter("courseid", courseid);
    return q.getResultList();
    } 
    @GET
    @Path("findByCourseName/{coursename}")
    @Produces({"application/json"})
    public List<Student> findByCourseName(@PathParam("coursename") String
    coursename) {
    TypedQuery<Student> q = em.createQuery("SELECT s FROM Student s WHERE s.courseid.coursename = :coursename", Student.class);
    q.setParameter("coursename", coursename);
    return q.getResultList();
    }
     
 }
