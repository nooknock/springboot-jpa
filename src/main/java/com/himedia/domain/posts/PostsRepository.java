package com.himedia.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

//Posts 클래스로 Database를 접근하게 해줄 JpaRepository, 보통 iBatis나 MyBatis에서 사용하는 DAO라고 불리는 DB Layer 접근자, JPA에서는
// Repository라고 부르며 인터페이스로 생성, 단순히 인터페이스를 생성 후 JpaRepository<엔티티 클래스타입, 프라이머리키타입>를 상속하면 기본적인
// CURD 메소드가 자동으로 생성, @Repository를 추가할 필요도 없으나 주의할 점은 Entity 클래스와 기본 Entity Repository는 함께 위치해야 한다, 엔티티 클래스는 기본 레파지토리 없이는 제대로 역할을 할 수가 없다. 도메인 패키지에서 함께 관리 되어야 함
public interface PostsRepository extends JpaRepository<Posts, Long> {
}
