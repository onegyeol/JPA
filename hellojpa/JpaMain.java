package hellojpa;

import jakarta.persistence.*;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        //persistence.xml 파일의 persistence-unit의 name 이름 적어줌
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin(); //데이터베이스 트랜잭션 시작

        try{
            //영속
            Member member = new Member(200L, "member200");
            em.persist(member);
            em.flush();
            System.out.println("=================");
            tx.commit(); //트랜잭션에 커밋해줌
        } catch(Exception e){
            tx.rollback();
        } finally{
            em.close();
        }
        emf.close();
    }
}
