package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        // 트랜잭션 처리
        EntityTransaction tx = em.getTransaction();
        // 트랜잭션 시작
        tx.begin();

        try {
            List<Member> result = em.createQuery(
                    "select m from Member m where m.username like '%kim%'", Member.class
            ).getResultList();

            for (Member member : result) {
                System.out.println("member = " + member);
            }

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }

    
/*    // Member 만 가져오고 싶은 메소드
    private static void printMember(Member findMember) {
        System.out.println("member = " + findMember.getUsername());
    }

    // Member 와 Team 을 다 출력하고 싶을때
    public static void printMemberAndTeam(Member member) {
        String username = member.getUsername();
        System.out.println("username = " + username);

        Team team = member.getTeam();
        System.out.println("team = " + team.getName());
    }*/
}
