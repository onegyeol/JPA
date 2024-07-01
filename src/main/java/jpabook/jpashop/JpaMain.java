package jpabook.jpashop;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;

public class JpaMain {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); //애플리케이션 전체에 한개만 생성됨
        EntityManager em = emf.createEntityManager(); //고객 요청 올때마다 사용하고 버리기 반복

        EntityTransaction tx = em.getTransaction(); //jpa의 모든 데이터 변경은 트랜잭션 안에서 진행필요
        tx.begin(); //db 트랜잭션 시작
        try{

            Order order = em.find(Order.class, 1L);
            Long memberId = order.getMemberId();


            tx.commit();
        }catch(Exception e){
            tx.rollback();
        }finally{
            em.close();
        }

        emf.close();
    }
}
